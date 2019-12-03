package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Stream;

@NoArgsConstructor
public class Tablero {

	@Getter
	@Setter
	private Map<Ubicacion, Celda> campoDeBatalla;

	@Getter
	@Setter
	private Jugador jugadorActivo;

	public Tablero(Bando bandoJugador1, Bando  bandoJugador2) {
		this.campoDeBatalla = new HashMap<>();
		this.inicializarTablero(bandoJugador1, bandoJugador2);
		//this.celdaActiva=this.campoDeBatalla.get(new Ubicacion(1,1));
	}

	public void inicializarTablero(Bando bandoJugador1, Bando  bandoJugador2) {
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				this.getCampoDeBatalla().put(new Ubicacion(i, j), new Celda());
			}
		}
		this.asignarSectores(bandoJugador1, bandoJugador2);
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
	}

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

		if (this.campoDeBatalla.get(ubicacion).getPiezaActual().notEqualsNull()) {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
		}

		try {
			this.campoDeBatalla.get(ubicacion).guardar(pieza);
			pieza.setUbicacion(ubicacion);
			//pieza.getRango().actualizaPiezasEnRango(pieza);
		} catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
		}
	}

	public void eliminar(Ubicacion ubicacion) {

		this.getCelda(ubicacion).eliminar();
	}

}

