package edu.fiuba.algoChess;

import java.util.ArrayList;

public class RangoInmediatoNull implements RangoNull {

	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {

		return new RangoInmediato(piezaCentral,tablero);
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {

	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		return null;
	}
}
