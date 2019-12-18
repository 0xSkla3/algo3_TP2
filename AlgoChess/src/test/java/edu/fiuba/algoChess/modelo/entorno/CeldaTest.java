package edu.fiuba.algoChess.modelo.entorno;

import static org.junit.Assert.*;

import edu.fiuba.algoChess.modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.modelo.entidades.Curandero;
import edu.fiuba.algoChess.modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.modelo.entorno.Celda;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
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
		Ubicacion origen = new Ubicacion(1,1);
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Curandero pieza = new Curandero(origen,bandoJugador1,tableroTest);
		Celda celda = new Celda(bandoJugador1);

		celda.guardarFaseInicial(pieza);
		assertEquals(pieza, celda.getPiezaActual());
	}

	@Test
	public void celdaTestBorraPieza() {
		Ubicacion origen = new Ubicacion(1,1);
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Curandero pieza = new Curandero(origen,bandoJugador1,tableroTest);
		Celda celda = new Celda(bandoJugador1);
		PiezaNull piezaNull = new PiezaNull(null);

		celda.guardarFaseInicial(pieza);
		celda.eliminar();
		assertTrue(celda.getPiezaActual().getClass() == piezaNull.getClass());
	}

}
