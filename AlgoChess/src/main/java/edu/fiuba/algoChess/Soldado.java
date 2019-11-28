package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.Stream;

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

	public Soldado(Ubicacion ubicacion,Bando bando){
		super(2,75,ubicacion,bando);
		danioCercano = 10;
		this.ataque = new AtaqueCercano(danioCercano);
	}

	public Soldado(Ubicacion ubicacion){
		super(ubicacion);
		this.rango = new RangoSoldado();
	}

	@Override
	public ArrayList<Pieza> unirAInmediato(ArrayList<Pieza> piezasInmediatas) {
		piezasInmediatas.add(this);
		return piezasInmediatas;
	}

	public void actualizaRango(Tablero tablero){
		this.getRango().actualizaRango(this,tablero);
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

	Batallon unirSoldados(){
		return this.getRango().darDeAltaBatallon();
	}


}
