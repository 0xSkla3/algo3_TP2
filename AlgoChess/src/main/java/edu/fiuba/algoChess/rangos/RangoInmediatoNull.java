package edu.fiuba.algoChess.rangos;

import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.Pieza;
import edu.fiuba.algoChess.Tablero;

import java.util.ArrayList;

public class RangoInmediatoNull implements RangoNull {


	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		return null;
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {

	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		return null;
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public Batalloneable darDeAltaBatallon() {
		return null;
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		return null;
	}
}
