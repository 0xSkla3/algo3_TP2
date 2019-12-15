package edu.fiuba.algoChess.modelo.salud;

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
	public Salud herir(double salud) {
		setValorActual(this.getValorActual()-salud);
		return this.getValorActual() < 0? new SaludMuerto():this;
	}

}
