package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class MenuComportamiento {

	@Getter
	@Setter
	Pieza emisor;

	@Getter
	@Setter
	Pieza receptor;

	@Getter
	@Setter
	Tablero tablero;


	@Getter
	@Setter
	ImageView imageView;

	@Getter
	@Setter
	MapView mapView;


	MenuComportamiento(Pieza emisor, Pieza receptor, Tablero tablero, ImageView imagenPieza , MapView map){
		this.emisor = emisor;
		this.receptor = receptor;
		this.tablero = tablero;
		this.imageView = imagenPieza;
		this.mapView = map;
	}

	public void menuComportamientoSoldado(){

		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button atacar = new Button("Atacar");
		atacar.setStyle("-fx-background-color:#F1C40F;");
		atacar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				atacar(emisor, receptor);
				stage.close();
			}
		});

		Button batallonear = new Button("Generar Batallon");
		batallonear.setStyle("-fx-background-color:#F1C40F;");
		batallonear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				generarBatallon(emisor);
				stage.close();
			}
		});

		vbox.getChildren().addAll(atacar,batallonear);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	private void generarBatallon(Pieza emisor) {
		emisor.darDeAltaBatallon();
	}

	public void MenuAtaqueBatallon(){

	}

	public void MenuAtaqueJinete(){

	}


	public void MenuAtaqueCatapulta(){

	}

	private void atacar(Pieza atacante, Pieza atacado) {
		atacante.atacar(atacado);
	}



	private void curar(Pieza curador, Pieza curado) {
		curador.curar(curado);
	}

}
