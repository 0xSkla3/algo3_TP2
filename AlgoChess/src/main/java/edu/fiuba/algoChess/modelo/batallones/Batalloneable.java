package edu.fiuba.algoChess.modelo.batallones;

import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.rangos.Rango;

import java.util.ArrayList;

public interface Batalloneable extends Rango {

	@Override
	Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero);

	@Override
	void actualizaPiezasEnRango(Pieza piezaCentral);

	@Override
	ArrayList<Pieza> getPiezasEnRango();

}

