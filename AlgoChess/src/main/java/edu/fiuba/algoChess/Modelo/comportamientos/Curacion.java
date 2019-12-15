package edu.fiuba.algoChess.Modelo.comportamientos;

import edu.fiuba.algoChess.Modelo.entorno.DistanciaRelativa;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;

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