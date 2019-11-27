package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public abstract class Rango {

	@Getter
	@Setter
	ArrayList<Pieza> piezasEnEntorno;

	public abstract void actualizaRango(Pieza piezaCentral, Tablero tablero);
	public abstract void actualizaEntornoInmediato(Pieza piezaCentral);


}
