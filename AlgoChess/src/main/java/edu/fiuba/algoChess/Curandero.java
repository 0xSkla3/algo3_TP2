package edu.fiuba.algoChess;

import java.util.ArrayList;

public class Curandero extends Pieza {

	private int sanacion;

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

	}


	public void curar(DistanciaRelativa distancia, Pieza aCurar){

		if ((distancia==DistanciaRelativa.CERCANO)&&(!(aCurar instanceof Catapulta))&&(this.bando.equals(aCurar.getBando()))){
			aCurar.aumentarVida(this.sanacion);
		};
	};

	public int getSanacion(){
		return this.sanacion;
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


//	public void Sanar(Pieza sanado){
//		sanado.aumentarVida(this.sanacion);
//	}

}
