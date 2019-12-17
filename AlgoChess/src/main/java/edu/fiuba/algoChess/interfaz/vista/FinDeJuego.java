package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;

public class FinDeJuego {

	private final HashMap<String, Class> listaPiezas;
	private Stage stage;
	private VistaTablero mapView;
	private VistaJugador player1;
	private VistaJugador player2;
	private VistaJugador turn;
	private HashMap<String,String> listaImage;
	private Juego juego;

	public FinDeJuego(Juego juego, Stage stage, VistaTablero mapView) {

		this.juego = juego;
		this.stage = stage;
		this.mapView = mapView;
		this.listaPiezas = new HashMap<>();

		this.player1 =  new VistaJugador(juego.getJugador1());
		this.player2 =  new VistaJugador(juego.getJugador2());
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
		mensajeFin(head);
		return head;
	}

	public void mensajeFin(HBox head){

		Button button = new Button("Partida Terminada, gracias por jugar");
		button.setStyle("-fx-background-color:#F7CF32");
		head.getChildren().add(button);

	}
}
