package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.modelo.comportamientos.AtaqueNormal;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.modelo.excepciones.PiezaActualNoFormaBatallonDeSoldadosException;

import edu.fiuba.algoChess.modelo.rangos.Agrupable;
import edu.fiuba.algoChess.modelo.rangos.Rango;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.abs;
public class Jinete extends Pieza {

	@Getter
	@Setter
	private AtaqueNormal ataqueMedio;

	@Getter
	@Setter
	private AtaqueNormal ataqueCercano;

	public boolean piezaAliadaCercana;

	public boolean piezaEnemigaCercana;

	@Getter
	@Setter
	private int distanciaAReconocerEnTerreno = 2;

	@Getter
	private double danioCercano = 5;

	@Getter
	private double danioMedio = 15;

	public Jinete(Ubicacion ubicacion, Bando bando, Tablero tablero) {

		super(3, 100, ubicacion, bando);
		tablero.ubicarEnCeldaFaseInicial(this, ubicacion);
		this.ataqueCercano = new AtaqueNormal(danioCercano);
		this.ataqueMedio = new AtaqueNormal(danioMedio);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCeldaFaseJuego(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}

	@Override
	public Rango actualizaRango(Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Rango getRango() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Un jinete no puede formar un batallon de soldados");

	}

	@Override
	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack, Pieza pieza) {
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Un jinete no se puede unir a un soldado");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
			this.bando.atacar(pieza, this.ataqueCercano, pieza.getBando());
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		this.ubicacion.reconocerTerrenoParaAtacarADistanciaMedia(this, pieza, distanciaAReconocerEnTerreno, ubicacion);
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	public void concretarAtaqueMedio(Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
	}

	@Override
	public Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

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
	public ArrayList<Pieza> getSoldadosEquipo() {
		return null;
	}

	public double getDanioMedio() {
		return this.danioMedio;
	}

	public double getDanioCercano() {
		return this.danioCercano;
	}

}
