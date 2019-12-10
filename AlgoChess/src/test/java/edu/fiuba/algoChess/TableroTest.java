package edu.fiuba.algoChess;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.entidades.Curandero;
import edu.fiuba.algoChess.Modelo.entorno.Celda;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPiezaEnSectoRival;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.Modelo.juego.Jugador;
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
		tableroTest.ubicarEnCeldaFaseInicial(curandero,ubicacionTest);
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
		tableroTest.ubicarEnCeldaFaseInicial(curandero,ubicacionTest);
	}


	@Test (expected = NoSePuedeUbicarPorqueEstaOcupadoException.class)
	public void testTableroUbicarEnUnCeldaOcupadaLanzaExcepcion(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Ubicacion ubicacionTest = new Ubicacion(4,4);
		Curandero curandero1 = new Curandero(ubicacionTest, bandoJugador1, tableroTest);
		Curandero curandero2 = new Curandero(ubicacionTest, bandoJugador1, tableroTest);

		Celda celdaTest = tableroTest.getCelda(ubicacionTest);
		celdaTest.setSectorDelJugador(bandoJugador1);
		tableroTest.ubicarEnCeldaFaseInicial(curandero1, ubicacionTest);
		tableroTest.ubicarEnCeldaFaseInicial(curandero2, ubicacionTest);
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
