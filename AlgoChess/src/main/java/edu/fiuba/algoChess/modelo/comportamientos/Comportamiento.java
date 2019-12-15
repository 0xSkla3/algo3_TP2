package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entorno.DistanciaRelativa;
import edu.fiuba.algoChess.modelo.entidades.Pieza;

public class Comportamiento {

	protected double valorComportamiento;
	protected DistanciaRelativa distanciaRelativa;

	public Comportamiento(double valorComportamiento){
		this.valorComportamiento = valorComportamiento;
	}

	public void ejecutarComportamiento(Pieza pieza, Pieza otraPieza){
	};

	public double getValorComportamiento(){
		return valorComportamiento;
	}

}