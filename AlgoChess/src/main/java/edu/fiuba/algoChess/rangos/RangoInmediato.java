package edu.fiuba.algoChess.rangos;

import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.Celda;
import edu.fiuba.algoChess.Pieza;
import edu.fiuba.algoChess.Tablero;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public abstract class RangoInmediato implements Rango {

	@Getter
	@Setter
	Celda arriba;

	@Getter
	@Setter
	Celda abajo;

	@Getter
	@Setter
	Celda izquierda;

	@Getter
	@Setter
	Celda derecha;

	@Getter
	@Setter
	ArrayList<Pieza> piezasEnRango;

	public RangoInmediato(Pieza piezaCentral, Tablero tablero) {
		this.piezasEnRango = new ArrayList<>();
		this.actualizaRangoInmediato(piezaCentral,tablero);
	}

	public RangoInmediato() {
		this.piezasEnRango = new ArrayList<>();
	}

	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero){

		this.setArriba(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionArriba()));
		this.setAbajo(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionAbajo()));
		this.setDerecha(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionIzquierda()));
		this.setIzquierda(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionDerecha()));

		this.actualizaPiezasEnRango(piezaCentral);

		piezaCentral.setRango(this);

		return this;
	}

	public void actualizaPiezasEnRango(Pieza piezaCentral){

		ArrayList<Pieza> nuevoEntorno = new ArrayList<>();

		this.getArriba().getPiezaActual().aniadirPiezaAlStack(nuevoEntorno);
		this.getAbajo().getPiezaActual().aniadirPiezaAlStack(nuevoEntorno);
		this.getIzquierda().getPiezaActual().aniadirPiezaAlStack(nuevoEntorno);
		this.getDerecha().getPiezaActual().aniadirPiezaAlStack(nuevoEntorno);

		this.setPiezasEnRango(nuevoEntorno);
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public Batalloneable darDeAltaBatallon(){
		return null;
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		return null;
	}

}
