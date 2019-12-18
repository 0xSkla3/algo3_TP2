package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.excepciones.UbicacionEnTableroInexistenteException;
import edu.fiuba.algoChess.modelo.juego.Jugador;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

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
		try{
			return this.campoDeBatalla.get(ubicacion);}
		catch(IndexOutOfBoundsException ex){
			throw new UbicacionEnTableroInexistenteException("No existe una celda en esa ubicacion");
		}
	}

	public void ubicarEnCeldaFaseInicial(Pieza pieza, Ubicacion ubicacion) {

		try {
			this.campoDeBatalla.get(ubicacion).guardarFaseInicial(pieza);
			pieza.setUbicacion(ubicacion);
		} catch (IndexOutOfBoundsException e) {
			throw new UbicacionEnTableroInexistenteException("No existe una celda en esa ubicacion");
		}
	}

	public void ubicarEnCeldaFaseJuego(Pieza pieza, Ubicacion ubicacion) {
		try {
			this.campoDeBatalla.get(ubicacion).guardarFaseJuego(pieza);
			pieza.setUbicacion(ubicacion);
		} catch (IndexOutOfBoundsException e) {
			throw new UbicacionEnTableroInexistenteException("No existe una celda en esa ubicacion");
		}
	}

	public void eliminar(Ubicacion ubicacion) {
		this.getCelda(ubicacion).eliminar();
	}

}
