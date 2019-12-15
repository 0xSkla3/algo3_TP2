package edu.fiuba.algoChess.modelo.juego;

public class TurnoFinal implements Turno {
	@Override
	public Turno cambiarTurno() {
		return new TurnoFinal();
	}

	@Override
	public Turno pasar() {
		return new TurnoFinal();
	}

	@Override
	public Turno rendirse() {
		return new TurnoFinal();
	}
}
