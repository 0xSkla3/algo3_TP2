package edu.fiuba.algoChess.juego;

import edu.fiuba.algoChess.bandos.Bando;
import edu.fiuba.algoChess.bandos.BandoJugador1;
import edu.fiuba.algoChess.bandos.BandoJugador2;
import edu.fiuba.algoChess.entidades.*;
import edu.fiuba.algoChess.entorno.Tablero;
import edu.fiuba.algoChess.entorno.Ubicacion;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

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
	private Turno turno;

	public static final Soldado soldado = new Soldado();

	public Juego(){
	this.tablero = new Tablero();
	this.jugador1 = new Jugador();
	this.jugador2 = new Jugador();
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


	public static void main(String[] args) {

	}

	public Pieza crearPieza(String nombre, Ubicacion ubicacion, Bando bando) {

		Pieza pieza = new PiezaNull();

		if (nombre.contains("soldado")){
			return new Soldado(ubicacion,bando,this.tablero);
		}

		if (nombre.contains("catapulta")){
			return new Catapulta(ubicacion,bando,this.tablero);
		}

		if (nombre.contains("jinete")){
			return new Jinete(ubicacion,bando,this.tablero);
		}

		if (nombre.contains("curandero")){
			return new Curandero(ubicacion,bando,this.tablero);
		}
		return new PiezaNull();
	}

	public void aniadirPiezaJugador1(String nombre, Ubicacion ubicacion){
		jugador1.adquirirPieza(crearPieza(nombre, ubicacion, new BandoJugador1()));
	}

	public void aniadirPiezaJugador2(String nombre, Ubicacion ubicacion){
		jugador2.adquirirPieza(crearPieza(nombre, ubicacion, new BandoJugador2()));
	}

	public void atacar(Pieza atacante, Pieza atacado){
		atacante.atacar(atacado);
	}

	public void curar(Pieza curador, Pieza curado){
		curador.curar(curado);
	}

	public void moverseALaDerecha(Pieza pieza){
		pieza.moverseALaDerecha(this.tablero);
	}

	public void moverseALaIzquierda(Pieza pieza){
		pieza.moverseALaIzquierda(this.tablero);
	}

	public void moverseArriba(Pieza pieza){
		pieza.moverseArriba(this.tablero);
	}

	public void moverseAbajo(Pieza pieza){
		pieza.moverseAbajo(this.tablero);
	}

}
