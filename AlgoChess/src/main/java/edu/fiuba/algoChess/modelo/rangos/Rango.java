package edu.fiuba.algoChess.modelo.rangos;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;

import java.util.ArrayList;

public interface Rango {

	public abstract Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero);
	public abstract void actualizaPiezasEnRango(Pieza piezaCentral);
	public abstract ArrayList<Pieza> getPiezasEnRango();

	void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero);

	void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero);

	public abstract void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero);
	public abstract Batallon darDeAltaBatallon();
	public abstract ArrayList<Pieza> getSoldadosEquipo();

}
