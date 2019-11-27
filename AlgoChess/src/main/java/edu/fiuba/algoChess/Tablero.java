package edu.fiuba.algoChess;
import org.junit.Assert;

import java.util.*;
import java.util.stream.Stream;

public class Tablero {

	private Map<Ubicacion, Celda> campoDeBatalla;
	private Celda celdaActiva; //la celda en la que estoy parada
	private Jugador jugadorActivo;

	public Tablero(Bando bandoJugador1, Bando  bandoJugador2) {
		this.inicializarTablero(bandoJugador1, bandoJugador2);
		//this.celdaActiva=this.campoDeBatalla.get(new Ubicacion(1,1));
	}

	public void setCeldaActiva(Celda celda){
		this.celdaActiva = celda;
	}

	public void inicializarTablero(Bando bandoJugador1, Bando  bandoJugador2) {
		this.campoDeBatalla = new HashMap<>();
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				this.campoDeBatalla.put(new Ubicacion(i, j), new Celda());
			}
		}
		this.asignarSectores(bandoJugador1, bandoJugador2);
	//	setCeldaActiva(this.campoDeBatalla.get(new Ubicacion(1,1)));
	}

	public void asignarSectores(Bando bandoJugador1,Bando bandoJugador2){
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 20; j++) {
				this.getCelda(new Ubicacion(i, j)).setSectorDelJugador(bandoJugador1);
			}
		}
		for (int i = 11; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				this.getCelda(new Ubicacion(i, j)).setSectorDelJugador(bandoJugador2);
			}
		}
		//setCeldaActiva(this.campoDeBatalla.get(new Ubicacion(1,1)));
	}
/*
	public void moverPieza(Celda nuevaActiva) {
		this.celdaActiva.moverA(nuevaActiva);
	}
*/
	public Celda getCelda(Ubicacion ubicacion) {
		if (!this.campoDeBatalla.containsKey(ubicacion)) {
			throw new NoExisteNingunCasilleroParaLaUbicacionDadaException("No existe una celda en esa ubicacion");
		}else {
			return this.campoDeBatalla.get(ubicacion);
		}
	}

	public void ubicarEnCelda(Pieza pieza, Ubicacion ubicacion) {

		if (!this.campoDeBatalla.containsKey(ubicacion)) {
			throw new NoExisteNingunCasilleroParaLaUbicacionDadaException("No existe una celda en esa ubicacion");
		}

		try {
			//Assert.fail();
			this.campoDeBatalla.get(ubicacion).guardar(pieza);
			pieza.setUbicacion(ubicacion);
		} catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
			//devolver turno al jugador activo
		}

	}

/*	public void ubicarEnCelda(Pieza pieza, Ubicacion ubicacion) {

		if (!this.campoDeBatalla.containsKey(ubicacion)) {
			throw new NoExisteNingunCasilleroParaLaUbicacionDadaException("No existe una celda en esa ubicacion");
		}else if (this.getCelda(ubicacion).getPiezaActual().equals(Optional.empty())) {
			this.campoDeBatalla.get(ubicacion).guardar(pieza);
			pieza.setUbicacion(ubicacion);
		}
		else {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("No se puede ubicar porque esta ocupado la celda");

		}
	}*/


	public void eliminar(Ubicacion ubicacion) { this.getCelda(ubicacion).eliminar();
	}

	public Stream<Pieza> mapeaEntornoCercano(Celda celda){
		return mapeaEntornoCercano(celda, null);
	}

	public Stream<Pieza> mapeaEntornoCercano(Celda celda, Pieza aEvitar){
	//	aEvitar = aEvitar == null? Optional.empty() : aEvitar;
		final Pieza finalAEvitar = aEvitar;
		Stream<Pieza> ret;
		List<Pieza> aux = new ArrayList<>(Collections.emptyList());
		Ubicacion arriba = celda.getPiezaActual().getUbicacion().getUbicacionArriba();
		Ubicacion abajo = celda.getPiezaActual().getUbicacion().getUbicacionAbajo();
		Ubicacion derecha = celda.getPiezaActual().getUbicacion().getUbicacionDerecha();
		Ubicacion izquierda = celda.getPiezaActual().getUbicacion().getUbicacionIzquierda();

		aux.add(this.getCelda(arriba).getPiezaActual());
		aux.add(this.getCelda(abajo).getPiezaActual());
		aux.add(this.getCelda(derecha).getPiezaActual());
		aux.add(this.getCelda(izquierda).getPiezaActual());

		ret = aux.stream();

		/*Stream.concat(ret ,Stream.of(this.getCelda(arriba).getPiezaActual()));
		Stream.concat(ret ,Stream.of(this.getCelda(abajo).getPiezaActual()));
		Stream.concat(ret ,Stream.of(this.getCelda(derecha).getPiezaActual()));
		Stream.concat(ret ,Stream.of(this.getCelda(izquierda).getPiezaActual()));*/

		if(!aEvitar.getClass().equals(Optional.empty())){
			ret.filter(pieza -> !pieza.equals(finalAEvitar));
		}

		return ret;
	}


}


