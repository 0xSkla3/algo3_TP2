package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BatallonNull implements Batallon {

	@Setter
	@Getter
	Pieza pieza1;

	@Setter
	@Getter
	Pieza pieza2;

	@Setter
	@Getter
	Pieza pieza3;

	public BatallonNull() {
		super();
		this.pieza1 = null;
		this.pieza2 = null;
		this.pieza3 = null;
	}


	@Override
	public Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

	@Override
	public Collection<Pieza> desagrupar(Agrupable grupo) {
		return null;
	}

	@Override
	public void moverseALaDerecha(Tablero campoDeBatalla) {

	}

	@Override
	public void moverseALaIzquierda(Tablero campoDeBatalla) {

	}

	@Override
	public void moverseArriba(Tablero campoDeBatalla) {

	}

	@Override
	public void moverseAbajo(Tablero campoDeBatalla) {

	}

	@Override
	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {

	}

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
	public Batallon crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

	@Override
	public boolean equals(Batallon batallon){
		Set<Pieza> itemsBatallonActual = new HashSet<>();
		Set<Pieza>itemsBatallonAComparar = new HashSet<>();

		itemsBatallonActual.add(this.getPieza1());
		itemsBatallonActual.add(this.getPieza2());
		itemsBatallonActual.add(this.getPieza3());

		itemsBatallonAComparar.add(batallon.getPieza1());
		itemsBatallonAComparar.add(batallon.getPieza2());

		itemsBatallonAComparar.add(batallon.getPieza3());

		return itemsBatallonActual.equals(itemsBatallonAComparar);
	}

}
