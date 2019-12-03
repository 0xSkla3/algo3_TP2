package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Batallones.Batalloneable;
import edu.fiuba.algoChess.Batallones.BatallonNull;
import edu.fiuba.algoChess.Batallones.BatallonUtil;
import org.junit.Test;
import static org.junit.Assert.*;


public class BatallonTest {

	@Test
	public void Test01batallonSeMueveEnLaMismaDireccion(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Soldado soldado1 = new Soldado(new Ubicacion(2,2),tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),tableroTest);

		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
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
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),tableroTest);
		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
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
		Jinete jinete = new Jinete(new Ubicacion(3,3), bandoJugador1,tableroTest);

		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		jinete.setBando(bandoJugador1);
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
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),tableroTest);
		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Boolean esBatallon = BatallonUtil.esBatallon(soldado1,soldado2,soldado3);

		assertTrue(esBatallon);

	}

	@Test
	public void Test04noEsBatallonNotaQueNoHayBatallon(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(2,3),tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),tableroTest);
		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Boolean esBatallon = BatallonUtil.esBatallon(soldado1,soldado2,soldado3);

		assertFalse(esBatallon);

	}

	@Test
	public void Test05batallonAsociadoONullDaNull(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(2,3),tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),tableroTest);
		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Batalloneable batallonGenerado = BatallonUtil.batallonAsociadoONull(soldado1);
		BatallonNull batallonNull = new BatallonNull() ;

		assertTrue(batallonNull.equals(batallonGenerado));

	}

	@Test
	public void Test06batallonAsociadoONullCreaBatallon(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),tableroTest);
		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Batalloneable batallonPatron = new BatallonUtil(soldado1,soldado2,soldado3);
		Batalloneable batallonGenerado = BatallonUtil.batallonAsociadoONull(soldado1);

		assertTrue(batallonPatron.equals(batallonGenerado));

	}

}
