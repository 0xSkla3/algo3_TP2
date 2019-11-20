package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.stream.Stream;


public class Soldado extends Pieza implements Movible {

	@Getter
	@Setter
	private int ataqueCercano;

	@Getter
	@Setter
	private int ataqueMedio;

	@Getter
	@Setter
	private int ataqueLejano;

	@Getter
	@Setter
	private RangoSoldado rango;

	public Soldado(Ubicacion ubicacion,int costo, int vida) {

		super(ubicacion,costo,vida);
	}

	public Soldado(){

		super(1,100);
		//this.nombre = TipoPieza.SOLDADO;
		this.ataqueCercano = 10;
		this.ataqueLejano = 0;
		this.ataqueMedio=0;

	}

	public Soldado(Ubicacion ubicacion){

		super(ubicacion);
		this.rango = new RangoSoldado();

	}

	public void actualizaRango(Tablero tablero){

		this.getRango().actualizaRango(this,tablero);

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

	public Batallon verificaBatallonONull(Tablero tablero) {
		return Batallon.batallonAsociadoONull(this,tablero);
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