package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

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
	ImageView imagenPieza;

	@Getter
	@Setter
	MapView mapView;

	MenuComportamiento(Juego juego, Pieza emisor, Tablero tablero, ImageView imagenPieza , MapView map){
		this.emisor = emisor;
		this.receptor = juego.getReceptor();
		this.tablero = tablero;
		this.imagenPieza = imagenPieza;
		this.mapView = map;
	}

	public void menuComportamientoSoldado(){

		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button atacar = new Button("Atacar");
		atacar.setStyle("-fx-background-color:#F1C40F;");
		atacar.setOnAction(e -> {
			getImagenPieza().addEventHandler(MouseEvent.MOUSE_PRESSED,(event)-> atacar(emisor, receptor));
			atacar(emisor, receptor);
			alerta1seg("Ataque", "Soldado Atacó, vida restante del oponente: " + receptor.getVida().getValorActual());
			stage.close();
		});

		Button batallonear = new Button("Generar Batallon");
		batallonear.setStyle("-fx-background-color:#F1C40F;");
		batallonear.setOnAction(e -> {
			generarBatallon(emisor);
			alerta1seg("Batallon", "Batallon Creado");
			stage.close();
		});

		vbox.getChildren().addAll(atacar,batallonear);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	private void generarBatallon(Pieza emisor) {
		emisor.darDeAltaBatallon();
	}

	public void menuComportamientoBatallon() {
	}

	public void menuComportamientoJinete(){
	Stage stage = new Stage();
	VBox vbox = new VBox();

	Button atacar = new Button("Atacar");
		atacar.setStyle("-fx-background-color:#F1C40F;");
		atacar.setOnAction(e -> {
		getImagenPieza().addEventHandler(MouseEvent.MOUSE_PRESSED,(event)-> atacar(emisor, receptor));
		atacar(emisor, receptor);
		alerta1seg("Ataque", "Jinete Atacó, vida restante del oponente: " + receptor.getVida().getValorActual());
		stage.close();
	});

		vbox.getChildren().addAll(atacar);

	Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}


	public void menuComportamientoCatapulta(){
		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button atacar = new Button("Atacar");
		atacar.setStyle("-fx-background-color:#F1C40F;");
		atacar.setOnAction(e -> {
			getImagenPieza().addEventHandler(MouseEvent.MOUSE_PRESSED,(event)-> atacar(emisor, receptor));
			atacar(emisor, receptor);
			alerta1seg("Ataque", "Catapulta Atacó, vida restante del oponente: " + receptor.getVida().getValorActual());
			stage.close();
		});

		vbox.getChildren().addAll(atacar);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	public void menuComportamientoCurandero(){

		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button curar = new Button("Curar");
		curar.setStyle("-fx-background-color:#F1C40F;");
		curar.setOnAction(e -> {
			getImagenPieza().addEventHandler(MouseEvent.MOUSE_PRESSED,(event)-> atacar(emisor, receptor));
			atacar(emisor, receptor);
			alerta1seg("Curacion", "Curandero Curó, vida restante del oponente: " + receptor.getVida().getValorActual());
			stage.close();
		});

		vbox.getChildren().addAll(curar);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	private void atacar(Pieza atacante, Pieza atacado) {
		atacante.atacar(atacado);
	}

	private void curar(Pieza curador, Pieza curado) {
		curador.curar(curado);
	}

	public void alerta1seg(String Titulo, String Texto){

	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(Titulo);
        alert.setHeaderText(Texto);

	Thread thread = new Thread(() -> {
		try {
			Thread.sleep(1000);
			if (alert.isShowing()) {
				Platform.runLater(() -> alert.close());
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	});
        thread.setDaemon(true);
        thread.start();
	Optional<ButtonType> result = alert.showAndWait();
	}
}
