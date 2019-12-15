package edu.fiuba.algoChess.modelo.juego;

public class TurnoJugador1 implements Turno {
	@Override
	public Turno cambiarTurno() {
		return new TurnoJugador2();
	}

	@Override
	public Turno pasar() {
		return new TurnoJugador2();
	}

	@Override
	public Turno rendirse() {
		return new TurnoFinal();
	}
}
