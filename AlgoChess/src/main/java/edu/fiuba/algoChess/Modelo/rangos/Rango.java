package edu.fiuba.algoChess.Modelo.rangos;

import edu.fiuba.algoChess.Modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;

import java.util.ArrayList;

public interface Rango {

	public abstract Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero);
	public abstract void actualizaPiezasEnRango(Pieza piezaCentral);
	public abstract ArrayList<Pieza> getPiezasEnRango();

	void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero);

	void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero);

	public abstract void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero);
	public abstract Batalloneable darDeAltaBatallon();
	public abstract ArrayList<Pieza> getSoldadosEquipo();

}
