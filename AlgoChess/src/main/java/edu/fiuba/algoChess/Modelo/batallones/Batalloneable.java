package edu.fiuba.algoChess.Modelo.batallones;

import edu.fiuba.algoChess.Modelo.entidades.Movible;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.rangos.Agrupable;
import edu.fiuba.algoChess.Modelo.rangos.Rango;

import java.util.ArrayList;
import java.util.Collection;

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

