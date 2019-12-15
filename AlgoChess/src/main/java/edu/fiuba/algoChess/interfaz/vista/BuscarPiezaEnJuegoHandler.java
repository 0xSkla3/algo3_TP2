package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.juego.Juego;

public class BuscarPiezaEnJuegoHandler {
	Juego juego;
	Ubicacion ubicacionABuscar;

	public BuscarPiezaEnJuegoHandler( Juego juego, int x, int y) {
		this.ubicacionABuscar = new Ubicacion(x, y);
		this.juego = juego;
	}

	public Pieza buscarPiezaEnUbicacion(){
		return this.juego.getTablero().getCelda(this.ubicacionABuscar).getPiezaActual();
	}

}
