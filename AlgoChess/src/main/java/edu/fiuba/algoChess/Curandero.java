package edu.fiuba.algoChess;

import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.rangos.Rango;

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

	public Curandero(Ubicacion ubicacion, Bando bando, Tablero tablero){

		super(2,75,ubicacion,bando);
		tablero.getCelda(ubicacion).setPiezaActual(this);
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


//	public void Sanar(Pieza sanado){
//		sanado.aumentarVida(this.sanacion);
//	}

}
