package edu.fiuba.algoChess.rangos;

import edu.fiuba.algoChess.entidades.Pieza;

import java.util.Collection;

public interface Agrupable extends Rango {

	public abstract Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3);
	public abstract Collection<Pieza> desagrupar(Agrupable grupo);

}
