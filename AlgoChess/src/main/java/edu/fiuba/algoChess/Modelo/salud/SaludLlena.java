package edu.fiuba.algoChess.Modelo.salud;

public class SaludLlena extends Salud {

	public SaludLlena(double salud){
		super(salud,salud);
	}

	@Override
	public Salud curar(double salud) {
		return this;
	}

	@Override
	public Salud herir(double salud) {
		setValorActual(this.getValorActual()-salud);
		return this.getValorActual() == this.getValorCompleto()? this : new SaludMedia(this.getValorCompleto(),this.getValorActual());
	}

}