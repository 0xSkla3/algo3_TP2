package edu.fiuba.algoChess;

import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class SoldadoTest {

	@Test
	public void test00SeVerificaBatallon(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		soldado1.setBando(new BandoJugador1());
		soldado2.setBando(new BandoJugador1());
		soldado3.setBando(new BandoJugador1());
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

			assertTrue(Batallon.esBatallon(soldado1,soldado2,soldado3,tableroTest));

	}

	@Test
	public void test01TresSoldadosContiguosSeMuevenEnLaMismaDireccion(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		soldado1.setBando(new BandoJugador1());
		soldado2.setBando(new BandoJugador1());
		soldado3.setBando(new BandoJugador1());
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		Batallon batallon = soldado1.verificaBatallonONull(tableroTest);

		batallon.moverseArriba(tableroTest);

		assertEquals(batallon.getSoldado1().getUbicacion(), new Ubicacion(4,3));
		assertEquals(batallon.getSoldado2().getUbicacion(), new Ubicacion(3,3));
		assertEquals(batallon.getSoldado3().getUbicacion(), new Ubicacion(2,3));

	}

	@Test
	public void test02TresSoldadosConObstaculoSeMuevenDos(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero unTablero = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Jinete jinete = new Jinete(new Ubicacion(1,2));


	}

	@Test
	public void test03TresSoldadosConObstaculoDisuelveBatallon(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero unTablero = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Jinete jinete = new Jinete(new Ubicacion(1,2));
	}

	@Test
	public void test04CuatroSoldadosContiguosMuevenTres(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Soldado soldado4 = new Soldado(new Ubicacion(5,2));

	};

	@Test
	public void test05SoldadoAliadoAtacaJineteEnemigoCercano(){
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Soldado soldadoAliado = new Soldado();
		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
		soldadoAliado.setUbicacion(ubicacionSoldado);
		soldadoAliado.setBando(new BandoJugador1());
		Jinete jineteEnemigo = new Jinete();
		Ubicacion ubicacionJinete = new Ubicacion(1,2);
		jineteEnemigo.setUbicacion(ubicacionJinete);
		jineteEnemigo.setBando(new BandoJugador2());
		DistanciaRelativa distanciaJineteASoldado = soldadoAliado.getDistanciaRelativa(jineteEnemigo);
		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
		int vidaTrasAtaque = jineteEnemigo.getVida() - soldadoAliado.getDanioCercano();
		soldadoAliado.ejecutarComportamiento(distanciaJineteASoldado,jineteEnemigo);
		assertEquals(vidaTrasAtaque,jineteEnemigo.getVida());
	};

/*	@Test  ESTE TEST DEBE TIRAR FUERA_DE_RANGO_EXCEPT
	public void test06SoldadoAtacaJineteLejanoYNoSeQuitaVidaAJineteAtacado(){
		Soldado soldado = new Soldado();
		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
		soldado.setUbicacion(ubicacionSoldado);
		Jinete jinete = new Jinete();
		Ubicacion ubicacionJinete = new Ubicacion(10,20);
		jinete.setUbicacion(ubicacionJinete);
		DistanciaRelativa distanciaJineteASoldado = soldado.getDistanciaRelativa(jinete);
		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
		int vidaTrasAtaque = jinete.getVida() - soldado.getAtaqueLejano();
		soldado.ejecutarComportamiento(distanciaJineteASoldado,jinete);
		assertEquals(vidaTrasAtaque,jinete.getVida());
	};*/

	@Test
	public void test07SoldadoAliadoNoPuedeAtacaaAJineteAliadoCercano(){
		Jugador jugadorAliado = new Jugador();
		Soldado soldadoAliado = new Soldado();
		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
		soldadoAliado.setUbicacion(ubicacionSoldado);
		soldadoAliado.setJugador(jugadorAliado);
		Jinete jineteAliado = new Jinete();
		Ubicacion ubicacionJinete = new Ubicacion(1,2);
		jineteAliado.setUbicacion(ubicacionJinete);
		jineteAliado.setJugador(jugadorAliado);
		DistanciaRelativa distanciaJineteASoldado = soldadoAliado.getDistanciaRelativa(jineteAliado);
		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
		int vidaTrasAtaque = jineteAliado.getVida();
		soldadoAliado.ejecutarComportamiento(distanciaJineteASoldado,jineteAliado);
		assertEquals(vidaTrasAtaque,jineteAliado.getVida());
	};

}
