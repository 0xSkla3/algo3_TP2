package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entorno.DistanciaRelativa;
import edu.fiuba.algoChess.modelo.entidades.Pieza;

public class Curacion {

	protected double curacion;

	public Curacion(double curacion){
		this.curacion = curacion;
	}

	public void curar(Pieza pieza){
		pieza.aumentarVida(curacion);
	}

	public double getValorCuracion(){
		return curacion;
	}

}