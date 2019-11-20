package edu.fiuba.algoChess;

import org.junit.Test;
import static org.junit.Assert.*;


public class BatallonTest {

	@Test
	public void batallonSeMueveEnLaMismaDireccion(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		soldado1.setJugador(jugador1);
		soldado2.setJugador(jugador1);
		soldado3.setJugador(jugador1);
		Batallon batallon = new Batallon(soldado1,soldado2,soldado3);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		batallon.moverseArriba(tableroTest);

		assertEquals(batallon.getSoldado1().getUbicacion(), new Ubicacion(2,3));
		assertEquals(batallon.getSoldado2().getUbicacion(), new Ubicacion(3,3));
		assertEquals(batallon.getSoldado3().getUbicacion(), new Ubicacion(4,3));

	}

	@Test
	public void batallonSeMueveEnLaMismaDireccionOcupandoEspaciosPreviamenteOcupados(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		soldado1.setJugador(jugador1);
		soldado2.setJugador(jugador1);
		soldado3.setJugador(jugador1);
		Batallon batallon = new Batallon(soldado1,soldado2,soldado3);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		batallon.moverseALaDerecha(tableroTest);

		assertEquals(batallon.getSoldado1().getUbicacion(), new Ubicacion(3,2));
		assertEquals(batallon.getSoldado2().getUbicacion(), new Ubicacion(4,2));
		assertEquals(batallon.getSoldado3().getUbicacion(), new Ubicacion(5,2));

	}



}
