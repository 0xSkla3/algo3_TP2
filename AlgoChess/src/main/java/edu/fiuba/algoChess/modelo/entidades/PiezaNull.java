package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaSobreObjetoNuloException;
import edu.fiuba.algoChess.modelo.rangos.Rango;
import edu.fiuba.algoChess.modelo.salud.SaludLlena;

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
	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack){
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack){
		return stack;
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		throw new OperacionInvalidaSobreObjetoNuloException("No se puede obtener el equipo de unaPiezaNull");
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		throw new OperacionInvalidaSobreObjetoNuloException("No se puede obtener el equipo de una PiezaNull");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		throw new OperacionInvalidaSobreObjetoNuloException("No se pueder ejecutar el comportamiento por distancia de una PiezaNull");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new OperacionInvalidaSobreObjetoNuloException("No se pueder ejecutar el comportamiento por distancia de una PiezaNull");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new OperacionInvalidaSobreObjetoNuloException("No se pueder ejecutar el comportamiento por distancia de una PiezaNull");
	}
	@Override
	public void atacar(Pieza atacado) {
		throw new OperacionInvalidaSobreObjetoNuloException("Una PiezaNull no puede atacar");
	}

	public void recibirAtaque(Ataque ataque){
		throw new OperacionInvalidaSobreObjetoNuloException("Una PiezaNull no puede recibir ataque");
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		throw new OperacionInvalidaSobreObjetoNuloException("Una PiezaNull no puede formar batallon, mucho menos moverse");
	}

	@Override
	public Rango actualizaRango(Tablero tablero) {
		throw new OperacionInvalidaSobreObjetoNuloException("No se puede obtener el rango de una pieza null");
	}

	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaSobreObjetoNuloException("No se puede actualizar el bando a una pieza null");
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {
		throw new OperacionInvalidaSobreObjetoNuloException("No se puede actualizar el rango de una PiezaNull");
	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		throw new OperacionInvalidaSobreObjetoNuloException("No se puede actualizar el rango de una PiezaNull");
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaSobreObjetoNuloException("No se puede actualizar el rango de una PiezaNull");
	}

	@Override
	public Batallon darDeAltaBatallon() {
		throw new OperacionInvalidaSobreObjetoNuloException("No se puede dar de alta un batallon a partir de un PiezaNull");
	}

}
