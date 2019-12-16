package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class MenuPieza {
	Juego juego;
	Pieza pieza;
	MenuMovimiento menuMovimiento;
	MenuComportamiento menuComportamiento;
	SegundaEtapa segundaEtapa;
	String piezaNombre;

	public MenuPieza(Juego juego, Pieza pieza, SegundaEtapa segundaEtapa) {
		this.pieza = pieza;
		menuMovimiento = new MenuMovimiento(pieza, juego.getTablero(), segundaEtapa);
		menuComportamiento = new MenuComportamiento(juego, pieza, segundaEtapa);
		this.segundaEtapa = segundaEtapa;

		this.piezaNombre = pieza.getClass().getSimpleName();
	}

	public void menuPopUp() {

		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button moverse = new Button("Moverse");
		moverse.setStyle("-fx-background-color:#F1C40F;");
		try {

			moverse.setOnAction(e -> {
				if(!piezaNombre.contains("Catapulta")) {
					this.menuMovimiento.menuPopUp();
				}
				stage.close();
			});

		} catch (NoSePuedeUbicarPorqueEstaOcupadoException exc){

			DialogoAlerta.Alerta("Movimiento Invalido",
					"No se puede ubicar la pieza porque esta ocupada la celda", 3);

		}

		Button interactuar = new Button("interactuar");
		interactuar.setStyle("-fx-background-color:#F1C40F;");
		interactuar.setOnAction(e -> {
			elegirMenuInteraccion();
			stage.close();
		});

		Button pasar = new Button("Pasar turno");
		pasar.setStyle("-fx-background-color:#F1C40F;");
		pasar.setOnAction(e -> {
			segundaEtapa.cambioTurno();
			stage.close();
		});

		vbox.getChildren().addAll(moverse, interactuar, pasar);

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
