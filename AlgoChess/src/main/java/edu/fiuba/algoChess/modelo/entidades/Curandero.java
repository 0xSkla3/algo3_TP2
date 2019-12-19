package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.comportamientos.Curacion;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.FueraDeRangoException;
import edu.fiuba.algoChess.modelo.excepciones.InteraccionInvalidaException;
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
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		this.bando.curar(pieza, this.curacion, pieza.getBando());
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new FueraDeRangoException("Pieza fuera de rango");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoException("Pieza fuera de rango");
	}

	@Override
	public void atacar(Pieza atacado) {
		throw new InteraccionInvalidaException(" Un curandero no puede atacar");
	}

	public void curar(Pieza piezaACurar){
		DistanciaRelativa distanciaEntrePiezas = DistanciaRelativa.calcularDistanciaRelativa(this.ubicacion, piezaACurar.ubicacion);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, piezaACurar);
	}

}
