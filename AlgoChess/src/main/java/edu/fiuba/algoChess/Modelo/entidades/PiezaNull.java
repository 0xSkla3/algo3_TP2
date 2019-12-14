package edu.fiuba.algoChess.Modelo.entidades;
import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.batallones.Batallon;
import edu.fiuba.algoChess.Modelo.entorno.*;
import edu.fiuba.algoChess.Modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.Modelo.rangos.Rango;
import edu.fiuba.algoChess.Modelo.salud.SaludLlena;

import java.util.ArrayList;

public class PiezaNull extends Pieza {

	public PiezaNull(Ubicacion ubicacion) {
		super(ubicacion);
	}

	public PiezaNull() {
		this.vida = new SaludLlena(0xDEAD);
		this.costo = 0;
		this.ubicacion = null;
		this.bando = null;
		this.rango = null;
	}

	@Override
	public void pisar(Celda celda, Pieza piezaAGuardar){
		celda.ubicar(piezaAGuardar);
	}

	@Override
	public Rango actualizaRango(Tablero tablero) {
		return null;
	}

	@Override
	public Rango getRango() {
		return null;
	}

	@Override
	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		return stackDeUnion;
	}

	@Override
	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack){
		if (stack == null){
			ArrayList<Pieza> nuevoStack = new ArrayList<Pieza>();
			return  nuevoStack;
		}
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack, Pieza pieza){
		if (stack == null){
			ArrayList<Pieza> nuevoStack = new ArrayList<Pieza>();
			return  nuevoStack;
		}
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack){
		if (stack == null){
			ArrayList<Pieza> nuevoStack = new ArrayList<Pieza>();
			return  nuevoStack;
		}
		return stack;
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		return null;
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return false;
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new OperacionInvalidaException("Operacion invalida");
	}
	@Override
	public void atacar(Pieza atacado) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void curar(Pieza curado) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public void recibirAtaque(double ataque){
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public boolean bandoAliado(Bando bando){
		return false;
	}

	public boolean bandoEnemigo(Bando bando){
		return false;
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
	public Batallon darDeAltaBatallon() {
		return null;
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		return null;
	}

}
