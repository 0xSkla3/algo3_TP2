package edu.fiuba.algoChess.Modelo.salud;

import edu.fiuba.algoChess.Modelo.comportamientos.Ataque;

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
		setValorActual(this.valorActual - danioARecibir);
		//se esta retornando soldado
		return /*this.valorActual == this.valorCompleto ? this : */new SaludMedia(this.valorCompleto ,this.valorActual);
	}

}