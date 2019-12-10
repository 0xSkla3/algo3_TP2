package edu.fiuba.algoChess.Modelo.juego;

import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entidades.Soldado;
import edu.fiuba.algoChess.Modelo.entidades.*;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
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
	private BandoJugador1 bandoJugador1;

	@Getter
	@Setter
	private BandoJugador2 bandoJugador2;

	@Getter
	@Setter
	private Turno turno;

	//private EstadoJuego estadoJuego;

	public static final Soldado soldado = new Soldado();

	public Juego() {

		this.jugador1 = new Jugador();
		this.jugador1.setBando(new BandoJugador1());
		this.jugador2 = new Jugador();
		this.jugador2.setBando(new BandoJugador2());
		this.tablero = new Tablero(jugador1.getBando(), jugador2.getBando());

	}

	public Juego(String nombreJugador1, String nombreJugador2) {

			this.bandoJugador1 = new BandoJugador1();
			this.bandoJugador2 = new BandoJugador2();
			this.tablero = new Tablero(this.bandoJugador1, this.bandoJugador2);
			this.jugador1 = new Jugador(nombreJugador1);
			this.jugador2 = new Jugador(nombreJugador2);

	}

	public static void FaseInicial () {

		int creditodJugador1 = 20;
		int creditodJugador2 = 20;
		ArrayList<Pieza> equipo1;
		ArrayList<Pieza> equipo2;
		boolean finDeCargaJugador1 = false;
		boolean finDeCargaJugador2 = false;

		do {

			if (creditodJugador1 > 1 && !finDeCargaJugador1) {
			}

			if (creditodJugador2 > 1 && !finDeCargaJugador1) {
			}

		} while (creditodJugador1 > 1 || creditodJugador2 > 1);

	}


		public static void main (String[]args){

		}

	//public void ubicarEnCelda (Pieza pieza, Ubicacion ubicacion){ this.tablero.ubicarEnCeldaFaseInicial(pieza, ubicacion); }

	//public void ubicarEnCelda (Pieza pieza, Ubicacion ubicacion){
	//	this.estadoJuego.ubicarEnCelda(pieza, ubicacion, tablero);
	//}


	public Pieza crearPieza (String nombre, Ubicacion ubicacion, String bando){

			Pieza pieza = new PiezaNull();
			Bando bando1 = new BandoJugador1();
			Bando bando2 = new BandoJugador2();

			if (bando.contains("jugador1")) {

				if (nombre.contains("Soldado")) {
					return new Soldado(ubicacion, bando1, this.tablero);
				}

				if (nombre.contains("Catapulta")) {
					return new Catapulta(ubicacion, bando1, this.tablero);
				}

				if (nombre.contains("Jinete")) {
					return new Jinete(ubicacion, bando1, this.tablero);
				}

				if (nombre.contains("Curandero")) {
					return new Curandero(ubicacion, bando1, this.tablero);
				}
			} else {

				if (nombre.contains("Soldado")) {
					return new Soldado(ubicacion, bando2, this.tablero);
				}

				if (nombre.contains("Catapulta")) {
					return new Catapulta(ubicacion, bando2, this.tablero);
				}

				if (nombre.contains("Jinete")) {
					return new Jinete(ubicacion, bando2, this.tablero);
				}

				if (nombre.contains("Curandero")) {
					return new Curandero(ubicacion, bando2, this.tablero);
				}
			}

			return new PiezaNull();
		}

		public void atacar (Pieza atacante, Pieza atacado){
			atacante.atacar(atacado);
		}

		public void curar (Pieza curador, Pieza curado){
			curador.curar(curado);
		}

		public void moverseALaDerecha (Pieza pieza){
			pieza.moverseALaDerecha(this.tablero);
		}

		public void moverseALaIzquierda (Pieza pieza){
			pieza.moverseALaIzquierda(this.tablero);
		}

		public void moverseArriba (Pieza pieza){
			pieza.moverseArriba(this.tablero);
		}

		public void moverseAbajo (Pieza pieza) {
			pieza.moverseAbajo(this.tablero);
		}


	public void aniadirPiezaJugador1(String nombre, Ubicacion ubicacion) {
		jugador1.adquirirPieza(crearPieza(nombre, ubicacion, "jugador1"));
	}

	public void aniadirPiezaJugador2(String nombre, Ubicacion ubicacion) {
		jugador2.adquirirPieza(crearPieza(nombre, ubicacion, "jugador2"));
	}

}
