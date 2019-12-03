package edu.fiuba.algoChess.vista;


import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayerView {
	private String namePlayer;
	private int points;
	private VBox player;
	
	public PlayerView(String name) {
		//crear jugador
		this.namePlayer = name;
		this.points = 20;
		this.player = new VBox();
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
}
