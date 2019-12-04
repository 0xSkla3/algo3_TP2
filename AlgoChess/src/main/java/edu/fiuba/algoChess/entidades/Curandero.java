package edu.fiuba.algoChess.entidades;

import edu.fiuba.algoChess.bandos.Bando;
import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.comportamientos.Ataque;
import edu.fiuba.algoChess.comportamientos.Comportamiento;
import edu.fiuba.algoChess.comportamientos.CuracionCercanaCurandero;
import edu.fiuba.algoChess.entorno.*;
import edu.fiuba.algoChess.excepciones.FueraDeRangoParaEjecutarComportamientoException;
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
		return null;
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return false;
	}

	@Override
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		return null;
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {

	}

	@Override
	public void recibirAtaque(Ataque ataque) {

	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		//	pieza.aplicarCuracionAPieza(this);//pieza es la pieza a curar y this es el curandero
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
