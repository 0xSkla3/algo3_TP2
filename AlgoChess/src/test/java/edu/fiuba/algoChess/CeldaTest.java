package edu.fiuba.algoChess;

import static org.junit.Assert.*;

import edu.fiuba.algoChess.Celda;
import edu.fiuba.algoChess.Ubicacion;
import org.junit.Test;

public class CeldaTest {

	@Test
	public void celdaTestInicializaVacia(){

		Celda celdaPrueba = new Celda();
		assertTrue(celdaPrueba.getContenido().isEmpty());
	}

	@Test
	public void celdaTestGuardaFicha() {
		Ubicacion origen = new Ubicacion(0,0);
		Curandero ficha = new Curandero(origen);
		Celda celda = new Celda();

		celda.guardar(ficha);
		assertEquals(ficha, celda.getFichaActual());
	}

	@Test
	public void celdaTestBorraFicha() {
		Ubicacion origen = new Ubicacion(0,0);
		Curandero ficha = new Curandero(origen);
		Celda celda = new Celda();

		celda.guardar(ficha);
		celda.eliminar();
		assertTrue(celda.getContenido().isEmpty());
	}

	@Test
	public void celdaTestMueveFicha() {
		Ubicacion origen = new Ubicacion(0,0);
		Curandero ficha = new Curandero(origen);
		Celda celdaOrigen = new Celda();
		Celda celdaDestino = new Celda();
		Curandero fichaAux;

		celdaOrigen.guardar(ficha);
		celdaOrigen.moverA(celdaDestino);

		assertEquals(ficha, celdaDestino.getFichaActual());
	}

	@Test
	public void celdaTestBorraFichaLuegoDeMover() {
		Ubicacion origen = new Ubicacion(0,0);
		Curandero ficha = new Curandero(origen);
		Celda celdaOrigen = new Celda();
		Celda celdaDestino = new Celda();

		celdaOrigen.guardar(ficha);
		celdaOrigen.moverA(celdaDestino);

		assertTrue(celdaOrigen.getContenido().isEmpty());
	}



}
