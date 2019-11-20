package edu.fiuba.algoChess;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class Soldado extends Pieza implements Movible {


	private int ataqueCercano;
	private int ataqueMedio;
	private int ataqueLejano;

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

	public int getAtaqueCercano(){
		return this.ataqueCercano;
	};

	public int getAtaqueLejano(){
		return this.ataqueLejano;
	};

	public int getAtaqueMedio(){
		return this.ataqueMedio;
	}

	public Stream<Soldado> verificaBatallon(Tablero tablero) {

		Stream<Optional<Pieza>> contiguos = null;
		Stream<Optional<Pieza>> soldadosContiguos = null;
		Stream<Soldado> batallon = null;
		Soldado segundoSoldado = null;
		contiguos = tablero.mapeaEntornoCercano(tablero.getCelda(this.getUbicacion()));
		soldadosContiguos = contiguos.filter(contiguo -> contiguo.getClass().equals(Soldado.class));

		if(soldadosContiguos.count() == 4){
			Stream.concat(batallon, Stream.of(this));
			Stream.concat(batallon,soldadosContiguos.skip(2));
		} else if (soldadosContiguos.count() == 3){
			Stream.concat(batallon, Stream.of(this));
			Stream.concat(batallon,soldadosContiguos.skip(1));
		} else if(soldadosContiguos.count() == 2) {
			Stream.concat(batallon, Stream.of(this));
			Stream.concat(batallon,soldadosContiguos);
		} else if(soldadosContiguos.count() == 1) {
			Stream.concat(batallon, Stream.of(this));
			Stream.concat(batallon,soldadosContiguos);
			segundoSoldado = (Soldado) soldadosContiguos.findFirst().get().get();
			contiguos = tablero.mapeaEntornoCercano(tablero.getCelda(segundoSoldado.getUbicacion()),Optional.of(this));
			soldadosContiguos = contiguos.filter(contiguo -> contiguo.getClass().equals(Soldado.class));
			if(soldadosContiguos.count() > 0){
				Stream.concat(batallon, Stream.of(soldadosContiguos.findFirst().get().get()));
			}
		}
		return batallon;
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
//	public void atacar(Pieza atacado){
//		atacado.bajarVida(this.ataqueCercano);
//
//	}

}