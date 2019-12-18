package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.excepciones.CeldaYaOcupadaException;
import edu.fiuba.algoChess.modelo.excepciones.UbicacionEnSectorInvalidoException;
import edu.fiuba.algoChess.modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;

import java.util.HashMap;

public class PantallaPrincipal {
	@Getter
	private Stage stage;
	private VistaTablero mapView;
	private VistaJugador player1;
	private VistaJugador player2;
	private HashMap<String,String> listaImage;
	private Juego juego;
	@Getter
	private SegundaEtapa segundaEtapa;
	private FinDeJuego finDeJuego;
	@Getter
	private HBox head ;

	private PantallaPrincipal pantallaPrincipal;
	
	public PantallaPrincipal(String jugador1, String jugador2, Stage stage) {

		this.juego = new Juego(jugador1,jugador2);
		this.stage = stage;
		this.mapView = new VistaTablero(this.juego, this);

//		this.mapView.registerHandler((u) -> DialogoAlerta.Alerta("xxx", Integer.toString(u.getCoordenadaX()) + ", " + Integer.toString(u.getCoordenadaY()), 1));

		this.player1 =  new VistaJugador(juego.getJugador1());
		this.player2 =  new VistaJugador(juego.getJugador2());

		this.segundaEtapa = new SegundaEtapa(juego, stage, mapView);
		this.finDeJuego = new FinDeJuego(juego, stage, mapView);
		this.pantallaPrincipal = this;

		initialPhase();
	}
	
	public void initialPhase(){

		this.stage.setTitle("AlgoChess");
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		vbox.getChildren().add(head()); 
	    
		player1.instanciarVista(hbox);
	    hbox.getChildren().add(mapView);
	    player2.instanciarVista(hbox);
	    
	    vbox.getChildren().add(hbox); 
	    
	    Scene theScene = new Scene(vbox);
	    theScene.getStylesheets().add("css/estilo.css");
	    this.stage.setScene(theScene);
	    this.stage.show();
	}
	
	public HBox head() {
		HBox head = new HBox();
	    head.setId("head");
	    
	    Image imgSoldado = new Image("imagenes/soldado.jpeg",80,80,false,false);
	    ImageView soldado = new ImageView(imgSoldado);
	    menuPiece(soldado, "Soldado" ,head);
	    
	    Image imgJinete = new Image("imagenes/jinete.jpeg",80,80,false,false);
	    ImageView jinete = new ImageView(imgJinete);
	    menuPiece(jinete, "Jinete" ,head);
	    
	    Image imgCatapulta = new Image("imagenes/catapulta.jpeg",80,80,false,false);
	    ImageView catapulta = new ImageView(imgCatapulta);
	    menuPiece(catapulta, "Catapulta",head);
	    
	    Image imgCurandero = new Image("imagenes/curandero.jpeg",80,80,false,false);
	    ImageView curandero= new ImageView(imgCurandero);
	    menuPiece(curandero, "Curandero",head);

	    head.getChildren().addAll(soldado,jinete,catapulta,curandero);
		terminarJuego(head,juego);
		terminarDeColocarPiezas(head,juego);
		turnOf(head);
		this.head = head;
	    return head;
	}
	
	public void menuPiece(ImageView pieza,String nombrePieza,HBox head) {
		pieza.setOnMouseClicked(e -> {
			DialogoAlerta.Alerta("Ubicar pieza", "Seleccione la ubicación de la pieza", 1);
			this.mapView.registrarControlador(ubicacion -> {
				this.mapView.registrarControlador(null);

				try {
					juego.crearPieza(nombrePieza, ubicacion);
					this.cambioTurno(head);
				} catch (UbicacionEnSectorInvalidoException exc) {
					DialogoAlerta.Alerta("Sector rival", "No se puede ubicar la pieza en el sector rival", 2);
				} catch (CeldaYaOcupadaException ex) {
					DialogoAlerta.Alerta("Celda ocupada", "No se puede ubicar la pieza en una celda ocupada", 2);
				}

			});
			}
		);
	}

	public void actualizarVista() {
		this.player1.actualizarVista();
		this.player2.actualizarVista();
		this.mapView.actualizarVista();
	}

	public void cambioTurno(HBox head) {
		head.getChildren().remove(6);

		this.actualizarVista();

		this.juego.pasarTurno();
		turnOf(head);
	}
	
	public void turnOf(HBox head){
		Button button = new Button("TURNO DE: " + this.juego.getJugadorActivo().getNombre());
		button.setStyle("-fx-background-color:#F7CF32");
		head.getChildren().add(button);
	}

	public void terminarDeColocarPiezas(HBox head,Juego juego){

		Button button = new Button("Empezar");
		button.setStyle("-fx-background-color:#F7CF32");
		button.addEventHandler(MouseEvent.MOUSE_PRESSED,
				(event)-> cambioASegundaEtapa());
		head.getChildren().add(button);
	}

	public void cambioASegundaEtapa(){
		this.juego.comenzarSegundoStage();
		this.segundaEtapa.iniciarFase();
	}

	public void terminarJuego(HBox head,Juego juego) {

		Button button = new Button("Terminar Partida");
		button.setStyle("-fx-background-color:#F7CF32");
		button.addEventHandler(MouseEvent.MOUSE_PRESSED,
				(event) -> finalizar());
		head.getChildren().add(button);
	}
		public void finalizar(){
			this.juego.terminarJuego();
			this.finDeJuego.iniciarFase();
		}

}
