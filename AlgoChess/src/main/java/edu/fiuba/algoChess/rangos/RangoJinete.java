package edu.fiuba.algoChess.rangos;

import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.entorno.Tablero;

import java.util.ArrayList;

public class RangoJinete implements Rango{
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
