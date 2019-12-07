package edu.fiuba.algoChess.Modelo.rangos;

import edu.fiuba.algoChess.Modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;

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
	public void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero) {

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
