package edu.fiuba.algoChess;

import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.rangos.Rango;

import java.util.ArrayList;

import static java.lang.Math.abs;
public class Jinete extends Pieza {

	private AtaqueMedio ataqueMedio;
	private AtaqueCercano ataqueCercano;
	private int danioCercano = 5;
	private int danioMedio = 15;

	public boolean piezaAliadaCercana;
	public boolean piezaEnemigaCercana;
	private int distanciaAReconocerEnTerreno;


	public Jinete(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo, vida, ubicacion, bando);
	}

	public Jinete() {

		super(3, 100);
		this.ataqueCercano = new AtaqueCercano(danioCercano);
		this.ataqueMedio = new AtaqueMedio(danioMedio);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;

	}

	public Jinete(Ubicacion ubicacion,Bando bando){

		super(3, 100,ubicacion,bando);
		this.ataqueCercano = new AtaqueCercano(danioCercano);
		this.ataqueMedio = new AtaqueMedio(danioMedio);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;

	}


	public Jinete(Ubicacion ubicacion) {
		super(ubicacion);
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCelda(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}

	public Jinete(Ubicacion ubicacion, Bando bando, Tablero tablero){

		super(3, 100,ubicacion,bando);
		this.ataqueCercano = new AtaqueCercano(danioCercano);
		this.ataqueMedio = new AtaqueMedio(danioMedio);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;
		tablero.ubicarEnCelda(this,ubicacion);

	}

	public Jinete(Ubicacion ubicacion, Tablero tablero){

		super(ubicacion);
		tablero.getCelda(ubicacion).setPiezaActual(this);
		this.ataqueCercano = new AtaqueCercano(danioCercano);
		this.ataqueMedio = new AtaqueMedio(danioMedio);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;

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
		//throw new IllegalStateException("Un jinete no se puede unir a un batallon de Soldado");
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

	public void atacar(DistanciaRelativa distancia, Pieza atacado){

		if ((distancia==DistanciaRelativa.CERCANO)&&(!(this.getPiezaAliadaCercana()))){
			atacado.recibirAtaque(this.ataqueCercano);
		};
		if ((distancia==DistanciaRelativa.MEDIO)&&((this.getPiezaAliadaCercana())||(!(this.getPiezaEnemigaCercana())))){
			atacado.recibirAtaque(this.ataqueMedio);
		}
			}


	public boolean getPiezaAliadaCercana(){
			return this.piezaAliadaCercana;
	}

	public boolean getPiezaEnemigaCercana(){
		return this.piezaEnemigaCercana;
	}

	public int getDanioMedio(){
		return this.danioMedio;
	};

	public int getDanioCercano(){
		return this.danioCercano;
	};

	public Ataque getAtaqueMedio(){
		return this.ataqueMedio;
	};

	public Ataque getAtaqueCercano(){
		return this.ataqueCercano;
	};

}


