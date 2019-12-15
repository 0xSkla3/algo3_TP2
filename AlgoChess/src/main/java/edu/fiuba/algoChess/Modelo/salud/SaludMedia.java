package edu.fiuba.algoChess.Modelo.salud;

import edu.fiuba.algoChess.Modelo.comportamientos.Ataque;

public class SaludMedia extends Salud {

	public SaludMedia(double valorCompleto, double valorActual) {
		super(valorCompleto, valorActual);
	}

	@Override
	public Salud curar(double salud) {
		setValorActual(this.getValorActual()+salud);
		return this.getValorActual() > this.getValorCompleto()?new SaludLlena(this.getValorCompleto()):this;
	}

	@Override
	public Salud herir(double danioARecibir) {
		setValorActual(this.getValorActual()- danioARecibir);
		return this.getValorActual() < 0? new SaludMuerto():this;
	}

}
