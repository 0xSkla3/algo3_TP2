package edu.fiuba.algoChess.Rangos;

import edu.fiuba.algoChess.Batallones.Batalloneable;
import edu.fiuba.algoChess.Pieza;
import edu.fiuba.algoChess.Tablero;

import java.util.ArrayList;

public interface Rango {

	public abstract Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero);
	public abstract void actualizaPiezasEnRango(Pieza piezaCentral);
	public abstract ArrayList<Pieza> getPiezasEnRango();
	public abstract void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero);
	public abstract Batalloneable darDeAltaBatallon();
	public abstract ArrayList<Pieza> getSoldadosEquipo();

}
