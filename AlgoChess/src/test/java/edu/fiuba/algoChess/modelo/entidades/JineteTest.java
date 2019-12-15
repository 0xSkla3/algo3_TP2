package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.modelo.entidades.Jinete;
import edu.fiuba.algoChess.modelo.entidades.Soldado;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeAtacarUnAliadoException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class JineteTest {

	@Test
	public void test08JineteAtacaAEnemigoCercanoConAtaqueCercanoCuandoHayUnSoldadoAliadoCerca(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(11,1);
		Soldado soldadoEnemigo = new Soldado(ubicacionSoldadoEnemigo,bandoJugador2, tableroTest);

		Ubicacion ubicacionSoldadoAliado = new Ubicacion(10,2);
		Soldado soldadoAliado = new Soldado(ubicacionSoldadoAliado,bandoJugador1, tableroTest);

		Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
		Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1, tableroTest);

		double vidaTrasAtaque = soldadoEnemigo.getVida().getValorActual() - (jineteAliado.getDanioCercano());
		jineteAliado.atacar(soldadoEnemigo);
		assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida().getValorActual());

	}

	@Test
	public void test09JineteAtacaConAtaqueMedioAEnemigoADistanciaMedia(){
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(11,5);
		Soldado soldadoEnemigo = new Soldado(ubicacionSoldadoEnemigo,bandoJugador2, tableroTest);

		Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
		Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1, tableroTest);

		double vidaTrasAtaque = soldadoEnemigo.getVida().getValorActual() - jineteAliado.getDanioMedio();

		jineteAliado.atacar(soldadoEnemigo);
		assertEquals(vidaTrasAtaque, soldadoEnemigo.getVida().getValorActual());

	}

	@Test
	public void test10JineteAtacaConAtaqueCercanoAEnemigoCercanoCuandoNoHayUnSoldadoAliadoCerca(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

		Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(11,1);
		Soldado soldadoEnemigo = new Soldado(ubicacionSoldadoEnemigo,bandoJugador2,tableroTest);

		Ubicacion ubicacionSoldadoAliado = new Ubicacion(5,2);
		Soldado soldadoAliado = new Soldado(ubicacionSoldadoAliado,bandoJugador1,tableroTest);

		Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
		Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1,tableroTest);

		double vidaTrasAtaque = soldadoEnemigo.getVida().getValorActual() - jineteAliado.getDanioCercano();

		jineteAliado.atacar(soldadoEnemigo);
		assertEquals(vidaTrasAtaque, soldadoEnemigo.getVida().getValorActual());
	};

	@Test (expected = FueraDeRangoParaEjecutarComportamientoException.class)
	public void SeArrojaExceptionCuandoSeQuiereAtacarAUnEnemigoLejano(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(15,7);
		Soldado soldadoEnemigo = new Soldado(ubicacionSoldadoEnemigo,bandoJugador2,tableroTest);
		Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
		Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1,tableroTest);
		jineteAliado.atacar(soldadoEnemigo);
	}

	@Test (expected = NoSePuedeAtacarUnAliadoException.class)
	public void SeArrojaExceptionCuandoSeQuiereAtacarUnAliado(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion ubicacionSoldadoAliado = new Ubicacion(10,2);
		Soldado soldadoAliado = new Soldado(ubicacionSoldadoAliado,bandoJugador1,tableroTest);
		Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
		Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1,tableroTest);
		jineteAliado.atacar(soldadoAliado);
	}

}




