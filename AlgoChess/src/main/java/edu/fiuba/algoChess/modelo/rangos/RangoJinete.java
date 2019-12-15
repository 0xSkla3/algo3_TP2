package edu.fiuba.algoChess.modelo.rangos;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.excepciones.*;
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
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		return null;
	}

	@Override
	public void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Batallon darDeAltaBatallon() {
		throw new NoSePuedeDarDeAltaUnBatallonDeJinetes("No se puede dar de alta un batallon de jinetes");
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo(){
		throw new NoSePuedeObtenerElEquipoDeUnaPiezaNoAgrupable("No se puede obtener el equipo de una pieza no agrupable");
	}
}
