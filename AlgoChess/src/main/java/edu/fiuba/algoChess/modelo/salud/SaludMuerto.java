package edu.fiuba.algoChess.modelo.salud;

import edu.fiuba.algoChess.modelo.excepciones.InteraccionInvalidaException;

public class SaludMuerto extends Salud {

	public SaludMuerto(){
		super(0,0);
	}

	@Override
	public Salud curar(double salud) {
		throw new InteraccionInvalidaException("no puede interactuarse con algo no vivo");
	}

	@Override
	public Salud herir(double salud) {
		throw new InteraccionInvalidaException("no puede interactuarse con algo no vivo");
	}

	@Override
	public void stateComportarse() {
		throw new InteraccionInvalidaException("no puede interactuarse con algo no vivo");
	}

	@Override
	public boolean stateEstaVivo() {
		return false;
	}
}
