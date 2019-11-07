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
		Tablero tableroTest = new Tablero();
		Ubicacion ubicacionTest = new Ubicacion(1,2);
		Curandero curandero = new Curandero();
		Jugador jugador1 = new Jugador();
		curandero.setJugador(jugador1);
		Celda celdaTest = tableroTest.obtenerCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(jugador1);
		tableroTest.ubicarEnCelda(curandero,ubicacionTest);
		assertEquals(celdaTest.getFichaActual(), curandero);
	}


	@Test (expected = NoSePuedeUbicarPiezaEnSectoRival.class)
	public void testTableroSeColocaPiezaAliadaEnSectorRivalTiraException() {
		Tablero tableroTest = new Tablero();
		Ubicacion ubicacionTest = new Ubicacion(1,2);
		Curandero curandero = new Curandero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		curandero.setJugador(jugador1);
		Celda celdaTest = tableroTest.obtenerCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(jugador2);
		tableroTest.ubicarEnCelda(curandero,ubicacionTest);
	}


	@Test (expected = NoSePuedeUbicarPorqueEstaOcupadoException.class)
	public void testTableroUbicarEnUnCeldaOcupadaLanzaExcepcion(){
		Tablero tableroTest = new Tablero();
		Ubicacion ubicacionTest = new Ubicacion(4,4);
		Curandero curandero1 = new Curandero();
		Curandero curandero2 = new Curandero();
		Jugador jugadorTest = new Jugador();
		curandero1.setJugador(jugadorTest);
		curandero2.setJugador(jugadorTest);
		Celda celdaTest = tableroTest.obtenerCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(jugadorTest);
		tableroTest.ubicarEnCelda(curandero1, ubicacionTest);
		tableroTest.ubicarEnCelda(curandero2, ubicacionTest);
	}


/*	@Test
	public void testTableroEsIgualATableroVacioConMismoTamanioEsFalse(){
		tablero tablero = new tablero(10,10);
        tablero.ubicarEnCasilleroAleatorio(new ObjetoUbicable());
        tablero otrotablero = new tablero(10,10);
        assertFalse(tablero.esIgualA(otrotablero));
	}

	@Test
	public void testTableroEsIgualATableroVacioConTamanioDiferenteEsFalse(){
		tablero tablero = new tablero(10,10);
		tablero.ubicarEnCasilleroAleatorio(new ObjetoUbicable());
		tablero otrotablero = new tablero(8,10);
		assertFalse(tablero.esIgualA(otrotablero));
	}
*/

}