package edu.fiuba.algoChess.Modelo.salud;

import edu.fiuba.algoChess.Modelo.excepciones.NoPuedeInteractuarseConAlgoNoVivo;

public class SaludMuerto extends Salud {

	public SaludMuerto(){
		super(0,0);
	}

	@Override
	public Salud curar(double salud) {
		throw new NoPuedeInteractuarseConAlgoNoVivo("no puede interactuarse con algo no vivo");
	}

	@Override
	public Salud herir(double salud) {
		throw new NoPuedeInteractuarseConAlgoNoVivo("no puede interactuarse con algo no vivo");
	}

	@Override
	public void stateComportarse() {
		throw new NoPuedeInteractuarseConAlgoNoVivo("no puede interactuarse con algo no vivo");
	}
}
