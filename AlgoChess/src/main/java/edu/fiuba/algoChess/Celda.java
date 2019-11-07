package edu.fiuba.algoChess;

import java.util.Optional;

public class Celda {

	private Optional<Ficha> fichaActual;

	public Celda(){ this.fichaActual = Optional.empty();}

	public boolean estaVacia() {return this.fichaActual.isEmpty();}

	public Ficha getFichaActual(){return this.fichaActual.get();}

	public Optional<Ficha> getContenido(){return this.fichaActual;}

	public void moverA(Celda nuevaCelda) {
		nuevaCelda.fichaActual = this.fichaActual;
		this.fichaActual = Optional.empty();
	}

	public void guardar(Ficha fichaActual) {
		this.fichaActual = Optional.of(fichaActual);
	}

	public void eliminar() {
		this.fichaActual = Optional.empty();
	}

}