package edu.fiuba.algoChess;
import org.junit.Test;

//import modelo.juego.ObjetoUbicable;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class TableroTest {



	@Test
	public void testTableroSeColocaPiezaAliadaConExicitoEnSectorAliado() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion ubicacionTest = new Ubicacion(1,2);
		Curandero curandero = new Curandero();
		curandero.setBando(bandoJugador1);
		Celda celdaTest = tableroTest.getCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(bandoJugador1);
		tableroTest.ubicarEnCelda(curandero,ubicacionTest);
		assertEquals(celdaTest.getPiezaActual(), curandero);
	}


	@Test (expected = NoSePuedeUbicarPiezaEnSectoRival.class)
	public void testTableroSeColocaPiezaAliadaEnSectorRivalTiraException() {
		//si bien el tablero al crearlo ya se inicializa con 2 sectores de celdas preestablecidas
		//en este test se muestra explicitamente que un jugador no puede colocar una pieza en sector rival

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Ubicacion ubicacionTest = new Ubicacion(1,2);
		Curandero curandero = new Curandero(ubicacionTest,bandoJugador1);

		Celda celdaTest = tableroTest.getCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(bandoJugador2);
		tableroTest.ubicarEnCelda(curandero,ubicacionTest);
	}


	@Test (expected = NoSePuedeUbicarPorqueEstaOcupadoException.class)
	public void testTableroUbicarEnUnCeldaOcupadaLanzaExcepcion(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Ubicacion ubicacionTest = new Ubicacion(4,4);
		Curandero curandero1 = new Curandero(ubicacionTest, bandoJugador1);
		Curandero curandero2 = new Curandero(ubicacionTest, bandoJugador1);
		curandero1.setBando(bandoJugador1);
		curandero2.setBando(bandoJugador1);

		Celda celdaTest = tableroTest.getCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(bandoJugador1);
		tableroTest.ubicarEnCelda(curandero1, ubicacionTest);
		tableroTest.ubicarEnCelda(curandero2, ubicacionTest);
	}


/*	@Test
	public void testtableroEsIgualAtableroVacioConMismoTamanioEsFalse(){
		tablero tablero = new tablero(10,10);
        tablero.ubicarEnCasilleroAleatorio(new ObjetoUbicable());
        tablero otrotablero = new tablero(10,10);
        assertFalse(tablero.esIgualA(otrotablero));
	}

	@Test
	public void testtableroEsIgualAtableroVacioConTamanioDiferenteEsFalse(){
		tablero tablero = new tablero(10,10);
		tablero.ubicarEnCasilleroAleatorio(new ObjetoUbicable());
		tablero otrotablero = new tablero(8,10);
		assertFalse(tablero.esIgualA(otrotablero));
	}
*/

}