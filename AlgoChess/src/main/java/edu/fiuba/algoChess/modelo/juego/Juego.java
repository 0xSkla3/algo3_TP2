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
import edu.fiuba.algoChess.modelo.excepciones.AccionAgrupableInvalidaException;
import edu.fiuba.algoChess.modelo.excepciones.FaseDeJuegoInvalidaException;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaSobreObjetoNuloException;
import lombok.Getter;

import java.util.ArrayList;

public class Juego {
	@Getter
	private Tablero tablero;

	@Getter
	private Jugador jugador1;

	@Getter
	private Jugador jugador2;

	@Getter
	private boolean activoBando1;

	@Getter
	private Bando bandoActivo;

	@Getter
	private Jugador jugadorActivo;

	@Getter
	private ArrayList<Pieza> piezasEnTablero;

	@Getter
	ArrayList<Pieza> piezasMuertas;

	@Getter
	Boolean segundaEtapa = false;

	@Getter
	Boolean finDeJuego = false;

	private ObservadorTablero observadorTablero;

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

			this.segundaEtapa = false;
			this.finDeJuego = false;
		}

	public Pieza crearPieza (String nombre, Ubicacion ubicacion){
		if(finDeJuego || segundaEtapa)
			throw new FaseDeJuegoInvalidaException("Fase de juego incorrecta");
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
		if(! segundaEtapa)
			throw new FaseDeJuegoInvalidaException("Fase de juego invalida");

		atacante.atacar(atacado);
		if(! atacado.getVida().stateEstaVivo()) {
			this.tablero.eliminar(atacado.getUbicacion());
			this.piezasEnTablero.remove(atacado);
			this.piezasMuertas.add(atacado);

			this.jugadorActivo.sumarPuntaje(atacado.getCosto());
			this.evaluarFinDeJuego();
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
		this.actualizarRangos();
	}

	public void comenzarSegundoStage() {
		this.segundaEtapa = true;
		this.jugadorActivo = jugador1;
		this.bandoActivo = jugador1.getBando();
	}

	private void evaluarFinDeJuego() {
		boolean piezasVivas1 = false;
		boolean piezasVivas2 = false;

		// miro si le queda alguna pieza viva a cada jugador
		for (Pieza p: piezasEnTablero) {
			if(! p.getVida().stateEstaVivo())	continue;
			if(p.getBando() == this.jugador1.getBando())
				piezasVivas1 = true;
			else
				piezasVivas2 = true;
		}

		if(! piezasVivas1 || ! piezasVivas2)
			this.terminarJuego();
	}

	public void terminarJuego() {
		this.finDeJuego = true;
		this.segundaEtapa = false;
	}

	public void actualizarRangos(){
		this.tablero.getCampoDeBatalla().forEach((ubicacion, celda) -> {try{celda.getPiezaActual().actualizaRango(this.tablero);
		}catch(OperacionInvalidaSobreObjetoNuloException | AccionAgrupableInvalidaException e){}
		});
	}
}
