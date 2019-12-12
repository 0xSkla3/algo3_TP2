package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeAtacarUnAliadoException;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeObtenerUnaPiezaDeCeldaaNull;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPiezaEnSectoRival;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;

import javax.swing.*;
import java.util.Optional;


@AllArgsConstructor
public class AtacarPiezaHandler implements EventHandler<ActionEvent> {

	Tablero tablero;
	Pieza emisor;
	TextField tFX;
	TextField tFY;

	@Override
	public void handle(ActionEvent actionEvent) {
		int x = Integer.parseInt((tFX.getText()));
		int y = Integer.parseInt((tFY.getText()));
		try {
			Pieza receptor = tablero.getCelda(new Ubicacion(x,y)).getPiezaActual();
			if(receptor.getClass() != PiezaNull.class){
			emisor.atacar(receptor);
			alerta3seg("Ataque", "Ataque efectuado, vida restante del oponente: " + receptor.getVida().getValorActual());}
		} catch(NoSePuedeAtacarUnAliadoException exc){
			alerta3seg("Ataque a un Aliado", "No se puede atacar a un aliado");
		} catch(NoSePuedeObtenerUnaPiezaDeCeldaaNull ex){
			alerta3seg("Ataque a vacio", "No se puede atacar a una celda vacia");
		}
	}

	public void alerta3seg(String Titulo, String Texto){

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(Titulo);
		alert.setHeaderText(Texto);

		Thread thread = new Thread(() -> {
			try {

				Thread.sleep(3000);
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
