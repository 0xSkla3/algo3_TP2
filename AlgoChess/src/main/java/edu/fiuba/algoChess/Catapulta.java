package edu.fiuba.algoChess;

//import org.jetbrains.annotations.NotNull;

public class Catapulta extends Pieza {

	private int ataqueLejano;
	private int ataqueCercano;
	private int ataqueMedio;

	public Catapulta(Ubicacion ubicacion,int costo, int vida) {
		super(ubicacion,costo,vida);
	}

	public Catapulta(){

		super(5,50);
		//this.nombre = TipoPieza.CATAPULTA;
		this.ataqueLejano = 0;
		this.ataqueCercano = 0;
		this.ataqueMedio = 20;

	}

	public Catapulta(int costo, int vida) {
		super(costo,vida);
	}


	public void mover( Tablero campoDeBatalla, Ubicacion ubicacion) {
	};

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


	public int getAtaqueLejano(){
		return this.ataqueLejano;
	};

	public int getAtaqueCercano(){
		return this.ataqueCercano;
	};

	public int getAtaqueMedio(){
		return this.ataqueMedio;
	}

/*	public void ejecutarComportamiento() {

	}*/



//	public void atacar(Pieza atacado){
//		atacado.bajarVida(this.ataqueLejano);
//	}

}