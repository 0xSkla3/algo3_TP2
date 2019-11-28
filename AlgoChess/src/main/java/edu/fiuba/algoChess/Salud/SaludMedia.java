package edu.fiuba.algoChess.Salud;

public class SaludMedia extends Salud {

	public SaludMedia(int valorCompleto, int valorActual) {
		super(valorCompleto, valorActual);
	}

	@Override
	public Salud curar(int salud) {
		setValorActual(this.getValorActual()+salud);
		return this.getValorActual() > this.getValorCompleto()?new SaludLlena(this.getValorCompleto()):this;
	}

	@Override
	public Salud herir(int salud) {
		setValorActual(this.getValorActual()-salud);
		return this.getValorActual() < 0? new SaludMuerto():this;
	}

}
