package edu.fiuba.algoChess;

import static org.junit.Assert.*;

import edu.fiuba.algoChess.Celda;
import edu.fiuba.algoChess.Ubicacion;
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
		Curandero pieza = new Curandero(origen);
		Celda celda = new Celda();

		celda.guardar(pieza);
		assertEquals(pieza, celda.getPiezaActual());
	}

	@Test
	public void celdaTestBorraPieza() {
		Ubicacion origen = new Ubicacion(0,0);
		Curandero pieza = new Curandero(origen);
		Celda celda = new Celda();

		celda.guardar(pieza);
		celda.eliminar();
		assertTrue(celda.isEmpty());
	}

	@Test
	public void celdaTestMuevePieza() {
		Ubicacion origen = new Ubicacion(0,0);
		Curandero pieza = new Curandero(origen);
		Celda celdaOrigen = new Celda();
		Celda celdaDestino = new Celda();
		Curandero piezaAux;

		celdaOrigen.guardar(pieza);
		celdaOrigen.moverA(celdaDestino);

		assertEquals(pieza, celdaDestino.getPiezaActual());
	}

	@Test
	public void celdaTestBorraPiezaLuegoDeMover() {
		Ubicacion origen = new Ubicacion(0,0);
		Curandero pieza = new Curandero(origen);
		Celda celdaOrigen = new Celda();
		Celda celdaDestino = new Celda();

		celdaOrigen.guardar(pieza);
		celdaOrigen.moverA(celdaDestino);

		assertTrue(celdaOrigen.isEmpty());
	}



}
