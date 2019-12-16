package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.comportamientos.Curacion;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.modelo.rangos.Rango;
import lombok.Getter;
import lombok.Setter;

public class Curandero extends Pieza {

	@Getter
	@Setter
	private Curacion curacion;

	public Curandero(Ubicacion ubicacion, Bando bando, Tablero tablero){

		super(2,75,ubicacion,bando);
		tablero.ubicarEnCeldaFaseInicial(this, ubicacion);
		this.curacion = new Curacion(15);

	}

	@Override
	public Rango actualizaRango(Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Rango getRango() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		this.bando.curar(pieza, this.curacion, pieza.getBando());
	};

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	@Override
	public void atacar(Pieza atacado) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	public void curar(Pieza piezaACurar){
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this.ubicacion, piezaACurar.ubicacion);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, piezaACurar);
	}

}
