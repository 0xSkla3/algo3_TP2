package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.stream.Stream;


public class Soldado extends Pieza implements Movible {

	@Getter
	@Setter
	private Ataque ataque;

	@Getter
	@Setter
	private RangoSoldado rango;

	@Getter
	private int danioCercano;

	public Soldado(Ubicacion ubicacion,int costo, int vida, Bando bando) {

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

	public Soldado(Ubicacion ubicacion){

		super(ubicacion);
		this.rango = new RangoSoldado();

	}

	public void actualizaRango(Tablero tablero){

		this.getRango().actualizaRango(this,tablero);

	}

	public void atacar(DistanciaRelativa distancia, Pieza atacado){

		this.bando.atacar(atacado, this.ataque, atacado.getBando());

	/*	if(this.getJugador()!=atacado.getJugador()){
			if (distancia==DistanciaRelativa.CERCANO){
				atacado.recibirAtaque(this.ataque);
			};
		}*/
//		if (distancia==DistanciaRelativa.LEJANO){
//			atacado.recibirAtaque(this.ataqueLejano);
//		};

//		if (distancia==DistanciaRelativa.MEDIO){
//			atacado.recibirAtaque(this.ataqueMedio);
//		}
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