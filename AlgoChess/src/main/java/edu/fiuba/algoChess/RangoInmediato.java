package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class RangoInmediato implements Rango {

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

	public void actualizaRango(Pieza piezaCentral, Tablero tablero){
		setArriba(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionArriba()));
		setAbajo(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionAbajo()));
		setDerecha(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionIzquierda()));
		setIzquierda(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionDerecha()));

		actualizaPiezasEnRango(piezaCentral);
	}

	public void actualizaPiezasEnRango(Pieza piezaCentral){

		ArrayList<Pieza> nuevoEntorno = new ArrayList<>();

		this.getArriba().getPiezaActual().aniadirPiezaAlStack(nuevoEntorno);
		this.getAbajo().getPiezaActual().aniadirPiezaAlStack(nuevoEntorno);
		this.getIzquierda().getPiezaActual().aniadirPiezaAlStack(nuevoEntorno);
		this.getDerecha().getPiezaActual().aniadirPiezaAlStack(nuevoEntorno);
		this.setPiezasEnRango(this.getPiezasEnRango());

		setPiezasEnRango(nuevoEntorno);

	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		return this.getPiezasEnRango();
	}

}
