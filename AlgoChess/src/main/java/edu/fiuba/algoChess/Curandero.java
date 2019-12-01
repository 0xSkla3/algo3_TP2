package edu.fiuba.algoChess;

import java.util.ArrayList;

public class Curandero extends Pieza {

	private int sanacion;
	private Comportamiento curacion;

	public Curandero(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo,vida,ubicacion,bando);
	}

	public Curandero(){

		super(2,75);
		this.sanacion = 15;

	}

	public Curandero(Ubicacion ubicacion,Bando bando){

		super(2,75,ubicacion,bando);
		this.sanacion = 15;
		this.curacion = new CuracionCercanaCurandero(15);

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


	public int getSanacion(){
		return this.sanacion;
	};

	public Comportamiento getCuracion(){
		return this.curacion;
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
	public void unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
	}

	@Override
	public void aniadirPiezaAlStack(ArrayList<Pieza> stack) {
	}

	@Override
	public void aniadirSoldadoAlStack(ArrayList<Pieza> stack) {
	}

	@Override
	public void aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		return null;
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return false;
	}
}
