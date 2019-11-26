package edu.fiuba.algoChess;

//import org.jetbrains.annotations.NotNull;

public class Catapulta extends Pieza {

	private AtaqueLejano ataque;
	private int danio = 20;

	public Catapulta(Ubicacion ubicacion,int costo, int vida, Bando bando) {
		super(costo,vida,ubicacion,bando);
	}

	public Catapulta(){

		super(5,50);

		ataque = new AtaqueLejano(danio);

	}

	public Catapulta(int costo, int vida) {
		super(costo,vida);
	}


	public void mover( Tablero campoDeBatalla, Ubicacion ubicacion) {
	};

	public void ejecutarComportamiento(DistanciaRelativa distancia, Pieza atacado){

		if(this.getJugador()!=atacado.getJugador()){
			if (distancia==DistanciaRelativa.CERCANO){
				atacado.recibirAtaque(this.ataque);
			};
			if (distancia==DistanciaRelativa.MEDIO){
				atacado.recibirAtaque(this.ataque);
			};
//			if (distancia==DistanciaRelativa.LEJANO){
//				atacado.recibirAtaque(this.ataqueLejano);
//		};
		}
	}


	public Ataque getAtaqueLejano(){
		return this.ataque;
	};


/*	public void ejecutarComportamiento() {

	}*/



//	public void atacar(Pieza atacado){
//		atacado.recibirAtaque(this.ataqueLejano);
//	}

}