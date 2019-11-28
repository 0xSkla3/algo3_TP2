package edu.fiuba.algoChess;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

public interface Batallon extends Agrupable, Movible {

	@Override
	Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3);

	@Override
	Collection<Pieza> desagrupar(Agrupable grupo);

	@Override
	Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero);

	@Override
	void actualizaPiezasEnRango(Pieza piezaCentral);

	@Override
	ArrayList<Pieza> getPiezasEnRango();

	Batallon crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3);

	boolean equals(Batallon batallon);

	Pieza getPieza1();

	Pieza getPieza2();

	Pieza getPieza3();
}

