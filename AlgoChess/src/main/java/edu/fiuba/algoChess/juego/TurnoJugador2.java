package edu.fiuba.algoChess.juego;

public class TurnoJugador2 implements Turno {
	@Override
	public Turno cambiarTurno() {
		return new TurnoJugador1();
	}

	@Override
	public Turno pasar() {
		return new TurnoJugador1();
	}

	@Override
	public Turno rendirse() {
		return new TurnoFinal();
	}
}
