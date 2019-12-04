package edu.fiuba.algoChess.rangos;

import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.entorno.Tablero;

import java.util.ArrayList;

public interface Rango {

	public abstract Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero);
	public abstract void actualizaPiezasEnRango(Pieza piezaCentral);
	public abstract ArrayList<Pieza> getPiezasEnRango();
	public abstract void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero);
	public abstract Batalloneable darDeAltaBatallon();
	public abstract ArrayList<Pieza> getSoldadosEquipo();

}
