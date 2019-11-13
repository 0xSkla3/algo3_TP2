package edu.fiuba.algoChess;

public class Soldado extends Ficha implements Movible {


	private int ataqueCercano;
	private int ataqueLejano;

	public Soldado(Ubicacion ubicacion,int costo, int vida) {
		super(ubicacion,costo,vida);
	}

	public Soldado(){

		super(1,100);
		//this.nombre = TipoFicha.SOLDADO;
		this.ataqueCercano = 10;
		this.ataqueLejano = 0;

	}

	public int getAtaqueCercano(){return this.ataqueCercano;}
	public int getAtaqueLejano(){return this.ataqueCercano;}

	public void atacar(Ficha atacado){

		atacado.bajarVida(this.ataqueCercano);

	}

}