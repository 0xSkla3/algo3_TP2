package edu.fiuba.algoChess;

import static org.junit.Assert.*;

import org.junit.Test;

public class CeldaTest {

	@Test
	public void celdaTestInicializaVacia(){

		Celda celdaPrueba = new Celda();
		assertTrue(celdaPrueba.isEmpty());
	}

	@Test
	public void celdaTestGuardaPieza() {
		Ubicacion origen = new Ubicacion(0,0);
		BandoJugador1 bandoTest = new BandoJugador1();
		Curandero pieza = new Curandero(origen,bandoTest);
		Celda celda = new Celda(bandoTest);

		celda.ubicarEnCelda(pieza);
		assertEquals(pieza, celda.getPiezaActual());
	}

	@Test
	public void celdaTestBorraPieza() {
		Ubicacion origen = new Ubicacion(0,0);
		BandoJugador1 bandoTest = new BandoJugador1();
		Curandero pieza = new Curandero(origen,bandoTest);
		Celda celda = new Celda(bandoTest);

		celda.ubicarEnCelda(pieza);
		celda.eliminar();
		assertTrue(celda.isEmpty());
	}

/*	@Test
	public void celdaTestMuevePieza() {
		Ubicacion origen = new Ubicacion(0,0);
		BandoJugador1 bandoTest = new BandoJugador1();
		Curandero pieza = new Curandero(origen,bandoTest);
		Celda celdaOrigen = new Celda(bandoTest);
		Celda celdaDestino = new Celda();
		Curandero piezaAux;

		celdaOrigen.guardar(pieza);
		celdaOrigen.moverA(celdaDestino);

		assertEquals(pieza, celdaDestino.getPiezaActual());
	}*/

/*	@Test
	public void celdaTestBorraPiezaLuegoDeMover() {
		Ubicacion origen = new Ubicacion(0,0);
		BandoJugador1 bandoTest = new BandoJugador1();
		Curandero pieza = new Curandero(origen,bandoTest);
		Celda celdaOrigen = new Celda(bandoTest);
		Celda celdaDestino = new Celda(bandoTest);

		celdaOrigen.guardar(pieza);
		celdaOrigen.moverA(celdaDestino);

		assertTrue(celdaOrigen.isEmpty());
	}*/



}
