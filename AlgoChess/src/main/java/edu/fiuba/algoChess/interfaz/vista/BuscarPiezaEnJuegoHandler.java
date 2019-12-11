package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.juego.Juego;

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
