package edu.fiuba.algoChess;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class Curandero extends Pieza {

	private int sanacion;

	public Curandero(Ubicacion ubicacion,int costo, int vida) {
		super(ubicacion,costo,vida);
	}

	public Curandero(){

		super(2,75);
		//this.nombre = TipoPieza.CURANDERO;
		this.sanacion = 15;

	}

	public Curandero(Ubicacion ubicacion){

		super(2,75);
		//this.nombre = TipoPieza.CURANDERO;
		this.sanacion = 15;
		this.ubicacion = ubicacion;

	}

	public void ejecutarComportamiento() {
	}

	public int getSanacion(){
		return this.sanacion;
	}

	public void Sanar(Pieza sanado){
		sanado.aumentarVida(this.sanacion);
	}

}
