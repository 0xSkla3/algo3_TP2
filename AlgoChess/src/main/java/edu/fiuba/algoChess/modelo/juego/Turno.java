package edu.fiuba.algoChess.modelo.juego;

public interface Turno {

	public Turno cambiarTurno();
	public Turno pasar();
	public Turno rendirse();

}