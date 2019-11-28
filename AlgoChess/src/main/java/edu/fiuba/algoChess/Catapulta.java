package edu.fiuba.algoChess;

//import org.jetbrains.annotations.NotNull;

public class Catapulta extends Pieza {

	private AtaqueLejano ataque;
	private int danio = 20;
//	public int costo = 5;
//	private int vida = 50;     no puedo pasar estos parametros en el constructor super, averiguar como hacer

	public Catapulta(Ubicacion ubicacion,Bando bando){

		super(5,50,ubicacion,bando);
		ataque = new AtaqueLejano(danio);

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

	public void atacar(DistanciaRelativa distancia, Pieza atacado){

		if(!this.bando.equals(atacado.getBando())){
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