package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.interfaz.controlladores.*;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
public class MenuMovimiento {
	Pieza pieza;
	Tablero tablero;
	SegundaEtapa segundaEtapa;

	public void menuPopUp(){
		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button arriba = new Button("Mover arriba");
		arriba.setStyle("-fx-background-color:#F1C40F;");
		arriba.setOnAction(e -> {
			try {

				pieza.moverseAbajo(tablero); //en el tablero se visualiza al reves
				segundaEtapa.cambioTurno();
				stage.close();

			} catch (NoSePuedeUbicarPorqueEstaOcupadoException exc){
					DialogoAlerta.Alerta("Movimiento Invalido",
					"La pieza no se puede mover hacia arriba porque el casillero esta ocupado", 3);
			}
		});

		Button abajo = new Button("Mover abajo");
		abajo.setStyle("-fx-background-color:#F1C40F;");
		abajo.setOnAction(e -> {
			try {

				pieza.moverseArriba(tablero); //el tablero se visualiza al reves
				segundaEtapa.cambioTurno();
				stage.close();

			} catch (NoSePuedeUbicarPorqueEstaOcupadoException exc){
				DialogoAlerta.Alerta("Movimiento Invalido",
				"La pieza no se puede mover hacia abajo porque el casillero esta ocupado", 3);

				}
		});

		Button izquierda = new Button("Mover izquierda");
		izquierda.setStyle("-fx-background-color:#F1C40F;");
		izquierda.setOnAction(e -> {
			try {

				pieza.moverseALaIzquierda(tablero);
				segundaEtapa.cambioTurno();
				stage.close();

			} catch (NoSePuedeUbicarPorqueEstaOcupadoException exc){
				DialogoAlerta.Alerta("Movimiento Invalido",
				"La pieza no se puede mover hacia la izquierda porque el casillero esta ocupado", 3);
			}
		});

		Button derecha = new Button("Mover derecha");
		derecha.setStyle("-fx-background-color:#F1C40F;");
		derecha.setOnAction(e -> {
			try {

				pieza.moverseALaDerecha(tablero);
				segundaEtapa.cambioTurno();
				stage.close();

			} catch (NoSePuedeUbicarPorqueEstaOcupadoException exc){
				DialogoAlerta.Alerta("Movimiento Invalido",
				"La pieza no se puede mover hacia la derecha porque el casillero esta ocupado", 3);
			}
		});

		vbox.getChildren().addAll(arriba,abajo,izquierda,derecha);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();
	}
}