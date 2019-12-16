package edu.fiuba.algoChess;

import edu.fiuba.algoChess.modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.batallones.BatallonNull;
import edu.fiuba.algoChess.modelo.batallones.BatallonUtil;
import edu.fiuba.algoChess.modelo.entidades.Curandero;
import edu.fiuba.algoChess.modelo.entidades.Soldado;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import org.junit.Test;
import static org.junit.Assert.*;


public class BatallonTest {

	@Test
	public void Test01batallonSeMueveEnLaMismaDireccion(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1,tableroTest);

		BatallonUtil batallon = new BatallonUtil(soldado1,soldado2,soldado3);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		batallon.moverBatallonArriba(tableroTest);

		assertEquals(batallon.getPieza1().getUbicacion(), new Ubicacion(2,3));
		assertEquals(batallon.getPieza2().getUbicacion(), new Ubicacion(3,3));
		assertEquals(batallon.getPieza3().getUbicacion(), new Ubicacion(4,3));

	}

	@Test
	public void Test02batallonSeMueveEnLaMismaDireccionOcupandoEspaciosPreviamenteOcupados(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1,tableroTest);
		BatallonUtil batallon = new BatallonUtil(soldado1,soldado2,soldado3);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		batallon.moverBatallonDerecha(tableroTest);

		assertEquals(batallon.getPieza1().getUbicacion(), new Ubicacion(3,2));
		assertEquals(batallon.getPieza2().getUbicacion(), new Ubicacion(4,2));
		assertEquals(batallon.getPieza3().getUbicacion(), new Ubicacion(5,2));

	}

	@Test
	public void Test03batallonNoSeMueveCompletoDeEncontrarObstaculos(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2), bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2), bandoJugador1,tableroTest);
		Curandero curandero = new Curandero(new Ubicacion(3,3), bandoJugador1,tableroTest);

		BatallonUtil batallon = new BatallonUtil(soldado1,soldado2,soldado3);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		batallon.moverBatallonArriba(tableroTest);

		assertEquals(batallon.getPieza1().getUbicacion(), new Ubicacion(2,3));
		assertEquals(batallon.getPieza2().getUbicacion(), new Ubicacion(3,2));
		assertEquals(batallon.getPieza3().getUbicacion(), new Ubicacion(4,3));

	}

	@Test
	public void Test03esBatallonNotaQueHayBatallon(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1,tableroTest);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		boolean esBatallon = BatallonUtil.esBatallon(soldado1,soldado2,soldado3);

		assertTrue(esBatallon);

	}

	@Test
	public void Test04noEsBatallonNotaQueNoHayBatallon(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(2,3),bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1,tableroTest);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		boolean esBatallon = BatallonUtil.esBatallon(soldado1,soldado2,soldado3);

		assertFalse(esBatallon);

	}

	@Test
	public void Test05batallonAsociadoONullDaNull(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(2,3),bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1,tableroTest);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Batallon batallonGenerado = BatallonUtil.batallonAsociadoONull(soldado1);

		TestHelper.assertEqualsBatallonNull(batallonGenerado);

	}

	@Test
	public void Test06batallonAsociadoONullCreaBatallon(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1,tableroTest);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Batallon batallonPatron = new BatallonUtil(soldado1,soldado2,soldado3);
		Batallon batallonGenerado = BatallonUtil.batallonAsociadoONull(soldado1);

		TestHelper.assertEqualsBatallon(batallonPatron, batallonGenerado);

	}

}
