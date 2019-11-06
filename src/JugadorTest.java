package test;

import static org.junit.Assert.*;

import edu.fiuba.algo3.tp2.Jugador;
import edu.fiuba.algo3.tp2.JugadorStatus;
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



}
