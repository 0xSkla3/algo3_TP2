package edu.fiuba.algoChess.modelo.batallones;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeMoverUnBatallonNull;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeObtenerElEquipoDeUnBatallonNull;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.modelo.rangos.Rango;
import edu.fiuba.algoChess.modelo.rangos.RangoInmediatoNull;
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
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public void moverseALaIzquierda(Tablero campoDeBatalla) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public void moverseArriba(Tablero campoDeBatalla) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public void moverseAbajo(Tablero campoDeBatalla) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Batallon moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		throw new NoSePuedeMoverUnBatallonNull("No se puede mover un batallon null");
	}

	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		return new RangoInmediatoNull();
	}

	public void actualizaPiezasEnRango(Pieza piezaCentral) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public ArrayList<Pieza> getSoldadosEquipo() {

		throw new NoSePuedeObtenerElEquipoDeUnBatallonNull("No se puede obtener el equipo de un batallon null");
	}

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
