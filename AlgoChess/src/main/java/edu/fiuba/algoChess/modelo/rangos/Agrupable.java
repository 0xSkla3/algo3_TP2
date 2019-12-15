package edu.fiuba.algoChess.modelo.rangos;

import edu.fiuba.algoChess.modelo.entidades.Pieza;

public interface Agrupable extends Rango {

	public abstract Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3);

}
