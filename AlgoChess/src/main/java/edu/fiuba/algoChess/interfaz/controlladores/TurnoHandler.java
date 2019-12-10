package edu.fiuba.algoChess.interfaz.controlladores;

import lombok.Getter;
import lombok.Setter;

public class TurnoHandler {

	@Setter
	@Getter
	boolean jugador1;

	public TurnoHandler(){
		this.jugador1 = true;
	}

	public boolean pasarTurno(){
		boolean retorno = this.jugador1?false:true;
		this.jugador1 = retorno;
		return retorno;
	}
}
