package edu.fiuba.algoChess;

import org.jetbrains.annotations.NotNull;

public class Catapulta extends Ficha {

	private int ataqueLejano;

	public Catapulta(Ubicacion ubicacion,int costo, int vida) {
		super(ubicacion,costo,vida);
	}

	public Catapulta(){

		super(5,50);
		this.nombre = TipoFicha.CATAPULTA;
		this.ataqueLejano = 20;

	}

	public Catapulta(int costo, int vida) {

		super(costo,vida);
	}


	public void mover(@NotNull Tablero campoDeBatalla, Ubicacion ubicacion) {
	}

	public int getAtaqueLejano(){return this.ataqueLejano;}

	public void Atacar(Ficha atacado){

		atacado.bajarVida(this.ataqueLejano);

	}

}