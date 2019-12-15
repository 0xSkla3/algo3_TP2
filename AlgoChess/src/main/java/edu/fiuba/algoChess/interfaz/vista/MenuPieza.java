package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class MenuPieza {

	@Getter
	@Setter
	Juego juego;

	@Getter
	@Setter
	Pieza pieza;

	@Getter
	@Setter
	Tablero tablero;

	@Getter
	@Setter
	ImageView imagenPieza;

	@Getter
	@Setter
	VistaTablero map;

	@Getter
	@Setter
    VistaPieza pieceView;

	@Getter
	@Setter
	String piezaNombre;

	@Getter
	@Setter
	MenuMovimiento menuMovimiento;

	@Getter
	@Setter
	MenuComportamiento menuComportamiento;

	@Getter
	@Setter
	SegundaEtapa segundaEtapa;

	public MenuPieza(Juego juego, Pieza pieza, Tablero tablero, ImageView imagenPieza, VistaTablero map, VistaPieza pieceView, String piezaNombre, SegundaEtapa segundaEtapa) {
		this.piezaNombre = piezaNombre;
		menuMovimiento = new MenuMovimiento(pieza, tablero, imagenPieza, map, pieceView);
		menuComportamiento = new MenuComportamiento(juego, pieza, tablero, imagenPieza, map, segundaEtapa);
		this.segundaEtapa = segundaEtapa;
	}

	public void menuPopUp() {

		Stage stage = new Stage();
		VBox vbox = new VBox();


		Button moverse = new Button("Moverse");
		moverse.setStyle("-fx-background-color:#F1C40F;");
		moverse.setOnAction(e -> {
					if(!piezaNombre.contains("Catapulta")) {
						this.menuMovimiento.menuPopUp();
					}
			stage.close();
		});

		Button interactuar = new Button("interactuar");
		interactuar.setStyle("-fx-background-color:#F1C40F;");
		interactuar.setOnAction(e -> {
			elegirMenuInteraccion();
			stage.close();
		});

		vbox.getChildren().addAll(moverse, interactuar);

		this.segundaEtapa.cambioTurno();
		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	public void elegirMenuInteraccion() {
		if (this.piezaNombre.contains("Soldado")) {
			this.menuComportamiento.menuComportamientoSoldado();
		} else if (this.piezaNombre.contains("Catapulta")) {
			this.menuComportamiento.menuComportamientoCatapulta();
		} else if (this.piezaNombre.contains("Jinete")) {
			this.menuComportamiento.menuComportamientoJinete();
		} else if (this.piezaNombre.contains("Curandero")) {
			this.menuComportamiento.menuComportamientoCurandero();
		}
	}
}
