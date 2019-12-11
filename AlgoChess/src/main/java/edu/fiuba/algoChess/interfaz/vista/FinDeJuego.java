package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;

public class FinDeJuego {

	private final HashMap<String, Class> listaPiezas;
	private Stage stage;
	private PieceView pieceView;
	private MapView mapView;
	private PlayerView player1;
	private PlayerView player2;
	private PlayerView turn;
	private HashMap<String,String> listaImage;
	private Juego juego;

	public FinDeJuego(Juego juego, String jugador1, String jugador2, Stage stage, PieceView pieceView,
						MapView mapView) {

		this.juego = juego;
		this.stage = stage;
		this.pieceView = pieceView;
		this.mapView = mapView;
		this.listaPiezas = new HashMap<>();

		this.player1 =  new PlayerView(jugador1,new BandoJugador1());
		this.player2 =  new PlayerView(jugador2,new BandoJugador2());
	}

	public void iniciarFase(){
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
		mensajeFin(head);
		return head;
	}

	public void mensajeFin(HBox head){

		Button button = new Button("Partida Terminada, gracias por jugar");
		button.setStyle("-fx-background-color:#F7CF32");
		head.getChildren().add(button);

	}
}
