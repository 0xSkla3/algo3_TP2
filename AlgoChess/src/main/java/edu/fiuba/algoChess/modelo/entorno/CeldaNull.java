package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.entidades.PiezaNull;

public class CeldaNull extends Celda {

	CeldaNull(){
		this.piezaActual = new PiezaNull();
		this.sectorDelJugador = null;
	}
}
