package edu.fiuba.algoChess;

//import org.jetbrains.annotations.NotNull;

public class Jinete extends Ficha {

	private int ataqueLejano;
	private int ataqueCercano;

	public Jinete(Ubicacion ubicacion,int costo, int vida) {
		super(ubicacion,costo,vida);
	}

	public Jinete(){

		super(3,100);
		//this.nombre = TipoFicha.JINETE;
		this.ataqueCercano = 5;
		this.ataqueLejano = 15;

	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCelda(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}
}
