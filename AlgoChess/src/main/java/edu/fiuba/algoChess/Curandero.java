package edu.fiuba.algoChess;

public class Curandero extends Pieza {

	private int sanacion;

	public Curandero(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo,vida,ubicacion,bando);
	}

	public Curandero(){

		super(2,75);
		this.sanacion = 15;

	}

	public Curandero(Ubicacion ubicacion,Bando bando){

		super(2,75,ubicacion,bando);
		this.sanacion = 15;

	}

	public void curar(DistanciaRelativa distancia, Pieza aCurar){

		if ((distancia==DistanciaRelativa.CERCANO)&&(!(aCurar instanceof Catapulta))&&(this.bando.equals(aCurar.getBando()))){
			aCurar.aumentarVida(this.sanacion);
		};
	};

	public int getSanacion(){
		return this.sanacion;
	};


//	public void Sanar(Pieza sanado){
//		sanado.aumentarVida(this.sanacion);
//	}

}
