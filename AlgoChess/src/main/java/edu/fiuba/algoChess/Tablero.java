package edu.fiuba.algoChess;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import  edu.fiuba.algoChess.Jugador;

public class Tablero {

	private Map<Ubicacion, Celda> campoDeBatalla;
	private Celda celdaActiva; //la celda en la que estoy parada
	private Jugador jugadorActivo;

	public Tablero(Jugador jugador1, Jugador  jugador2) {
		this.inicializarTablero(jugador1, jugador2);
		//this.celdaActiva=this.campoDeBatalla.get(new Ubicacion(1,1));
	}

	public void setCeldaActiva(Celda celda){
		this.celdaActiva = celda;
	}

	public void inicializarTablero(Jugador jugador1, Jugador  jugador2) {
		this.campoDeBatalla = new HashMap<>();
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				this.campoDeBatalla.put(new Ubicacion(i, j), new Celda());
			}
		}
		this.asignarSectores(jugador1, jugador2);
	//	setCeldaActiva(this.campoDeBatalla.get(new Ubicacion(1,1)));
	}

	public void asignarSectores(Jugador jugador1,Jugador jugador2){
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 20; j++) {
				this.obtenerCelda(new Ubicacion(i, j)).setSectorDelJugador(jugador1);
			}
		}
		for (int i = 11; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				this.obtenerCelda(new Ubicacion(i, j)).setSectorDelJugador(jugador2);
			}
		}
		//setCeldaActiva(this.campoDeBatalla.get(new Ubicacion(1,1)));
	}

	public void moverPieza(Celda nuevaActiva) {
		this.celdaActiva.moverA(nuevaActiva);
	}

	public Celda obtenerCelda(Ubicacion ubicacion) {
		if (!this.campoDeBatalla.containsKey(ubicacion)) {
			throw new NoExisteNingunCasilleroParaLaUbicacionDadaException("No existe una celda en esa ubicacion");
		}else {
			return this.campoDeBatalla.get(ubicacion);
		}
	}

	public void ubicarEnCelda(Pieza pieza, Ubicacion ubicacion) {

		if (!this.campoDeBatalla.containsKey(ubicacion)) {
			throw new NoExisteNingunCasilleroParaLaUbicacionDadaException("No existe una celda en esa ubicacion");
		}else if (this.obtenerCelda(ubicacion).getContenido().equals(Optional.empty())) {
			this.campoDeBatalla.get(ubicacion).guardar(pieza);
			pieza.setUbicacion(ubicacion);
		}
		else {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("No se puede ubicar porque esta ocupado la celda");

		}
	}

	public void eliminar(Ubicacion ubicacion) { this.obtenerCelda(ubicacion).eliminar();
	}


}


