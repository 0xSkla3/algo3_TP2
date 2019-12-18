package edu.fiuba.algoChess.modelo.rangos;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Celda;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.StrictMath.abs;

public class RangoCercano implements Rango{

	@Getter
	@Setter
	private Map<Ubicacion, Celda> rangoCarcano;

	@Getter
	@Setter
	ArrayList<Pieza> piezasEnRango;

	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {
		ArrayList<Pieza> nuevoRangoCercano = new ArrayList<>();
		this.getPiezasEnRango().forEach(celda -> celda.aniadirPiezaAlStack(nuevoRangoCercano));
		this.setPiezasEnRango(nuevoRangoCercano);
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public Batallon darDeAltaBatallon() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		throw new OperacionInvalidaException("Operacion invalida");
	}
}
