package edu.fiuba.algoChess.modelo.batallones;

import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.rangos.Agrupable;
import edu.fiuba.algoChess.modelo.rangos.Rango;

import java.util.ArrayList;

public interface Batalloneable extends Agrupable {

	@Override
	Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3);

	@Override
	Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero);

	@Override
	void actualizaPiezasEnRango(Pieza piezaCentral);

	@Override
	ArrayList<Pieza> getPiezasEnRango();

}

