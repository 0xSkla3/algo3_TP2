package edu.fiuba.algoChess;

public interface Movible {

	public void moverseALaDerecha(Tablero campoDeBatalla);

	public void moverseALaIzquierda(Tablero campoDeBatalla);

	public void moverseArriba(Tablero campoDeBatalla);

	public void moverseAbajo(Tablero campoDeBatalla);

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion);

}