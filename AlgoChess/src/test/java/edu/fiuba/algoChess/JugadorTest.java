package edu.fiuba.algoChess;
import static org.junit.Assert.*;

import edu.fiuba.algoChess.Modelo.entidades.Catapulta;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.juego.Jugador;
import edu.fiuba.algoChess.Modelo.juego.JugadorStatus;
import org.junit.Test;

public class JugadorTest {

	@Test
	public void jugadorTestInicializaSinNombre(){

		Jugador jugadorPrueba = new Jugador();
		assertEquals( "",jugadorPrueba.nombre() );
	}

	@Test
	public void jugadorTestCreadoConNombre(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		assertEquals("Ruben",jugadorPrueba.nombre());
	}

	@Test
	public void jugadorTestInicializaInactivo(){

		Jugador jugadorPrueba = new Jugador();
		assertEquals(JugadorStatus.INACTIVO,jugadorPrueba.getStatus() );
	}

	@Test
	public void jugadorTestIniciaPuntaje(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		jugadorPrueba.sumarPuntaje(100);
		assertEquals(100, jugadorPrueba.puntaje());
	}

	@Test
	public void jugadorTestSumaPuntaje(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		jugadorPrueba.sumarPuntaje(100);
		jugadorPrueba.sumarPuntaje(100);
		jugadorPrueba.sumarPuntaje(100);
		assertEquals(300, jugadorPrueba.puntaje());
	}

	@Test
	public void jugadorTestActivaTurno(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		jugadorPrueba.activarTurno();
		assertEquals(JugadorStatus.EN_TURNO,jugadorPrueba.getStatus() );
	}

	@Test
	public void jugadorTestPoneEnEspera(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		jugadorPrueba.ponerEnEspera();
		assertEquals(JugadorStatus.EN_ESPERA,jugadorPrueba.getStatus() );
	}

	@Test
	public void jugadorTestHabilitaYDeshabilita(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		jugadorPrueba.activarTurno();
		jugadorPrueba.inhabilitar();
		assertEquals(JugadorStatus.INACTIVO,jugadorPrueba.getStatus() );
	}

	@Test
	public void jugadorTestSinPiezasPierde(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		jugadorPrueba.validarPerdedor();
		assertEquals(JugadorStatus.PERDEDOR,jugadorPrueba.getStatus() );
	}


	@Test
	public void jugadorTestSinCreditoNoPuedeAdquirirMasPiezas(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		Pieza unaPiezaCara = new Catapulta(20,20);

		jugadorPrueba.adquirirPieza(unaPiezaCara);
		assertEquals(JugadorStatus.INACTIVO,jugadorPrueba.getStatus() );

		jugadorPrueba.adquirirPieza(unaPiezaCara);
		assertEquals(JugadorStatus.POR_COMENZAR,jugadorPrueba.getStatus() );

	}



}
