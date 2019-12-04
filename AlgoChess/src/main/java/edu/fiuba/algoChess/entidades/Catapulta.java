package edu.fiuba.algoChess.entidades;
import edu.fiuba.algoChess.bandos.Bando;
import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.comportamientos.Ataque;
import edu.fiuba.algoChess.comportamientos.AtaqueLejano;
import edu.fiuba.algoChess.entorno.*;
import edu.fiuba.algoChess.rangos.Rango;
import edu.fiuba.algoChess.salud.Salud;

import java.util.ArrayList;

public class Catapulta extends Pieza {

	private AtaqueLejano ataque;
	private int danio = 20;
	public int costo = 5;
	private Salud vida;

	public Catapulta(Ubicacion ubicacion, Bando bando){

		super(5,50,ubicacion,bando);
		ataque = new AtaqueLejano(danio);
	}

	public Catapulta(Ubicacion ubicacion, Bando bando, Tablero tablero){
		super(5,50,ubicacion,bando);
		tablero.getCelda(ubicacion).setPiezaActual(this);
		ataque = new AtaqueLejano(danio);
	}

	public Catapulta(){
		super(5,50);
		ataque = new AtaqueLejano(danio);
	}

	public Catapulta(int costo, int vida) {
		super(costo,vida);
	}


	public void mover( Tablero campoDeBatalla, Ubicacion ubicacion) {
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
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {

	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {

	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {

	}

	public void ejecutarComportamiento(DistanciaRelativa distancia, Pieza atacado) {
	}

	public Ataque getAtaqueLejano(){
		return this.ataque;
	};

	@Override
	public void recibirAtaque(Ataque ataque) {

	}

	public void atacar(Pieza pieza) {
		//ROCHI
	}

}
