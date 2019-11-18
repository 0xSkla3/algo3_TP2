package edu.fiuba.algoChess;

import edu.fiuba.algoChess.PosicionRelativa;

public class Soldado extends Pieza implements Movible {


	private int ataqueCercano;
	private int ataqueLejano;

	public Soldado(Ubicacion ubicacion,int costo, int vida) {

		super(ubicacion,costo,vida);
	}

	public Soldado(){

		super(1,100);
		//this.nombre = TipoPieza.SOLDADO;
		this.ataqueCercano = 10;
		this.ataqueLejano = 0;

	}

	public void ejecutarComportamiento() {

	}

	public int getAtaqueCercano(){
		return this.ataqueCercano;
	}
	public int getAtaqueLejano(){
		return this.ataqueCercano;
	}

	public void atacar(Pieza atacado){
		atacado.bajarVida(this.ataqueCercano);

	}

}