package edu.fiuba.algoChess.comportamientos;

import edu.fiuba.algoChess.entorno.DistanciaRelativa;
import edu.fiuba.algoChess.entidades.Pieza;

public class Comportamiento {

	protected int valorComportamiento;
	protected DistanciaRelativa distanciaRelativa;

	public Comportamiento(int valorComportamiento){
		this.valorComportamiento = valorComportamiento;
	}

	public void ejecutarComportamiento(Pieza pieza, Pieza otraPieza){
	};

	public int getValorComportamiento(){
		return valorComportamiento;
	}

}