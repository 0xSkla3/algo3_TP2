package edu.fiuba.algoChess.Modelo.entorno;

import edu.fiuba.algoChess.Modelo.juego.Jugador;
import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.excepciones.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

//@NoArgsConstructor
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
	}

	public void inicializarTablero(Bando bandoJugador1, Bando  bandoJugador2) {

		for (int i = -6; i <= 26; i++) {
			for (int j = -6; j <= 26; j++) {
				this.getCampoDeBatalla().put(new Ubicacion(i, j), new CeldaNull());
			}
		}

		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				this.getCampoDeBatalla().put(new Ubicacion(i, j), new Celda());
			}
		}
		this.asignarSectores(bandoJugador1, bandoJugador2);
		this.inicializarObservadorTablero();
	}

	private void inicializarObservadorTablero() {
		ObservadorTablero observadorTablero = new ObservadorTablero();
		observadorTablero.setTablero(this);
	}

	public void asignarSectores(Bando bandoJugador1,Bando bandoJugador2){

		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 10; j++) {
				this.getCelda(new Ubicacion(j,i)).setSectorDelJugador(bandoJugador1);
			}
			for (int j = 11; j <= 20; j++) {
				this.getCelda(new Ubicacion(j,i)).setSectorDelJugador(bandoJugador2);
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

	public Celda getCeldaONull(Ubicacion ubicacion) {
		if (!this.campoDeBatalla.containsKey(ubicacion)) {
			return new CeldaNull();
		}else {
			return this.campoDeBatalla.get(ubicacion);
		}
	}

	public void ubicarEnCeldaFaseInicial(Pieza pieza, Ubicacion ubicacion) {

		if (!this.campoDeBatalla.containsKey(ubicacion)) {
			throw new NoExisteNingunCasilleroParaLaUbicacionDadaException("No existe una celda en esa ubicacion");
		}

		if (this.campoDeBatalla.get(ubicacion).getPiezaActual().notEqualsNull()) {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
		}

		try {
			this.campoDeBatalla.get(ubicacion).guardarFaseInicial(pieza);
			pieza.setUbicacion(ubicacion);
		} catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
		}
	}

	public void ubicarEnCeldaFaseJuego(Pieza pieza, Ubicacion ubicacion) {

		if (!this.campoDeBatalla.containsKey(ubicacion)) {
			throw new NoExisteNingunCasilleroParaLaUbicacionDadaException("No existe una celda en esa ubicacion");
		}

		if (this.campoDeBatalla.get(ubicacion).getPiezaActual().notEqualsNull()) {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
		}

		try {
			this.campoDeBatalla.get(ubicacion).guardarFaseJuego(pieza);
			pieza.setUbicacion(ubicacion);
		} catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
		}
	}

	public void eliminar(Ubicacion ubicacion) {

		this.getCelda(ubicacion).eliminar();
	}

}
