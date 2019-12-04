package edu.fiuba.algoChess;

import static org.junit.Assert.*;

import edu.fiuba.algoChess.bandos.BandoJugador1;
import edu.fiuba.algoChess.entidades.Curandero;
import edu.fiuba.algoChess.entidades.PiezaNull;
import edu.fiuba.algoChess.entorno.Celda;
import edu.fiuba.algoChess.entorno.Ubicacion;
import org.junit.Test;

public class CeldaTest {

	@Test
	public void celdaTestInicializaVacia(){

		Celda celdaPrueba = new Celda();
		PiezaNull piezaNull = new PiezaNull(null);
		assertTrue(celdaPrueba.getPiezaActual().getClass() == piezaNull.getClass());
	}

	@Test
	public void celdaTestGuardaPieza() {
		Ubicacion origen = new Ubicacion(0,0);
		BandoJugador1 bandoTest = new BandoJugador1();
		Curandero pieza = new Curandero(origen,bandoTest);
		Celda celda = new Celda(bandoTest);

		celda.guardar(pieza);
		assertEquals(pieza, celda.getPiezaActual());
	}

	@Test
	public void celdaTestBorraPieza() {
		Ubicacion origen = new Ubicacion(0,0);
		BandoJugador1 bandoTest = new BandoJugador1();
		Curandero pieza = new Curandero(origen,bandoTest);
		Celda celda = new Celda(bandoTest);
		PiezaNull piezaNull = new PiezaNull(null);

		celda.guardar(pieza);
		celda.eliminar();
		assertTrue(celda.getPiezaActual().getClass() == piezaNull.getClass());
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
