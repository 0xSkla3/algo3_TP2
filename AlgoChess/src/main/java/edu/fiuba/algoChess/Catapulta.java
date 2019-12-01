package edu.fiuba.algoChess;

import org.jetbrains.annotations.NotNull;
import java.util.Optional;

import java.util.ArrayList;

public class Catapulta extends Pieza {

	private ComportamientoLejano ataque;// quitar
	private int danio = 20;// quitar
	private Comportamiento ataqueMedio = new AtaqueLejanoCatapulta(20);
//	public int costo = 5;
//	private int vida = 50;     no puedo pasar estos parametros en el constructor super, averiguar como hacer

	public Catapulta(Ubicacion ubicacion,Bando bando){

		super(5,50,ubicacion,bando);
		ataque = new ComportamientoLejano(danio);

	}


	public Catapulta(){

		super(5,50);

		ataque = new ComportamientoLejano(danio);

	}

	public Catapulta(int costo, int vida) {
		super(costo,vida);
	}




	public void mover( Tablero campoDeBatalla, Ubicacion ubicacion) {
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
	public void unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
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

	;



	//DOUBLE DISPATCH

//	@Override
//	public void ejecutarComportamientoPorDistancia(DistanciaRelativa distancia) {
//
//	}
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
 	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
		};

	public void atacar(Pieza atacado){
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this,atacado);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, atacado);
	};



	public Comportamiento getAtaqueLejano(){
		return this.ataque;
	};
	public Comportamiento getAtaqueMedio(){
		return this.ataqueMedio;
	}





















//	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	public void ejecutarComportamiento(DistanciaRelativa distancia, Pieza atacado){
//
//		if(!this.bando.equals(atacado.getBando())){
//			if (distancia==DistanciaRelativa.CERCANO){
//				atacado.recibirAtaque(this.ataque);
//			};
//			if (distancia==DistanciaRelativa.MEDIO){
//				atacado.recibirAtaque(this.ataque);
//			};
////			if (distancia==DistanciaRelativa.LEJANO){
////				atacado.recibirAtaque(this.ataqueLejano);
////		};
//		}
//	}





/*	public void ejecutarComportamiento() {

	}*/



//	public void atacar(Pieza atacado){
//		atacado.recibirAtaque(this.ataqueLejano);
//	}

}
