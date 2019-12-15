package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.comportamientos.Comportamiento;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.modelo.rangos.Agrupable;
import edu.fiuba.algoChess.modelo.rangos.Rango;
import edu.fiuba.algoChess.modelo.rangos.RangoSoldado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public class Soldado extends Pieza {

	@Getter
	@Setter
	private Comportamiento ataqueCercano;

	@Getter
	@Setter
	private int danioCercano;

	public Soldado(Ubicacion ubicacion, Bando bando, Tablero tablero){
		super(2,75,ubicacion,bando);
		this.danioCercano = 10;
		this.ataqueCercano = new Comportamiento(10);
		this.rango = new RangoSoldado(this, tablero);
		tablero.ubicarEnCeldaFaseInicial(this, ubicacion);
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
	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack, Pieza pieza) {
		Bando bandoPiezaAAniadir = pieza.getBando();
		Bando bandoPiezaEje = this.getBando();
		if (stack == null){
			ArrayList<Pieza> nuevoStack = new ArrayList<>();
			nuevoStack.add(this);
			return  nuevoStack;
		}
		else{
			if (bandoPiezaAAniadir==bandoPiezaEje){
				stack.add(this);
				return stack;
			}
			else{
				//throw new OperacionInvalidaException("No se pueden vinvular soldados de distintos bandos");
			}
		}
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
		if (stack == null) return new ArrayList<>();
		return stack;
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

	Batallon unirSoldados(){
		return (Batallon) this.getRango().darDeAltaBatallon();
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		this.setUbicacion(ubicacion);
		campoDeBatalla.ubicarEnCeldaFaseInicial(this,ubicacion);
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

	@Override
	public void curar(Pieza curado) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		return null;
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		return null;
	}

	@Override
	public void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Batallon darDeAltaBatallon() {
		return this.getRango().darDeAltaBatallon();
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		return this.getRango().getSoldadosEquipo();
	}

	@Override
	public Batallon crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

}
