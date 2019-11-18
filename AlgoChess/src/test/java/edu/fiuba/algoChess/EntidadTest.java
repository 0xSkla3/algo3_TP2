package edu.fiuba.algoChess;

import static org.junit.Assert.*;
import org.junit.Test;

public class EntidadTest {

	@Test
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
		//unCurandero.moverseAbajo(unTablero);
		//assertEquals(fila1Columna1,unCurandero.getUbicacion());

	}

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
	public void testCuranderoCuraSoldado(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Curandero unCuranderoSanador = new Curandero();
		Soldado soldado = new Soldado();
		int vidaSoldadoTrasCuracion = soldado.getVida() + unCuranderoSanador.getSanacion();
		unCuranderoSanador.Sanar(soldado);

		assertEquals(vidaSoldadoTrasCuracion,soldado.getVida());

	}

	@Test
	public void testSoldadoAtacaOtraPiezaCercana(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Soldado unSoldadoAtacante = new Soldado();
		Soldado soldadoAtacado = new Soldado();
		int vidaSoldadoTrasAtaque = soldadoAtacado.getVida() - unSoldadoAtacante.getAtaqueCercano();

		unSoldadoAtacante.atacar(soldadoAtacado);

		assertEquals(vidaSoldadoTrasAtaque,soldadoAtacado.getVida());
	};

	@Test
	public void testSoldadoAtacaPiezaLejanaYNoSeRestaVidaALaPiezaAtacada() {
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Soldado unSoldadoAtacante = new Soldado();
		Soldado soldadoAtacadoLejano = new Soldado();
		int vidaSoldadoTrasAtaque = soldadoAtacadoLejano.getVida() - unSoldadoAtacante.getAtaqueLejano();

		unSoldadoAtacante.atacar(soldadoAtacadoLejano);

		assertEquals(vidaSoldadoTrasAtaque, soldadoAtacadoLejano.getVida());
	};

	@Test
	public void testCatapultaAtacaPiezaLejana(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Catapulta unaCatapultaAtacante = new Catapulta();
		Catapulta unaCatapultaAtacada = new Catapulta();


		int vidaTrasAtaque = unaCatapultaAtacada.getVida()-unaCatapultaAtacante.getAtaqueLejano();
		unaCatapultaAtacante.atacar(unaCatapultaAtacada);
		assertEquals(vidaTrasAtaque,unaCatapultaAtacada.getVida());

	}

	//@Test
	//public void testCatapultaAtacaPiezaCercana(){
	//	Tablero unTablero = new Tablero();
	//	unTablero.inicializarTablero();

	//	Catapulta unaCatapultaAtacante = new Catapulta();
	//	Soldado soldadoAtacadoCercano = new Soldado();


	//	int vidaTrasAtaque = soldadoAtacadoCercano.getVida()-unaCatapultaAtacante.getAtaqueCercano();
	//	unaCatapultaAtacante.atacar(soldadoAtacadoCercano);
	//	assertEquals(vidaTrasAtaque,soldadoAtacadoCercano.getVida());

	//}

/*
	@Test
	public void testJineteAtacaPiezaCercana(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Jinete unJineteAtacante = new Jinete();
		Soldado soldadoAtacado = new Soldado();

		int vidaSoldadoTrasAtaque = soldadoAtacado.getVida() - unJineteAtacante.getAtaqueCercano();

		unJineteAtacante.atacarCercano(soldadoAtacado);

		assertEquals(vidaSoldadoTrasAtaque,soldadoAtacado.getVida());

	}

	@Test
	public void testJineteAtacaPiezaLejana(){
		Tablero unTablero = new Tablero();
		unTablero.inicializarTablero();

		Jinete unJineteAtacante = new Jinete();
		Soldado soldadoAtacado = new Soldado();

		int vidaSoldadoTrasAtaque = soldadoAtacado.getVida() - unJineteAtacante.getAtaqueLejano();

		unJineteAtacante.atacarLejano(soldadoAtacado);

		assertEquals(vidaSoldadoTrasAtaque,soldadoAtacado.getVida());

	}*/


}

