package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SegundaEtapa extends HBox {

	private Stage stage;
	private VistaTablero mapView;
	private VistaJugador player1;
	private VistaJugador player2;
	private Juego juego;
	private FinDeJuego finDeJuego;
	private HBox head ;

	public SegundaEtapa(Juego juego, Stage stage, VistaTablero mapView) {
		this.juego = juego;
		this.stage = stage;
		this.mapView = mapView;
		this.player1 =  new VistaJugador(juego.getJugador1());
	 	this.player2 =  new VistaJugador(juego.getJugador2());
		this.player1.setMostrarCreditos(false);
		this.player2.setMostrarCreditos(false);
		this.finDeJuego = new FinDeJuego(juego, stage, mapView);
	}

	public void iniciarFase(){
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
		terminarJuego(head);
		turnOf(head);
		this.head = head;
		return head;
	}

	public void actualizarVista() {
		this.player1.actualizarVista();
		this.player2.actualizarVista();
		this.mapView.actualizarVista();
	}

	public void cambioTurno() {
		this.actualizarVista();

		head.getChildren().remove(1);
		this.juego.pasarTurno();
		turnOf(head);

		this.actualizarVista();
	}

	public void turnOf(HBox head){
		Button button = new Button("TURNO DE: "+this.juego.getJugadorActivo().getNombre());
		button.setStyle("-fx-background-color:#F7CF32");
		head.getChildren().add(button);
	}

	public void terminarJuego(HBox head) {

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
