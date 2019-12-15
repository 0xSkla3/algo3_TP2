package edu.fiuba.algoChess.modelo.rangos;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.excepciones.*;

import java.util.ArrayList;

public class RangoInmediatoNull implements RangoNull {


	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		throw new NoSePuedeActualizarElRangoDeUnRangoNull("No se puede actualizar el rango de un rango null");
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {
		throw new NoSePuedeActualizarElRangoDeUnRangoNull("No se puede actualizar el rango de un rango null");
	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		throw new NoSePuedeObtenerElEquipoDeUnRangoNull("No se puede obtener el equipo de un rango null");
	}

	@Override
	public void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero) {
		throw new NoSePuedeActualizarElRangoDeUnRangoNull("No se puede actualizar el rango de un rango null");
	}

	@Override
	public void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero) {
		throw new NoSePuedeActualizarElRangoDeUnRangoNull("No se puede actualizar el rango de un rango null");
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {
		throw new NoSePuedeActualizarElRangoDeUnRangoNull("No se puede actualizar el rango de un rango null");
	}

	@Override
	public Batallon darDeAltaBatallon() {
		throw new NoSePuedeDarDeAltaUnBatallonDeRangoNulo("No se puede dar de alta un batallon a partir de un rango nulo");
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		throw new NoSePuedeObtenerElEquipoDeUnRangoNull("No se puede obtener el equipo de un rango null");
	}
}
