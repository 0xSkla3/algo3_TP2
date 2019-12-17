package edu.fiuba.algoChess.modelo.juego;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entidades.Soldado;
import edu.fiuba.algoChess.modelo.entidades.*;
import edu.fiuba.algoChess.modelo.entorno.ObservadorTablero;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Juego {

	@Getter
	@Setter
	private Tablero tablero;

	@Getter
	@Setter
	private Jugador jugador1;

	@Getter
	@Setter
	private Jugador jugador2;

	@Getter
	@Setter
	private boolean activoBando1;

	@Getter
	@Setter
	private Bando bandoActivo;

	@Getter
	@Setter
	private Jugador jugadorActivo;

	@Getter
	@Setter
	private ArrayList<Pieza> piezasEnTablero;

	ArrayList<Pieza> piezasMuertas;

	@Getter
	@Setter
	Boolean segundaEtapa = false;

	@Getter
	@Setter
	Boolean finDeJuego = false;

	private ObservadorTablero observadorTablero;

	public static final Soldado soldado = new Soldado();

	public Juego(String nombreJugador1, String nombreJugador2) {
			Bando bando1 = new BandoJugador1();
			Bando bando2 = new BandoJugador2();

			this.tablero = new Tablero(bando1, bando2);
			this.jugador1 = new Jugador(nombreJugador1, bando1);
			this.jugador2 = new Jugador(nombreJugador2, bando2);
			this.piezasEnTablero = new ArrayList<>();
			this.piezasMuertas = new ArrayList<>();
			this.bandoActivo = this.jugador1.getBando();
			this.jugadorActivo = this.jugador1;
			this.activoBando1 = true;
		}

	public Pieza crearPieza (String nombre, Ubicacion ubicacion){
		Pieza pieza;

		//FIXME

		if (nombre.contains("Soldado"))
			pieza = new Soldado(ubicacion, this.bandoActivo, this.tablero);
		else if (nombre.contains("Catapulta"))
			pieza = new Catapulta(ubicacion, this.bandoActivo, this.tablero);
		else if (nombre.contains("Jinete"))
			pieza = new Jinete(ubicacion, this.bandoActivo, this.tablero);
		else if (nombre.contains("Curandero"))
			pieza = new Curandero(ubicacion, this.bandoActivo, this.tablero);
		else
			return new PiezaNull();

		this.getPiezasEnTablero().add(pieza);
		this.jugadorActivo.adquirirPieza(pieza);
		return pieza;
	}

	public void atacar (Pieza atacante, Pieza atacado){
		atacante.atacar(atacado);
		if(! atacado.getVida().stateEstaVivo()) {
			this.tablero.eliminar(atacado.getUbicacion());
			this.piezasEnTablero.remove(atacado);
			this.piezasMuertas.add(atacado);
		}
	}

	public void curar (Curandero curador, Pieza curado){
		curador.curar(curado);
	}

	public Pieza obtenerPiezaAPartirDeUbicacion(Ubicacion ubicacionPiezaObjetivo) {
		Pieza retorno = new PiezaNull();
		return this.getPiezasEnTablero().stream().filter(pieza -> ubicacionPiezaObjetivo.equals(pieza.getUbicacion())).findFirst().orElse(retorno);
	}

	public void pasarTurno(){
		this.jugadorActivo = activoBando1 ? this.jugador2: this.jugador1;
		this.bandoActivo = jugadorActivo.getBando();
		this.activoBando1 = ! activoBando1;
	}

	public void comenzarSegundoStage() {
		setSegundaEtapa(true);
	}

	public void terminarJuego() {
		setFinDeJuego(true);
	}
}
