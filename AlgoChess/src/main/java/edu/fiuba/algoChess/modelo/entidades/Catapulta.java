package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;

import edu.fiuba.algoChess.modelo.comportamientos.AtaqueCatapulta;
import edu.fiuba.algoChess.modelo.entorno.*;

import edu.fiuba.algoChess.modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeCurarUnaCatapultaException;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.modelo.rangos.Rango;

public class Catapulta extends Pieza {

	private AtaqueCatapulta ataque;

	public Catapulta(Ubicacion ubicacion, Bando bando, Tablero tablero){
		super(5,50,ubicacion,bando);
		tablero.ubicarEnCeldaFaseInicial(this, ubicacion);
		ataque = new AtaqueCatapulta(20);
	}

	@Override
	public Rango actualizaRango(Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		this.ataque.atacar(pieza);
	}


	@Override
	public void aumentarVida(double aumento) {
		throw new NoSePuedeCurarUnaCatapultaException("No se puede curar una catapulta");
	}

	public AtaqueCatapulta getAtaque(){
		return this.ataque;
	}

}
