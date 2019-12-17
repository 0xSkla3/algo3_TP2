package edu.fiuba.algoChess.modelo.entidades;
import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.modelo.rangos.Rango;
import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.excepciones.*;
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
		throw new NoSePuedeObtenerElEquipoDeUnaPiezaNoAgrupable("No se puede obtener el equipo de una pieza null");
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		throw new NoSePuedeObtenerElEquipoDeUnaPiezaNoAgrupable("No se puede obtener el equipo de una pieza null");
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

	public void recibirAtaque(Ataque ataque){
		throw new NoSePuedeAtacarPiezaNull("Operacion invalida");
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Rango actualizaRango(Tablero tablero) {
		throw new NoSePuedeObtenerElEquipoDeUnaPiezaNoAgrupable("No se puede obtener el equipo de una pieza null");
	}

	public boolean bandoAliado(Bando bando){
		throw new NoSePuedePreguntarElBandoAUnaPiezaNull("No se puede preguntar el bando a una pieza null");
	}

	public boolean bandoEnemigo(Bando bando){
		throw new NoSePuedePreguntarElBandoAUnaPiezaNull("No se puede preguntar el bando a una pieza null");
	}

	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		throw new NoSePuedeActualizarElBandoDeUnaPiezaNull("No se puede actualizar el bando a una pieza null");
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		throw new NoSePuedeActualizarElRangoDeUnaPiezaNull("No se puede actualizar el rango de una pieza null");
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
		throw new NoSePuedeDarDeAltaUnBatallonDePiezaNull("No se puede dar de alta un batallon de piezas null");
	}

}