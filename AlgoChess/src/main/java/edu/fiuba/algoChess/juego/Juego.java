package edu.fiuba.algoChess.juego;

import edu.fiuba.algoChess.entidades.*;
import edu.fiuba.algoChess.entorno.Tablero;

import java.util.ArrayList;
import java.util.HashMap;

public class Juego {

	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	private HashMap<Pieza, Integer> equipoJugador1;
	private HashMap<Pieza, Integer> equipoJugador2;

	public static final Soldado soldado = new Soldado();
	public static final Catapulta catapulta = new Catapulta();
	public static final Jinete jinete = new Jinete();
	public static final Curandero curandero = new Curandero();


	public Juego(){
	this.tablero = new Tablero();
	this.jugador1 = new Jugador();
	this.jugador2 = new Jugador();
	this.equipoJugador1 = new HashMap<>();
	this.equipoJugador2 = new HashMap<>();
	}

	public static void main(String[] args) {

	}

	public static void FaseInicial() {
		int creditodJugador1 = 20;
		int creditodJugador2 = 20;
		ArrayList<Pieza> equipo1;
		ArrayList<Pieza> equipo2;
		boolean finDeCargaJugador1 = false;
		boolean finDeCargaJugador2 = false;

		do {
			if(creditodJugador1 > 1 && ! finDeCargaJugador1){

			}

			if(creditodJugador2 > 1 && !finDeCargaJugador1){

			}


		} while (creditodJugador1 > 1 || creditodJugador2 > 1);

	}
}