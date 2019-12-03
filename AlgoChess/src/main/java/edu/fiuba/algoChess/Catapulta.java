package edu.fiuba.algoChess;

//import org.jetbrains.annotations.NotNull;

import edu.fiuba.algoChess.Batallones.Batalloneable;
import edu.fiuba.algoChess.Rangos.Rango;
import edu.fiuba.algoChess.Rangos.RangoInmediato;

import java.util.ArrayList;

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
	}

	@Override
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		return null;
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {

	}

	@Override
	public Rango actualizaRango(Tablero tablero) {

		return null;
	}

	@Override
	public Rango getRango() {
		return null;
	}

	@Override
	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		return stackDeUnion;
	}

	@Override
	public void aniadirPiezaAlStack(ArrayList<Pieza> stack) {

	}

	@Override
	public void aniadirSoldadoAlStack(ArrayList<Pieza> stack) {

	}

	@Override
	public void aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {

	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		return null;
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return false;
	}

	@Override
	public void setRango(RangoInmediato rangoInmediato) {

	}

	;

	public void ejecutarComportamiento(DistanciaRelativa distancia, Pieza atacado){

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
