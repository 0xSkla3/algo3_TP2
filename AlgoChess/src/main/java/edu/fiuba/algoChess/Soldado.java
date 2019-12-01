package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


import java.util.Optional;
import java.util.ArrayList;

public class Soldado extends Pieza implements Movible {

//	@Getter
//	@Setter
	//private Comportamiento comportamiento;

	@Getter
	@Setter
	private RangoSoldado rango;

	@Getter
	private int danioCercano;
	private Comportamiento ataqueCercano = new AtaqueCercanoSoldado(10);

	public Soldado(Ubicacion ubicacion, int costo, int vida, Bando bando) {

		super(costo,vida,ubicacion,bando);
	}

/*	public Soldado(){

		super(1,100);
		danioCercano = 10;
		this.ataque = new AtaqueCercano(danioCercano);


	}*/

	public Soldado(Ubicacion ubicacion,Bando bando){

		super(2,75,ubicacion,bando);


		danioCercano = 10;
		this.ataque = new AtaqueCercano(danioCercano);
	}

	public Soldado(Ubicacion ubicacion, Tablero tablero){
		super(ubicacion);
		this.rango = new RangoSoldado(this, tablero);
	}

	public Rango actualizaRango(Tablero tablero){
		return this.getRango().actualizaRangoInmediato(this,tablero);
	}

	@Override
	public void unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		stackDeUnion.add(this);
	}

	@Override
	public void aniadirPiezaAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
	}

	@Override
	public void aniadirSoldadoAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
	}


	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueCercano, pieza.getBando());
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
		};

	public void atacar(Pieza atacado){
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this,atacado);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, atacado);
	};

	public Comportamiento getAtaqueCercano(){
		return this.ataqueCercano;
	}


	public Batallon verificaBatallonONull(Tablero tablero) {
		return Batallon.batallonAsociadoONull(this,tablero);

	@Override
	public void aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
	}

	public void atacar(DistanciaRelativa distancia, Pieza atacado){
		this.bando.atacar(atacado, this.ataque, atacado.getBando());
	}

	public Batallon verificaBatallonONull() {
		return this.rango.darDeAltaBatallon();
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos(){
		return this.getRango().getSoldadosEquipo();
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return this.getRango().getSoldadosEquipo().size() == 3;
	}

	Batallon unirSoldados(){
		return this.getRango().darDeAltaBatallon();
	}

	/*public Stream<Soldado> verificaBatallon(Soldado soldado, Tablero tablero) {

		Stream<Optional<Pieza>> contiguos = null;
		Stream<Optional<Pieza>> soldadosContiguos = null;
		Stream<Soldado> batallon = null;
		Soldado segundoSoldado = null;
		contiguos = tablero.mapeaEntornoCercano(tablero.getCelda(soldado.getUbicacion()));
		soldadosContiguos = contiguos.filter(contiguo -> contiguo.getClass().equals(Soldado.class));

		if(soldadosContiguos.count() > 1){
			Stream.concat(batallon, Stream.of(soldado));
			Stream.concat(batallon, soldadosContiguos.iterate(0, n -> n+1).limit(2));
		} else if(soldadosContiguos.count() == 1) {
			Stream.concat(batallon, Stream.of(soldado));
			Stream.concat(batallon,soldadosContiguos);
			segundoSoldado = (Soldado) soldadosContiguos.findFirst().get().get();
			contiguos = tablero.mapeaEntornoCercano(tablero.getCelda(segundoSoldado.getUbicacion()),Optional.of(soldado));
			soldadosContiguos = contiguos.filter(contiguo -> contiguo.getClass().equals(Soldado.class));
			if(soldadosContiguos.count() > 0){
				Stream.concat(batallon, Stream.of(soldadosContiguos.findFirst().get().get()));
			}
		}
		return batallon;
	} */

  }
