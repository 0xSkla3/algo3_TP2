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

//	@Test
//	public void test01TresSoldadosContiguosSeMuevenEnLaMismaDireccion(){
//
//
//		BandoJugador1 bandoJugador1 = new BandoJugador1();
//		BandoJugador2 bandoJugador2 = new BandoJugador2();
//		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
//
//		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1);
//		Soldado soldado2 = new Soldado(new Ubicacion(3,2),bandoJugador1);
//		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1);
//
//		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
//		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
//		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());
//
//		Batallon batallon = soldado1.verificaBatallonONull(tableroTest);
//
//		batallon.moverseArriba(tableroTest);
//
//		assertEquals(batallon.getSoldado1().getUbicacion(), new Ubicacion(4,3));
//		assertEquals(batallon.getSoldado2().getUbicacion(), new Ubicacion(3,3));
//		assertEquals(batallon.getSoldado3().getUbicacion(), new Ubicacion(2,3));
//
//	}

	@Test
	public void test02TresSoldadosConObstaculoSeMuevenDos(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero unTablero = new Tablero(bandoJugador1, bandoJugador2);

		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),bandoJugador1);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1);
		Jinete jinete = new Jinete(new Ubicacion(1,2),bandoJugador1);
		//falta assert
	}

	@Test
	public void test03TresSoldadosConObstaculoDisuelveBatallon(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero unTablero = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Jinete jinete = new Jinete(new Ubicacion(1,2));

		//falta assert
	}

	@Test
	public void test04CuatroSoldadosContiguosMuevenTres(){
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Soldado soldado4 = new Soldado(new Ubicacion(5,2));
		//falta assert
	};


	@Test
	public void test05SoldadoAliadoAtacaJineteEnemigoCercano(){
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tablero = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion ubicacionSoldado = new Ubicacion(10,1);
		Soldado soldadoAliado = new Soldado(ubicacionSoldado,bandoJugador1);
		Ubicacion ubicacionJinete = new Ubicacion(11,1);
		Jinete jineteEnemigo = new Jinete(ubicacionJinete,bandoJugador2);
		tablero.ubicarEnCelda(jineteEnemigo,ubicacionJinete);
		tablero.ubicarEnCelda(soldadoAliado, ubicacionSoldado);
		int vidaTrasAtaque = jineteEnemigo.getVida() - soldadoAliado.getAtaqueCercano().getValorComportamiento();
		soldadoAliado.atacar(jineteEnemigo);
		assertEquals(vidaTrasAtaque,jineteEnemigo.getVida());
	};

	@Test (expected = FueraDeRangoParaEjecutarComportamientoException.class)
	public void test06SeArrojaExceptionCuandoSeQuiereAtacarAUnEnemigoLejano(){
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tablero = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion ubicacionSoldado = new Ubicacion(10,1);
		Soldado soldadoAliado = new Soldado(ubicacionSoldado,bandoJugador1);
		Ubicacion ubicacionJinete = new Ubicacion(11,10);
		Jinete jineteEnemigo = new Jinete(ubicacionJinete,bandoJugador2);
		tablero.ubicarEnCelda(jineteEnemigo,ubicacionJinete);
		tablero.ubicarEnCelda(soldadoAliado, ubicacionSoldado);
		soldadoAliado.atacar(jineteEnemigo);
	};

	@Test (expected = FueraDeRangoParaEjecutarComportamientoException.class)
	public void test07SeArrojaExceptionCuandoSeQuiereAtacarAUnEnemigoADistanciaMedia(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tablero = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion ubicacionSoldado = new Ubicacion(10,1);
		Soldado soldadoAliado = new Soldado(ubicacionSoldado,bandoJugador1);
		Ubicacion ubicacionJinete = new Ubicacion(11,3);
		Jinete jineteEnemigo = new Jinete(ubicacionJinete,bandoJugador2);
		tablero.ubicarEnCelda(jineteEnemigo,ubicacionJinete);
		tablero.ubicarEnCelda(soldadoAliado, ubicacionSoldado);
		soldadoAliado.atacar(jineteEnemigo);
	};

	@Test (expected = NoSePuedeAtacarUnAliadoException.class)
	public void test08SeArrojaExceptionCuandoSeQuiereAtacarUnAliado(){
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tablero = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion ubicacionSoldado = new Ubicacion(10,1);
		Soldado soldadoAliado = new Soldado(ubicacionSoldado,bandoJugador1);
		Ubicacion ubicacionJinete = new Ubicacion(10,2);
		Jinete jineteAliado = new Jinete(ubicacionJinete,bandoJugador1);
		tablero.ubicarEnCelda(jineteAliado,ubicacionJinete);
		tablero.ubicarEnCelda(soldadoAliado, ubicacionSoldado);
		soldadoAliado.atacar(jineteAliado);
	};

}
