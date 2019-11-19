package edu.fiuba.algoChess;

//import org.jetbrains.annotations.NotNull;

import static java.lang.Math.abs;
public class Jinete extends Pieza {

	private int ataqueMedio;
	private int ataqueCercano;
	private int ataqueLejano;

	public Jinete(Ubicacion ubicacion, int costo, int vida) {
		super(ubicacion, costo, vida);
	}

	public Jinete() {

		super(3, 100);
		//this.nombre = TipoPieza.JINETE;
		this.ataqueCercano = 5;
		this.ataqueMedio = 15;
		this.ataqueLejano = 0;

	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCelda(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
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





//	public void atacar(DistanciaRelativa.LEJANO distancia, Pieza atacado){
//		atacado.bajarVida(this.ataqueLejano);
//	}
//	public void atacar(DistanciaRelativa.CERCANO distancia, Pieza atacado){
//		atacado.bajarVida(this.ataqueCercano);
//	}
//	public void atacar(DistanciaRelativa.MEDIO distancia, Pieza atacado){
//		atacado.bajarVida(this.ataqueLejano);
//	}


	public int getAtaqueMedio(){
		return this.ataqueMedio;
	};

	public int getAtaqueCercano(){
		return this.ataqueCercano;
	};

	public int getAtaqueLejano(){
		return this.ataqueLejano;
	};
}


