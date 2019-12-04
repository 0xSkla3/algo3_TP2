package edu.fiuba.algoChess.batallones;

import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.rangos.Rango;
import edu.fiuba.algoChess.rangos.RangoInmediatoNull;
import edu.fiuba.algoChess.entorno.Tablero;
import edu.fiuba.algoChess.entorno.Ubicacion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BatallonNull extends Batallon {

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

	public void moverseALaDerecha(Tablero campoDeBatalla) {

	}

	public void moverseALaIzquierda(Tablero campoDeBatalla) {

	}

	public void moverseArriba(Tablero campoDeBatalla) {

	}

	public void moverseAbajo(Tablero campoDeBatalla) {

	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {

	}

	@Override
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		return null;
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {

	}

	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		return new RangoInmediatoNull();
	}

	public void actualizaPiezasEnRango(Pieza piezaCentral) {

	}


	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {

	}

	public Batalloneable darDeAltaBatallon() {
		return null;
	}

	public ArrayList<Pieza> getSoldadosEquipo() {
		return null;
	}

	public Batalloneable crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

	public boolean equals(Batalloneable batallon){
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
