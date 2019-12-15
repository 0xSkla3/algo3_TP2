package edu.fiuba.algoChess.Modelo.salud;

import edu.fiuba.algoChess.Modelo.comportamientos.Ataque;

public class SaludMuerto extends Salud {

	public SaludMuerto(){
		super(0,0);
	}

	@Override
	public Salud curar(double salud) {
		return this;
	}

	@Override
	public Salud herir(double danioARecibir) {
		return this;
	}

}
