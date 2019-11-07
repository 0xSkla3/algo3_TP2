package edu.fiuba.algoChess;

import static org.junit.Assert.*;
import org.junit.Test;

public class MovibleTest {

/*	@Test
	public void testEntidadMoviblePuedeDesplazarse(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();
		Ubicacion fila1Columna1 = new Ubicacion(1,1);
		Ubicacion fila1Columna2 = new Ubicacion(2,1);
		Ubicacion fila2Columna2 = new Ubicacion(2,2);
		Ubicacion fila2Columna1 = new Ubicacion(1,2);
		Curandero unCurandero = new Curandero();

		unTablero.ubicarEnCelda(unCurandero,fila1Columna1);
		unCurandero.moverseALaDerecha(unTablero);
		assertEquals(fila1Columna2,unCurandero.getUbicacion());
		unCurandero.moverseArriba(unTablero);
		assertEquals(fila2Columna2,unCurandero.getUbicacion());
		unCurandero.moverseALaIzquierda(unTablero);
		assertEquals(fila2Columna1,unCurandero.getUbicacion());
		unCurandero.moverseAbajo(unTablero);
		assertEquals(fila1Columna1,unCurandero.getUbicacion());

	}
*/
	@Test
	public void testEntidadMovibleNoPuedeDesplazarseACasilleroOcupado(){

		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();
		Ubicacion fila2Columna2 = new Ubicacion(2,2);

		Ubicacion fila3Columna2 = new Ubicacion(2,3);
		Ubicacion fila1Columna2 = new Ubicacion(2,1);
		Ubicacion fila2Columna1 = new Ubicacion(1,2);
		Ubicacion fila2Columna3 = new Ubicacion(3,2);

		Curandero unCuranderoPorMover = new Curandero();
		Curandero unCuranderoObstaculoArriba = new Curandero();
		Curandero unCuranderoObstaculoAbajo = new Curandero();
		Curandero unCuranderoObstaculoIzquierda = new Curandero();
		Curandero unCuranderoObstaculoDerecha = new Curandero();

		unTablero.ubicarEnCelda(unCuranderoPorMover,fila2Columna2);
		unTablero.ubicarEnCelda(unCuranderoObstaculoArriba,fila3Columna2);
		unTablero.ubicarEnCelda(unCuranderoObstaculoAbajo,fila1Columna2);
		unTablero.ubicarEnCelda(unCuranderoObstaculoIzquierda,fila2Columna1);
		unTablero.ubicarEnCelda(unCuranderoObstaculoDerecha,fila2Columna3);

		unCuranderoPorMover.moverseALaDerecha(unTablero);
		assertEquals(fila2Columna2,unCuranderoPorMover.getUbicacion());
		unCuranderoPorMover.moverseArriba(unTablero);
		assertEquals(fila2Columna2,unCuranderoPorMover.getUbicacion());
		unCuranderoPorMover.moverseALaIzquierda(unTablero);
		assertEquals(fila2Columna2,unCuranderoPorMover.getUbicacion());
		unCuranderoPorMover.moverseAbajo(unTablero);
		assertEquals(fila2Columna2,unCuranderoPorMover.getUbicacion());

	}

	@Test
	public void testCuranderoCuraOtraFicha(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Curandero unCuranderoSanador = new Curandero();
		Curandero unCuranderoSanado = new Curandero();

		unCuranderoSanador.Sanar(unCuranderoSanado);

		assertEquals(unCuranderoSanador.getSanacion()+unCuranderoSanador.getVida(),unCuranderoSanado.getVida());

	}

	@Test
	public void testSoldadoAtacaOtraFicha(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Soldado UnSoldadoAtacante = new Soldado();
		Soldado unSoldadoAtacado = new Soldado();

		UnSoldadoAtacante.Atacar(unSoldadoAtacado);

		assertEquals(UnSoldadoAtacante.getVida()-UnSoldadoAtacante.getAtaqueCercano(),unSoldadoAtacado.getVida());

	}

	@Test
	public void testCatapultaAtacaOtraFicha(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Catapulta UnCatapultaAtacante = new Catapulta();
		Catapulta unCatapultaAtacado = new Catapulta();

		UnCatapultaAtacante.Atacar(unCatapultaAtacado);

		assertEquals(UnCatapultaAtacante.getVida()-UnCatapultaAtacante.getAtaqueLejano(),unCatapultaAtacado.getVida());

	}



}

