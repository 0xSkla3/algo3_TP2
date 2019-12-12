package edu.fiuba.algoChess.Modelo.entorno;

import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeObtenerUnaPiezaDeCeldaaNull;

public class CeldaNull extends Celda {

	CeldaNull(){
		this.piezaActual = new PiezaNull();
		this.sectorDelJugador = null;
	}
}
