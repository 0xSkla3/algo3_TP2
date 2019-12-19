package edu.fiuba.algoChess.modelo.salud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class Salud implements Curable, Herible, StateVive {

	@Getter
	@Setter
	protected double valorCompleto;

	@Getter
	@Setter
	protected double valorActual;

	@Override
	public abstract Salud curar(double salud);

	public void stateComportarse() {
		//No se comporta
	}

	public boolean stateEstaVivo() {
		return true;
	}

	// Herramienta para testing
	public boolean igualA(Salud salud) {
		return (this.getValorCompleto() == salud.getValorCompleto() && this.getValorActual() == salud.getValorActual());
 }

}
