package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Batallones.Batallon;
import edu.fiuba.algoChess.Batallones.BatallonUtil;
import edu.fiuba.algoChess.Batallones.Batalloneable;
import edu.fiuba.algoChess.Salud.Salud;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SoldadoTest {

	@Test
	public void test00SeVerificaBatallon(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);


		Soldado soldado1 = new Soldado(new Ubicacion(2,2), bandoJugador1, tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1, tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2), bandoJugador1, tableroTest);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		assertTrue(BatallonUtil.esBatallon(soldado1,soldado2,soldado3));
	}

	@Test
	public void test01TresSoldadosContiguosSeMuevenEnLaMismaDireccion(){


		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Soldado soldado1 = new Soldado(new Ubicacion(2,2),bandoJugador1, tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2),bandoJugador1, tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2),bandoJugador1, tableroTest);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Batalloneable batallon = BatallonUtil.batallonAsociadoONull(soldado1);
		batallon.moverBatallonArriba(tableroTest);
;
		assertEquals(batallon.getPieza3().getUbicacion(), new Ubicacion(2,3));
		assertEquals(batallon.getPieza1().getUbicacion(), new Ubicacion(3,3));
		assertEquals(batallon.getPieza2().getUbicacion(), new Ubicacion(4,3));

	}

	@Test
	public void test02TresSoldadosConObstaculoSeMuevenDos(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2), bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2), bandoJugador1,tableroTest);
		Jinete jinete = new Jinete(new Ubicacion(3,3));

		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		jinete.setBando(bandoJugador1);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Batalloneable batallon = BatallonUtil.batallonAsociadoONull(soldado1);
		batallon.moverBatallonArriba(tableroTest);

	}

	@Test
	public void test03TresSoldadosConObstaculoDisuelveBatallon(){

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

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);

		Batalloneable batallon = Batallon.batallonAsociadoONull(soldado1);
		Batalloneable batallonModificado = batallon.moverBatallonArriba(tableroTest);

		assertTrue(batallonModificado.equals(new BatallonNull()));

	}

	@Test
	public void test04CuatroSoldadosContiguosMuevenTres(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2), bandoJugador1,tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2), bandoJugador1,tableroTest);
		Soldado soldado4 = new Soldado(new Ubicacion(5,2), bandoJugador1,tableroTest);

		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		soldado4.setBando(bandoJugador1);

		soldado1.actualizaRango(tableroTest);
		soldado2.actualizaRango(tableroTest);
		soldado3.actualizaRango(tableroTest);
		soldado4.actualizaRango(tableroTest);

		Batalloneable batallon = BatallonUtil.batallonAsociadoONull(soldado1);
		batallon.moverBatallonArriba(tableroTest);

		assertEquals(batallon.getPieza1().getUbicacion(), new Ubicacion(3,3));
		assertEquals(batallon.getPieza2().getUbicacion(), new Ubicacion(4,3));
		assertEquals(batallon.getPieza3().getUbicacion(), new Ubicacion(2,3));
		assertEquals(soldado4.getUbicacion(), new Ubicacion(5,2));
	};

	@Test
	public void test05SoldadoAliadoAtacaJineteEnemigoCercano(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();

		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
		Soldado soldadoAliado = new Soldado(ubicacionSoldado,bandoJugador1);

		Ubicacion ubicacionJinete = new Ubicacion(1,2);
		Jinete jineteEnemigo = new Jinete(ubicacionJinete,bandoJugador2);

		DistanciaRelativa distanciaJineteASoldado = soldadoAliado.getDistanciaRelativa(jineteEnemigo);
		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
		Salud vidaTrasAtaque = jineteEnemigo.getVida();
		soldadoAliado.atacar(distanciaJineteASoldado,jineteEnemigo);
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

		BandoJugador1 bandoTest = new BandoJugador1();

		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
		Soldado soldadoAliado = new Soldado(ubicacionSoldado,bandoTest);

		Ubicacion ubicacionJinete = new Ubicacion(1,2);
		Jinete jineteAliado = new Jinete(ubicacionJinete,bandoTest);

		DistanciaRelativa distanciaJineteASoldado = soldadoAliado.getDistanciaRelativa(jineteAliado);
		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
		Salud vidaTrasAtaque = jineteAliado.getVida();
		soldadoAliado.atacar(distanciaJineteASoldado,jineteAliado);
		assertEquals(vidaTrasAtaque,jineteAliado.getVida());
	};

}
