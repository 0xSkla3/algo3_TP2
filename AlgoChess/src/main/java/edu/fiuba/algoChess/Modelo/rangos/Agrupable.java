package edu.fiuba.algoChess.Modelo.rangos;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;

import java.util.Collection;

public interface Agrupable extends Rango {

	public abstract Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3);

}
