package edu.fiuba.algoChess.entidades;

import edu.fiuba.algoChess.bandos.Bando;
import edu.fiuba.algoChess.batallones.Batallon;
import edu.fiuba.algoChess.batallones.BatallonNull;
import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.comportamientos.Ataque;
import edu.fiuba.algoChess.comportamientos.AtaqueCercanoSoldado;
import edu.fiuba.algoChess.comportamientos.Comportamiento;
import edu.fiuba.algoChess.entorno.*;
import edu.fiuba.algoChess.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.rangos.Rango;
import edu.fiuba.algoChess.rangos.RangoSoldado;
import edu.fiuba.algoChess.salud.SaludLlena;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public class Soldado extends Pieza implements Movible {

	@Getter
	@Setter
	private Comportamiento ataqueCercano;

	@Getter
	@Setter
	private int danioCercano;

	public Soldado(Ubicacion ubicacion, int costo, int vida, Bando bando) {

		super(costo,vida,ubicacion,bando);
	}

	public Soldado(Ubicacion ubicacion, Bando bando, Tablero tablero){
		super(2,75,ubicacion,bando);
		this.danioCercano = 10;
		this.ataqueCercano = new AtaqueCercanoSoldado(10);
		this.rango = new RangoSoldado(this, tablero);
		tablero.ubicarEnCelda(this, ubicacion);
	}

	public Soldado(Ubicacion ubicacion, Tablero tablero) {
		super(ubicacion);
		this.setVida(new SaludLlena(75));
		this.ataqueCercano = new AtaqueCercanoSoldado(10);
		this.rango = new RangoSoldado(this, tablero);
	}

	public Soldado(Ubicacion ubicacion,Bando bando){

		super(2,75,ubicacion,bando);
		danioCercano = 10;
		this.ataqueCercano = new AtaqueCercanoSoldado(10);
	}

	public Rango actualizaRango(Tablero tablero) {
		this.getRango().actualizaRangoSoldado(this,tablero);
		return this.getRango();
	}

	@Override
	public Rango getRango() {
		return this.rango;
	}

	@Override
	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		/*if (stackDeUnion == null){
			ArrayList<Pieza> nuevoStackDeUnion = new ArrayList<>();
			nuevoStackDeUnion.add(this);
			return nuevoStackDeUnion;
		} */
		stackDeUnion.add(this);
		return stackDeUnion;
	}

	@Override
	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack) {

		if (stack == null){
			ArrayList<Pieza> nuevoStack = new ArrayList<>();
			nuevoStack.add(this);
			return  nuevoStack;
		}

		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack) {

		if (stack == null){
			ArrayList<Pieza> nuevoStack = new ArrayList<>();
			nuevoStack.add(this);
			return  nuevoStack;
		}

		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
		if (stack == null) return new ArrayList<>();
		return stack;
	}

	/*public void atacar(DistanciaRelativa distancia, Pieza atacado){
		//this.getBando().atacar(atacado, this.getAtaque(), atacado.getBando()); //ROCHI
	}*/

	public Batalloneable verificaBatallonONull() {
		return this.getRango().darDeAltaBatallon();
	}

	public void setRango(Rango rango) {
		super.setRango(rango);
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
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		return new BatallonNull();
	}

	Batallon unirSoldados(){
		return (Batallon) this.getRango().darDeAltaBatallon();
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		this.setUbicacion(ubicacion);
		campoDeBatalla.ubicarEnCelda(this,ubicacion);
	}

	@Override
	public void recibirAtaque(Ataque ataque) {

	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueCercano, pieza.getBando());
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	};

	public void atacar(Pieza atacado){
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this,atacado);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, atacado);
	};
}
