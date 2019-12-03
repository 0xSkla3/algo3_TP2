package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Batallones.Batallon;
import edu.fiuba.algoChess.Batallones.Batalloneable;
import edu.fiuba.algoChess.Rangos.Rango;
import edu.fiuba.algoChess.Rangos.RangoInmediato;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Soldado extends Pieza implements Movible {

	@Getter
	@Setter
	private Ataque ataque;

	@Getter
	@Setter
	private RangoSoldado rango;

	@Getter
	private int danioCercano;

	public Soldado(Ubicacion ubicacion, int costo, int vida, Bando bando) {

		super(costo,vida,ubicacion,bando);
	}

/*	public Soldado(){

		super(1,100);
		danioCercano = 10;
		this.ataque = new AtaqueCercano(danioCercano);


	}*/

	public Soldado(Ubicacion ubicacion,Bando bando){

		super(2,75,ubicacion,bando);
		danioCercano = 10;
		this.ataque = new AtaqueCercano(danioCercano);
	}

	public Soldado(Ubicacion ubicacion, Tablero tablero){
		super(ubicacion);
		this.rango = new RangoSoldado(this, tablero);
	}

	public Rango actualizaRango(Tablero tablero){
		return this.getRango().actualizaRangoInmediato(this,tablero);
	}

	@Override
	public void unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		stackDeUnion.add(this);
	}

	@Override
	public void aniadirPiezaAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
	}

	@Override
	public void aniadirSoldadoAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
	}

	@Override
	public void aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
	}

	public void atacar(DistanciaRelativa distancia, Pieza atacado){
		this.bando.atacar(atacado, this.ataque, atacado.getBando());
	}

	public Batallon verificaBatallonONull() {
		return this.rango.darDeAltaBatallon();
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos(){
		return this.getRango().getSoldadosEquipo();
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return this.getRango().getSoldadosEquipo().size() == 3;
	}

	@Override
	public void setRango(RangoInmediato rangoInmediato) {

	}

	Batallon unirSoldados(){
		return this.getRango().darDeAltaBatallon();
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
}
