package edu.fiuba.algoChess.modelo.salud;

public class SaludLlena extends Salud {

	public SaludLlena(double salud){
		super(salud,salud);
	}

	@Override
	public Salud curar(double salud) {
		//se deberia lanzar Exceptio de NoSePuedeCurarPiezaFullHP
		return this;
	}

	@Override
	public Salud herir(double danioARecibir) {
		// delegamos en SaludMedia hacer las cuentas y ajustes
		Salud herida = new SaludMedia(this.valorCompleto, this.valorActual);
		return herida.herir(danioARecibir);
	}

}