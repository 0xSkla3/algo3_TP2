package edu.fiuba.algoChess.interfaz.vista;


import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.juego.Jugador;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayerView {
	private VBox playerBox;
 	private Jugador player;
	private Text name;
	private Text credits;

	public PlayerView(Jugador player) {

		this.player = player;
		this.playerBox = new VBox();
	 	playerBox.setStyle("-fx-spacing:15;-fx-alignment:center");
	}
	
	public void viewPlayer(HBox hbox) {
		this.playerBox.setId("player");
		this.name = new Text();
		this.name.setStyle("-fx-font-size:50px");
		this.playerBox.getChildren().add(this.name);
		this.credits = new Text();
		this.credits.setStyle("-fx-font-size:30px");
		this.playerBox.getChildren().add(this.credits);
		hbox.getChildren().add(playerBox);
		this.updateView();
	}

	public void updateView() {
	// FIXME: sacar esto si se garantiza que no se llama antes de viewPlayer()
	 if(this.name == null)
	 return;
	 this.name.setText(this.player.getNombre());
	 this.credits.setText("Créditos: " + Integer.toString(this.player.getCreditos()));
 }
	
	public void setPiece(ImageView piece) {
		this.playerBox.getChildren().add(piece);
	}
	
	public String getName() {
		return this.player.getNombre();
	}

	//public void setBando(Bando bandoJugador) { this.bandoJugador = bandoJugador; }

	public Bando getBandoJugador(){
		return this.player.getBando();
	}

	public String nombreBando() {
		return this.player.getBando().getClass() == BandoJugador1.class ? "jugador1" : "jugador2";
	}
}
