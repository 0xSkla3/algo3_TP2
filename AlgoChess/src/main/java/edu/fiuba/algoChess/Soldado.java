package edu.fiuba.algoChess;

public class Soldado extends Pieza implements Movible {


	private int ataqueCercano;
	private int ataqueMedio;
	private int ataqueLejano;

	public Soldado(Ubicacion ubicacion,int costo, int vida) {

		super(ubicacion,costo,vida);
	}

	public Soldado(){

		super(1,100);
		//this.nombre = TipoPieza.SOLDADO;
		this.ataqueCercano = 10;
		this.ataqueLejano = 0;
		this.ataqueMedio=0;

	}

	public void ejecutarComportamiento(DistanciaRelativa distancia, Pieza atacado){
		if (distancia==DistanciaRelativa.LEJANO){
			atacado.bajarVida(this.ataqueLejano);
		};
		if (distancia==DistanciaRelativa.CERCANO){
			atacado.bajarVida(this.ataqueCercano);
		};
		if (distancia==DistanciaRelativa.MEDIO){
			atacado.bajarVida(this.ataqueMedio);
		}
	}

	public int getAtaqueCercano(){
		return this.ataqueCercano;
	};

	public int getAtaqueLejano(){
		return this.ataqueLejano;
	};

	public int getAtaqueMedio(){
		return this.ataqueMedio;
	}

//	public void atacar(Pieza atacado){
//		atacado.bajarVida(this.ataqueCercano);
//
//	}

}