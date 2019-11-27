package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public interface Rango {

	public abstract void actualizaRango(Pieza piezaCentral, Tablero tablero);
	public abstract void actualizaEntornoInmediato(Pieza piezaCentral);


}
