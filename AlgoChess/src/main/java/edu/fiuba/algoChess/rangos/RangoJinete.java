package edu.fiuba.algoChess.rangos;

import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.entorno.Tablero;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class RangoJinete implements Rango{

	@Getter
	@Setter
	RangoInmediato rangoInmediatoJinete;

	@Getter
	@Setter
	RangoCercano rangoCercanoJinete;

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
