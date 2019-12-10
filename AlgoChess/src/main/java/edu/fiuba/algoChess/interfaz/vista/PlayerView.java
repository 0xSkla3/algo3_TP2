package edu.fiuba.algoChess.interfaz.vista;


import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayerView {
	private String namePlayer;
	private int points;
	private VBox player;
	private Bando bandoJugador;
	
	public PlayerView(String name, Bando bandoJugador) {
		//crear jugador
		this.namePlayer = name;
		this.points = 20;
		this.player = new VBox();
		this.bandoJugador = bandoJugador;
		player.setStyle("-fx-spacing:15;-fx-alignment:center");
	}
	
	public void viewPlayer(HBox hbox) {
	    this.player.setId("player");
		Text name = new Text(this.namePlayer);
		name.setStyle("-fx-font-size:50px");
		
		
		this.player.getChildren().add(name);
		
		hbox.getChildren().add(player);
	}
	
	public void setPiece(ImageView piece) {
		this.player.getChildren().add(piece);
	}
	
	public String getName() {
		return this.namePlayer;
	}

	//public void setBando(Bando bandoJugador) { this.bandoJugador = bandoJugador; }

	public Bando getBandoJugador(){
		return this.bandoJugador;
	}

	public String nombreBando() {
		return this.bandoJugador.getClass() == BandoJugador1.class ? "jugador1" : "jugador2";
	}
}
