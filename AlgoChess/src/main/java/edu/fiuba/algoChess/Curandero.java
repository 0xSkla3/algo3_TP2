package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Batallones.Batalloneable;
import edu.fiuba.algoChess.Rangos.Rango;
import edu.fiuba.algoChess.Rangos.RangoInmediato;

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

	@Override
	public void setRango(RangoInmediato rangoInmediato) {

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


//	public void Sanar(Pieza sanado){
//		sanado.aumentarVida(this.sanacion);
//	}

}
