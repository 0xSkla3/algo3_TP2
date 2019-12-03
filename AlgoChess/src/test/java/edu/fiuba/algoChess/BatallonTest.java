package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Batallones.Batallon;
import edu.fiuba.algoChess.Batallones.BatallonNull;
import edu.fiuba.algoChess.Batallones.BatallonUtil;
import org.junit.Test;
import static org.junit.Assert.*;


public class BatallonTest {

	@Test
	public void batallonSeMueveEnLaMismaDireccion(){
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
		BatallonUtil batallon = new BatallonUtil(soldado1,soldado2,soldado3);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		batallon.moverseArriba(tableroTest);

		assertEquals(batallon.getPieza1().getUbicacion(), new Ubicacion(2,3));
		assertEquals(batallon.getPieza2().getUbicacion(), new Ubicacion(3,3));
		assertEquals(batallon.getPieza3().getUbicacion(), new Ubicacion(4,3));

	}

	@Test
	public void batallonSeMueveEnLaMismaDireccionOcupandoEspaciosPreviamenteOcupados(){
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
		BatallonUtil batallon = new BatallonUtil(soldado1,soldado2,soldado3);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		batallon.moverseALaDerecha(tableroTest);

		assertEquals(batallon.getPieza1().getUbicacion(), new Ubicacion(3,2));
		assertEquals(batallon.getPieza2().getUbicacion(), new Ubicacion(4,2));
		assertEquals(batallon.getPieza3().getUbicacion(), new Ubicacion(5,2));

	}

	@Test
	public void batallonNoSeMueveCompletoDeEncontrarObstaculos(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2),tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),tableroTest);
		Jinete jinete = new Jinete(new Ubicacion(3,3));

		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		jinete.setBando(bandoJugador1);
		BatallonUtil batallon = new BatallonUtil(soldado1,soldado2,soldado3);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());
		tableroTest.ubicarEnCelda(jinete, jinete.getUbicacion());

		batallon.moverseArriba(tableroTest);

		assertEquals(batallon.getPieza1().getUbicacion(), new Ubicacion(2,3));
		assertEquals(batallon.getPieza2().getUbicacion(), new Ubicacion(3,2));
		assertEquals(batallon.getPieza3().getUbicacion(), new Ubicacion(4,3));

	}

	@Test
	public void esBatallonNotaQueHayBatallon(){
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

		Boolean esBatallon = BatallonUtil.esBatallon(soldado1,soldado2,soldado3);

		assertTrue(esBatallon);

	}

	@Test
	public void noEsBatallonNotaQueNoHayBatallon(){
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

		Boolean esBatallon = BatallonUtil.esBatallon(soldado1,soldado2,soldado3);

		assertFalse(esBatallon);

	}

	@Test
	public void batallonAsociadoONullDaNull(){
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

		Batallon batallonGenerado = (Batallon) BatallonUtil.batallonAsociadoONull(soldado1);

		assertEquals(new BatallonNull(), batallonGenerado);

	}

	@Test
	public void batallonAsociadoONullCreaBatallon(){
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

		Batallon batallonPatron = new BatallonUtil(soldado1,soldado2,soldado3);
		Batallon batallonGenerado = (Batallon) BatallonUtil.batallonAsociadoONull(soldado1);

		assertTrue(batallonPatron.equals(batallonGenerado));

	}

}

