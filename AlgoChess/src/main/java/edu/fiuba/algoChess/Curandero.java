package edu.fiuba.algoChess;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class Curandero extends Pieza {

	private int sanacion;
	private Comportamiento curacion;

	public Curandero(Ubicacion ubicacion,int costo, int vida, Bando bando) {
		super(costo,vida,ubicacion,bando);
	}

	public Curandero(){

		super(2,75);
		this.sanacion = 15;

	}

	public Curandero(Ubicacion ubicacion,Bando bando){

		super(2,75,ubicacion,bando);
		this.sanacion = 15;
		this.curacion = new CuracionCercanaCurandero(15);

	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
	//	pieza.aplicarCuracionAPieza(this);//pieza es la pieza a curar y this es el curandero
		this.bando.curar(pieza, this.curacion, pieza.getBando());
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
		};

	public void curar(Pieza piezaACurar){
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this,piezaACurar);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, piezaACurar);
	};


	///////@@@@@@@@@@@@@@@@

//	public void curar(DistanciaRelativa distancia, Pieza aCurar){
//
//		if ((distancia==DistanciaRelativa.CERCANO)&&(!(aCurar instanceof Catapulta))&&(this.bando.equals(aCurar.getBando()))){
//			aCurar.aumentarVida(this.sanacion);
//		};
//	};

	public int getSanacion(){
		return this.sanacion;
	};

	public Comportamiento getCuracion(){
		return this.curacion;
	}

//	public void Sanar(Pieza sanado){
//		sanado.aumentarVida(this.sanacion);
//	}

}
