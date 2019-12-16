package edu.fiuba.algoChess.modelo.rangos;

import edu.fiuba.algoChess.modelo.entidades.Pieza;

public interface Agrupable {

	public abstract Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3);

}
