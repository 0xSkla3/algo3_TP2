package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entorno.DistanciaRelativa;
import edu.fiuba.algoChess.modelo.entidades.Pieza;

public class Curacion {

	protected double curacion;
	protected DistanciaRelativa distanciaRelativa;

	public Curacion(double curacion){
		this.curacion = curacion;
	}

	public void ejecutarComportamiento(Pieza pieza, Pieza otraPieza){
	};

	public double getValorCuracion(){
		return curacion;
	}

}