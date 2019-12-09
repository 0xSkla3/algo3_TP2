package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.Getter;
import lombok.Setter;

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
	String bando;


	public CrearPiezaHandler(String pieza, Juego juego, int x, int y, String bando){
		this.juego = juego;
		this.bando = bando;
		this.ubicacion = new Ubicacion(x,y);
		this.pieza = juego.crearPieza(pieza, ubicacion, bando);

	}

	@Override
	public void handle(ActionEvent actionEvent) {

	}
}
