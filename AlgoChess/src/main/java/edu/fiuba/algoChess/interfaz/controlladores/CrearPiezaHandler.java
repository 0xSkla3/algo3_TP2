package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPiezaEnSectoRival;
import edu.fiuba.algoChess.Modelo.juego.Juego;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class CrearPiezaHandler implements EventHandler<ActionEvent> {

	@Getter
	@Setter
	Pieza pieza;

	@Getter
	@Setter
	Juego juego;

	@Getter
	@Setter
	Ubicacion ubicacion;

	@Getter
	@Setter
	Boolean jugador1 = true;


	public CrearPiezaHandler(String pieza, Juego juego, int x, int y){

		this.juego = juego;
		this.ubicacion = new Ubicacion(x,y);
		this.pieza = juego.crearPieza(pieza, ubicacion);

	}

	@Override
	public void handle(ActionEvent actionEvent) {

	}
}
