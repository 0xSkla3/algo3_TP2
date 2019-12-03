package edu.fiuba.algoChess;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RangoInmediatoTest {

	@Test
	public void rangoActualizaSoldadosCorrectamente(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2), bandoJugador1, tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1, tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2), bandoJugador1, tableroTest);

		soldado2.getRango().actualizaRangoInmediato(soldado2,tableroTest);

		assertTrue(soldado2.getRango().getPiezasEnRango().contains(soldado1));
		assertTrue(soldado2.getRango().getPiezasEnRango().contains(soldado3));

	}

	@Test
	public void rangoActualizaJinetesContiguosCorrectamente(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Jinete jinete1 = new Jinete(new Ubicacion(2,2), bandoJugador1, tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1, tableroTest);
		Jinete jinete3 = new Jinete(new Ubicacion(4,2), bandoJugador1, tableroTest);

		soldado2.getRango().actualizaRangoInmediato(soldado2,tableroTest);

		assertTrue(soldado2.getRango().getPiezasEnRango().contains(jinete1));
		assertTrue(soldado2.getRango().getPiezasEnRango().contains(jinete3));

	}

	@Test
	public void rangoActualizaCuranderosContiguosCorrectamente(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Curandero curandero1 = new Curandero(new Ubicacion(2,2), bandoJugador1, tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1, tableroTest);
		Curandero curandero3 = new Curandero(new Ubicacion(4,2), bandoJugador1, tableroTest);

		soldado2.getRango().actualizaRangoInmediato(soldado2,tableroTest);

		assertTrue(soldado2.getRango().getPiezasEnRango().contains(curandero1));
		assertTrue(soldado2.getRango().getPiezasEnRango().contains(curandero3));

	}

	@Test
	public void rangoActualizaCatapultasContiguasCorrectamente(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Catapulta catapulta1 = new Catapulta(new Ubicacion(2,2), bandoJugador1, tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1, tableroTest);
		Catapulta catapulta3 = new Catapulta(new Ubicacion(4,2), bandoJugador1, tableroTest);

		soldado2.getRango().actualizaRangoInmediato(soldado2,tableroTest);

		assertTrue(soldado2.getRango().getPiezasEnRango().contains(catapulta1));
		assertTrue(soldado2.getRango().getPiezasEnRango().contains(catapulta3));

	}


}
