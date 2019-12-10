package edu.fiuba.algoChess.Modelo.entidades;

import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.Modelo.comportamientos.AtaqueCercanoJinete;
import edu.fiuba.algoChess.Modelo.comportamientos.AtaqueMedioJinete;
import edu.fiuba.algoChess.Modelo.comportamientos.Comportamiento;
import edu.fiuba.algoChess.Modelo.entorno.*;
import edu.fiuba.algoChess.Modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.Modelo.excepciones.NoHayBatallonFormadoException;
import edu.fiuba.algoChess.Modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.Modelo.excepciones.PiezaActualNoFormaBatallonDeSoldadosException;

import edu.fiuba.algoChess.Modelo.entorno.*;
import edu.fiuba.algoChess.Modelo.rangos.Agrupable;
import edu.fiuba.algoChess.Modelo.rangos.Rango;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.abs;
public class Jinete extends Pieza {

	@Getter
	@Setter
	private Comportamiento ataqueMedio = new AtaqueMedioJinete(15);

	@Getter
	@Setter
	private Comportamiento ataqueCercano = new AtaqueCercanoJinete(5);

//	@Getter
//	@Setter
	public boolean piezaAliadaCercana;

//	@Getter
//	@Setter
	public boolean piezaEnemigaCercana;

	@Getter
	@Setter
	private int distanciaAReconocerEnTerreno = 2;

	private ReconocedorDeTerritorio reconocedorDeTerritorio;

	public Jinete(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo, vida, ubicacion, bando);
	}

	public Jinete() {

		super(3, 100);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;

	}

	public Jinete(Ubicacion ubicacion, Bando bando) {

		super(3, 100, ubicacion, bando);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
	}


	public Jinete(Ubicacion ubicacion) {
		super(ubicacion);
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCeldaFaseInicial(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}

	public Jinete(Ubicacion ubicacion, Bando bando, Tablero tablero) {

		super(3, 100, ubicacion, bando);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;
		this.reconocedorDeTerritorio = new ReconocedorDeTerritorio(tablero);
	}

	public Jinete(Ubicacion ubicacion, Tablero tablero) {

		super(ubicacion);
		tablero.getCelda(ubicacion).setPiezaActual(this);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;

	}

	@Override
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
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


	public void atacar(DistanciaRelativa distancia, Pieza atacado) {
	}


	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
			this.bando.atacar(pieza, this.ataqueCercano, pieza.getBando());
	}


	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		this.reconocedorDeTerritorio.reconocerTerreno(this, distanciaAReconocerEnTerreno, pieza);
	}


	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	public void concretarAtaqueMedio(Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
	}

	@Override
	public void curar(Pieza curado) {

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
	public void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public Batalloneable darDeAltaBatallon() {
		return null;
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		return null;
	}

	@Override
	public Batalloneable crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

	@Override
	public boolean equals(Batalloneable batallon) {
		return false;
	}

	@Override
	public Pieza getPieza1() {
		return null;
	}

	@Override
	public Pieza getPieza2() {
		return null;
	}

	@Override
	public Pieza getPieza3() {
		return null;
	}

	@Override
	public void setPieza1(Pieza pieza1) {

	}

	@Override
	public void setPieza2(Pieza pieza2) {

	}

	@Override
	public void setPieza3(Pieza pieza3) {

	}
}


