package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.comportamientos.AtaqueCatapulta;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeCurarUnaCatapultaException;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.modelo.excepciones.PiezaActualNoFormaBatallonDeSoldadosException;
import edu.fiuba.algoChess.modelo.rangos.Rango;

import java.util.ArrayList;

public class Catapulta extends Pieza {

	private AtaqueCatapulta ataque;

	public Catapulta(Ubicacion ubicacion, Bando bando, Tablero tablero){
		super(5,50,ubicacion,bando);
		tablero.ubicarEnCeldaFaseInicial(this, ubicacion);
		ataque = new AtaqueCatapulta(20);
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
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Una catapulta no puede formar un batallon de soldados");
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Una catapulta no se puede unir a un soldado");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		this.ataque.atacar(pieza);
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
	public void aumentarVida(double aumento) {
		throw new NoSePuedeCurarUnaCatapultaException("No se puede curar una catapulta");
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		return null;
	}

	public AtaqueCatapulta getAtaque(){
		return this.ataque;
	}

}
