package edu.fiuba.algoChess;

import java.util.Optional;

public class Celda {

	private Optional<Ficha> fichaActual;
	private Jugador sectorDelJugador;

	public Celda(){
		this.fichaActual = Optional.empty();
	}

	public boolean estaVacia() {return this.fichaActual.isEmpty();}

	public Ficha getFichaActual(){return this.fichaActual.get();}

	public Optional<Ficha> getContenido(){return this.fichaActual;}

	public void moverA(Celda nuevaCelda) {
		nuevaCelda.fichaActual = this.fichaActual;
		this.fichaActual = Optional.empty();
	}

	public void setSectorDelJugador(Jugador jugador){
		this.sectorDelJugador = jugador;
	}

	public Jugador getSectorDelJugador(){ return this.sectorDelJugador;}

	public void guardar(Ficha fichaActual) {
		if (this.sectorDelJugador != fichaActual.getJugador() ) {
			throw new NoSePuedeUbicarPiezaEnSectoRival("No se puede ubicar pieza en sector rival");
		} else {
			this.fichaActual = Optional.of(fichaActual);
		}
	}

/*	public void ubicar(Ficha fichaActual) {
		this.estado.ubicar(Optional.of(fichaActual), this);
	} //capturar exception de ocupado o sectorEnemigo
*/
	public void eliminar() {
		this.fichaActual = Optional.empty();
	}

}