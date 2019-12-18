package edu.fiuba.algoChess.modelo.rangos;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;

import java.util.ArrayList;

public interface Rango {

	Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero);
	void actualizaPiezasEnRango(Pieza piezaCentral);
	ArrayList<Pieza> getPiezasEnRango();
	void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero);
	Batallon darDeAltaBatallon();
	ArrayList<Pieza> getSoldadosEquipo();

}
