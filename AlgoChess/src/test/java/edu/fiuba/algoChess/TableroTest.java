package edu.fiuba.algoChess;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.fiuba.algoChess.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.NoSePuedeEliminarPorqueEstaVacioException;
//import modelo.juego.ObjetoUbicable;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class TableroTest {



	@Test
	public void testTableroSeColocaPiezaAliadaConExicitoEnSectorAliado() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1,jugador2);
		Ubicacion ubicacionTest = new Ubicacion(1,2);
		Curandero curandero = new Curandero();
		curandero.setJugador(jugador1);
		Celda celdaTest = tableroTest.obtenerCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(jugador1);
		tableroTest.ubicarEnCelda(curandero,ubicacionTest);
		assertEquals(celdaTest.getPiezaActual(), curandero);
	}


	@Test (expected = NoSePuedeUbicarPiezaEnSectoRival.class)
	public void testTableroSeColocaPiezaAliadaEnSectorRivalTiraException() {
		//si bien el tablero al crearlo ya se inicializa con 2 sectores de celdas preestablecidas
		//en este test se muestra explicitamente que un jugador no puede colocar una pieza en sector rival
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Ubicacion ubicacionTest = new Ubicacion(1,2);
		Curandero curandero = new Curandero();
		curandero.setJugador(jugador1);
		Celda celdaTest = tableroTest.obtenerCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(jugador2);
		tableroTest.ubicarEnCelda(curandero,ubicacionTest);
	}


	@Test (expected = NoSePuedeUbicarPorqueEstaOcupadoException.class)
	public void testTableroUbicarEnUnCeldaOcupadaLanzaExcepcion(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Ubicacion ubicacionTest = new Ubicacion(4,4);
		Curandero curandero1 = new Curandero();
		Curandero curandero2 = new Curandero();
		curandero1.setJugador(jugador1);
		curandero2.setJugador(jugador1);
		Celda celdaTest = tableroTest.obtenerCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(jugador1);
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