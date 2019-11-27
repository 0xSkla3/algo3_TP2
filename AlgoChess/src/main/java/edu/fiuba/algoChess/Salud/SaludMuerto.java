package edu.fiuba.algoChess.Salud;

public class SaludMuerto extends Salud {

	SaludMuerto(){
		super(0,0);
	}

	@Override
	public Salud curar(int salud) {
		return this;
	}

	@Override
	public Salud herir(int salud) {
		return this;
	}

}
