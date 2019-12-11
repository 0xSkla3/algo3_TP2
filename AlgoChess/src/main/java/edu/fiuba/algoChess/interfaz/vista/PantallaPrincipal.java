package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.entidades.Catapulta;
import edu.fiuba.algoChess.Modelo.entidades.Jinete;
import edu.fiuba.algoChess.Modelo.entidades.Soldado;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.controlladores.UbicarPiezaHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;

import java.util.HashMap;

public class PantallaPrincipal {

	private final HashMap<String, Class> listaPiezas;
	@Getter
	private Stage stage;
	private PieceView pieceView;
	private MapView mapView;
	private PlayerView player1;
	private PlayerView player2;
	private PlayerView turn;
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
		this.pieceView = new PieceView( listaImage, juego, this);
		this.mapView = new MapView(juego);//tamanio del tablero
		this.listaPiezas = new HashMap<>();

		//this.player1 =  new PlayerView(jugador1,new BandoJugador1());
		//this.player2 =  new PlayerView(jugador2,new BandoJugador2());

		this.player1 =  new PlayerView(juego.getJugador1());
		this.player2 =  new PlayerView(juego.getJugador2());

		this.segundaEtapa = new SegundaEtapa( juego,jugador1,jugador2, stage, pieceView, mapView, turn);
		this.finDeJuego = new FinDeJuego(juego,jugador1,jugador2, stage, pieceView, mapView);
		this.pantallaPrincipal = this;

		initialPhase();
	}
	
	public void initialPhase(){

		this.stage.setTitle("AlgoChess");
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		vbox.getChildren().add(head()); 
	    
		player1.viewPlayer(hbox);
	    hbox.getChildren().add(mapView);
	    player2.viewPlayer(hbox);
	    
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
	    this.listaPiezas.put("Soldado", Soldado.class);
	    menuPiece(soldado, "Soldado" ,head);
	    
	    Image imgJinete = new Image("imagenes/jinete.jpeg",80,80,false,false);
	    ImageView jinete = new ImageView(imgJinete);
		this.listaPiezas.put("Jinete", Jinete.class);
	    menuPiece(jinete, "Jinete" ,head);
	    
	    Image imgCatapulta = new Image("imagenes/catapulta.jpeg",80,80,false,false);
	    ImageView catapulta = new ImageView(imgCatapulta);
		this.listaPiezas.put("Catapulta", Catapulta.class);
	    menuPiece(catapulta, "Catapulta",head);
	    
	    Image imgCurandero = new Image("imagenes/curandero.jpeg",80,80,false,false);
	    ImageView curandero= new ImageView(imgCurandero);
	    menuPiece(curandero, "Curandero",head);

	    head.getChildren().addAll(soldado,jinete,catapulta,curandero);
		terminarJuego(head,juego);
		terminarDeColocarPiezas(head,juego);
		turnOf(head,player1);
		this.head = head;
	    return head;
	}
	
	public void menuPiece(ImageView pieza,String nombrePieza,HBox head) {
	
		pieza.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Stage stageUbicar = new Stage();
			VBox vbox = new VBox();

			Label labelx = new Label("Ubicacion x:");
			TextField x = new TextField ();
			HBox hbx = new HBox();
			hbx.getChildren().addAll(labelx, x);
			hbx.setSpacing(10);

			Label labely = new Label("Ubicacion y:");
			TextField y = new TextField ();
			HBox hby = new HBox();
			hby.getChildren().addAll(labely, y);
			hby.setSpacing(10);

			Button submit = new Button("ubicar");
			submit.setStyle("-fx-background-color:#F1C40F;");
			submit.setOnAction(new UbicarPiezaHandler(juego, stage, stageUbicar, pieceView,
					nombrePieza, pantallaPrincipal, listaPiezas, mapView, head, x, y, turn.getBandoJugador()));
			vbox.getChildren().addAll(hbx,hby,submit);
			Scene sceneUbicar = new Scene(vbox);
			stageUbicar.setScene(sceneUbicar);
			stageUbicar.show();
		});
	}
	
	public void cambioTurno(HBox head, String namePiece) {
		head.getChildren().remove(6);

		this.player1.updateView();
		this.player2.updateView();
		
		this.turn.setPiece(pieceView.getImageViewMax(namePiece));
		if(this.turn == player1) {
			turnOf(head,player2);
			this.juego.pasarTurno();
		}
		else {
			turnOf(head,player1);
			this.juego.pasarTurno();
		}
	}
	
	public void turnOf(HBox head,PlayerView player){
		this.turn = player;
		Button button = new Button("TURNO DE: " + player.getName());
		button.setStyle("-fx-background-color:#F7CF32");
		//this.turnoDe = button;
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
