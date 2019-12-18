package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.CeldaYaOcupadaException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntidadTest {
	private System system;


	@Test
	public void testEntidadMoviblePuedeDesplazarse(){
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero unTablero = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion fila1Columna1 = new Ubicacion(1,1);
		Ubicacion fila1Columna2 = new Ubicacion(2,1);
		Ubicacion fila2Columna2 = new Ubicacion(2,2);
		Ubicacion fila2Columna1 = new Ubicacion(1,2);
		Curandero unCurandero = new Curandero(fila1Columna1, bandoJugador1, unTablero);
		unCurandero.moverseALaDerecha(unTablero);
		assertEquals(fila1Columna2,unCurandero.getUbicacion());
		unCurandero.moverseArriba(unTablero);
		assertEquals(fila2Columna2,unCurandero.getUbicacion());
		unCurandero.moverseALaIzquierda(unTablero);
		assertEquals(fila2Columna1,unCurandero.getUbicacion());
		unCurandero.moverseAbajo(unTablero);
		assertEquals(fila1Columna1,unCurandero.getUbicacion());

	}

	@Test (expected = CeldaYaOcupadaException.class)
	public void testEntidadMovibleNoPuedeDesplazarseACasilleroOcupado(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero unTablero = new Tablero(bandoJugador1, bandoJugador2);
		Ubicacion fila2Columna2 = new Ubicacion(2,2);

		Ubicacion fila3Columna2 = new Ubicacion(2,3);
		Ubicacion fila1Columna2 = new Ubicacion(2,1);
		Ubicacion fila2Columna1 = new Ubicacion(1,2);
		Ubicacion fila2Columna3 = new Ubicacion(3,2);

		Curandero unCuranderoPorMover = new Curandero(fila2Columna2,bandoJugador1, unTablero);
		Curandero unCuranderoObstaculoArriba = new Curandero(fila3Columna2,bandoJugador1, unTablero);
		Curandero unCuranderoObstaculoAbajo = new Curandero(fila1Columna2,bandoJugador1, unTablero);
		Curandero unCuranderoObstaculoIzquierda = new Curandero(fila2Columna1,bandoJugador1, unTablero);
		Curandero unCuranderoObstaculoDerecha = new Curandero(fila2Columna3,bandoJugador1, unTablero);

		unCuranderoPorMover.moverseALaDerecha(unTablero);
		assertEquals(fila2Columna2,unCuranderoPorMover.getUbicacion());
		unCuranderoPorMover.moverseArriba(unTablero);
		assertEquals(fila2Columna2,unCuranderoPorMover.getUbicacion());
		unCuranderoPorMover.moverseALaIzquierda(unTablero);
		assertEquals(fila2Columna2,unCuranderoPorMover.getUbicacion());
		unCuranderoPorMover.moverseAbajo(unTablero);
		assertEquals(fila2Columna2,unCuranderoPorMover.getUbicacion());

	}

}

