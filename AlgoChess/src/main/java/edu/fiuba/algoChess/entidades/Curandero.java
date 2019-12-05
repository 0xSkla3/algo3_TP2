package edu.fiuba.algoChess.entidades;

import edu.fiuba.algoChess.bandos.Bando;
import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.comportamientos.Ataque;
import edu.fiuba.algoChess.comportamientos.Comportamiento;
import edu.fiuba.algoChess.comportamientos.CuracionCercanaCurandero;
import edu.fiuba.algoChess.entorno.*;
import edu.fiuba.algoChess.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.excepciones.NoHayBatallonFormadoException;
import edu.fiuba.algoChess.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.excepciones.PiezaActualNoFormaBatallonDeSoldadosException;
import edu.fiuba.algoChess.rangos.Rango;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Curandero extends Pieza {

	@Getter
	@Setter
	private Comportamiento curacion;

	public Curandero(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo,vida,ubicacion,bando);
	}

	public Curandero(){

		super(2,75);
		this.curacion = new CuracionCercanaCurandero(15);

	}

	public Curandero(Ubicacion ubicacion,Bando bando){

		super(2,75,ubicacion,bando);
		this.curacion = new CuracionCercanaCurandero(15);
	}

	public Curandero(Ubicacion ubicacion, Bando bando, Tablero tablero){

		super(2,75,ubicacion,bando);
		tablero.getCelda(ubicacion).setPiezaActual(this);
		this.curacion = new CuracionCercanaCurandero(15);

	}

	public void curar(DistanciaRelativa distancia, Pieza aCurar){

	};

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
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Un curandero no puede formar un batallon de soldados");
	}

	@Override
	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack) {

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
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Un curandero no se puede unir a un soldado");
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
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		this.bando.curar(pieza, this.curacion, pieza.getBando());
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	};

	public void curar(Pieza piezaACurar){
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this,piezaACurar);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, piezaACurar);
	};


}
