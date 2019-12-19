package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.AccionAgrupableInvalidaException;

public abstract class Movible {

	public void moverseALaDerecha(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	};

	public  void moverseALaIzquierda(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	}

	public  void moverseArriba(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	}

	public  void moverseAbajo(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	}

	public  void mover(Tablero campoDeBatalla, Ubicacion ubicacion){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	}

}
