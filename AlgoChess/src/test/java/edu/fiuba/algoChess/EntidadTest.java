package edu.fiuba.algoChess;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntidadTest {
	private System system;


	@Test
	public void testEntidadMoviblePuedeDesplazarse(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero unTablero = new Tablero(bandoJugador1, bandoJugador2);
		//unTablero.inicializarTablero();
		Ubicacion fila1Columna1 = new Ubicacion(1,1);
		Ubicacion fila1Columna2 = new Ubicacion(2,1);
		Ubicacion fila2Columna2 = new Ubicacion(2,2);
		Ubicacion fila2Columna1 = new Ubicacion(1,2);
		Curandero unCurandero = new Curandero();
		unCurandero.setBando(new BandoJugador1());
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

	@Test
	public void testEntidadMovibleNoPuedeDesplazarseACasilleroOcupado(){

		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero unTablero = new Tablero(bandoJugador1, bandoJugador2);
		//unTablero.inicializarTablero();
		Ubicacion fila2Columna2 = new Ubicacion(2,2);

		Ubicacion fila3Columna2 = new Ubicacion(2,3);
		Ubicacion fila1Columna2 = new Ubicacion(2,1);
		Ubicacion fila2Columna1 = new Ubicacion(1,2);
		Ubicacion fila2Columna3 = new Ubicacion(3,2);

		Curandero unCuranderoPorMover = new Curandero();
		unCuranderoPorMover.setBando(new BandoJugador1());

		Curandero unCuranderoObstaculoArriba = new Curandero();
		unCuranderoObstaculoArriba.setBando(new BandoJugador1());

		Curandero unCuranderoObstaculoAbajo = new Curandero();
		unCuranderoObstaculoAbajo.setBando(new BandoJugador1());

		Curandero unCuranderoObstaculoIzquierda = new Curandero();
		unCuranderoObstaculoIzquierda.setBando(new BandoJugador1());

		Curandero unCuranderoObstaculoDerecha = new Curandero();
		unCuranderoObstaculoDerecha.setBando(new BandoJugador1());

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

	};


//
//	@Test
//	public void testSoldadoAtacaOtraPiezaCercana(){
//		Tablero unTablero = new Tablero();
//		unTablero.inicializarTablero();
//
//		Soldado unSoldadoAtacante = new Soldado();
//		Soldado soldadoAtacado = new Soldado();
//		int vidaSoldadoTrasAtaque = soldadoAtacado.getVida() - unSoldadoAtacante.getAtaqueCercano();
//
//		unSoldadoAtacante.atacar(soldadoAtacado);
//
//		assertEquals(vidaSoldadoTrasAtaque,soldadoAtacado.getVida());
//	};
//
//	@Test
//	public void testSoldadoAtacaPiezaLejanaYNoSeRestaVidaALaPiezaAtacada() {
//		Tablero unTablero = new Tablero();
//		unTablero.inicializarTablero();
//
//		Soldado unSoldadoAtacante = new Soldado();
//		Soldado soldadoAtacadoLejano = new Soldado();
//		int vidaSoldadoTrasAtaque = soldadoAtacadoLejano.getVida() - unSoldadoAtacante.getAtaqueLejano();
//
//		unSoldadoAtacante.atacar(soldadoAtacadoLejano);
//
//		assertEquals(vidaSoldadoTrasAtaque, soldadoAtacadoLejano.getVida());
//	};
//
//	@Test
//	public void testCatapultaAtacaPiezaLejana(){
//		Tablero unTablero = new Tablero();
//		unTablero.inicializarTablero();
//
//		Catapulta unaCatapultaAtacante = new Catapulta();
//		Catapulta unaCatapultaAtacada = new Catapulta();
//
//
//		int vidaTrasAtaque = unaCatapultaAtacada.getVida()-unaCatapultaAtacante.getAtaqueLejano();
//		unaCatapultaAtacante.atacar(unaCatapultaAtacada);
//		assertEquals(vidaTrasAtaque,unaCatapultaAtacada.getVida());
//
//	}

//	@Test
//	public void testCuranderoCuraSoldado(){
//		Jugador jugador1 = new Jugador();
//		Jugador jugador2 = new Jugador();
//		Tablero unTablero = new Tablero(jugador1, jugador2);
//		//unTablero.inicializarTablero();



//	@Test
//
//	public void testJineteAtacaSoldadoCercano(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
//		soldado.setUbicacion(ubicacionSoldado);
//		Jinete jinete = new Jinete();
//		Ubicacion ubicacionJinete = new Ubicacion(1,2);
//		jinete.setUbicacion(ubicacionJinete);
//		DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
//		//assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
//		int vidaTrasAtaque = soldado.getVida() - jinete.getAtaqueCercano();
//		jinete.ejecutarComportamiento(distanciaSoldadoAJinete,soldado);
//		assertEquals(vidaTrasAtaque,soldado.getVida());
//	};
//
//	@Test
//	public void testJineteAtacaSoldadoADistanciaMedia(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(4,2);
//		soldado.setUbicacion(ubicacionSoldado);
//		Jinete jinete = new Jinete();
//		Ubicacion ubicacionJinete = new Ubicacion(1,2);
//		jinete.setUbicacion(ubicacionJinete);
//		DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
//		//assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
//		int vidaTrasAtaque = soldado.getVida() - jinete.getAtaqueMedio();
//		jinete.ejecutarComportamiento(distanciaSoldadoAJinete,soldado);
//		assertEquals(vidaTrasAtaque,soldado.getVida());
//	};

//	@Test
//	public void testSoldadoAtacaOtraPiezaCercana(){
//		Jugador jugador1 = new Jugador();
//		Jugador jugador2 = new Jugador();
//		Tablero unTablero = new Tablero(jugador1, jugador2);
////		unTablero.inicializarTablero();
//
//		Soldado unSoldadoAtacante = new Soldado();
//		Soldado soldadoAtacado = new Soldado();
//		int vidaSoldadoTrasAtaque = soldadoAtacado.getVida() - unSoldadoAtacante.getAtaqueCercano();
//
//		unSoldadoAtacante.atacar(soldadoAtacado);
//
//		assertEquals(vidaSoldadoTrasAtaque,soldadoAtacado.getVida());
//	};
//
//	@Test
//	public void testSoldadoAtacaPiezaLejanaYNoSeRestaVidaALaPiezaAtacada() {
//		Jugador jugador1 = new Jugador();
//		Jugador jugador2 = new Jugador();
//		Tablero unTablero = new Tablero(jugador1, jugador2);
//	};

//	@Test
//	public void testJineteAtacaSoldadoLejanoYNoSeDescuentaVidaDelSoldado(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(10,10);
//		soldado.setUbicacion(ubicacionSoldado);
//		Jinete jinete = new Jinete();
//		Ubicacion ubicacionJinete = new Ubicacion(1,2);
//		jinete.setUbicacion(ubicacionJinete);
//		DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
//		//assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
//		int vidaTrasAtaque = soldado.getVida() - jinete.getAtaqueLejano();
//		jinete.ejecutarComportamiento(distanciaSoldadoAJinete,soldado);
//		assertEquals(vidaTrasAtaque,soldado.getVida());
//	};

//	@Test
//	public void testSoldadoAtacaJineteCercano(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
//		soldado.setUbicacion(ubicacionSoldado);
//		Jinete jinete = new Jinete();
//		Ubicacion ubicacionJinete = new Ubicacion(1,2);
//		jinete.setUbicacion(ubicacionJinete);
//		DistanciaRelativa distanciaJineteASoldado = soldado.getDistanciaRelativa(jinete);
//	//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
//		int vidaTrasAtaque = jinete.getVida() - soldado.getAtaqueCercano();
//		soldado.ejecutarComportamiento(distanciaJineteASoldado,jinete);
//		assertEquals(vidaTrasAtaque,jinete.getVida());
//	};
//
//	@Test
//	public void testSoldadoAtacaJineteLejanoYNoSeQuitaVidaAJineteAtacado(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
//		soldado.setUbicacion(ubicacionSoldado);
//		Jinete jinete = new Jinete();
//		Ubicacion ubicacionJinete = new Ubicacion(10,20);
//		jinete.setUbicacion(ubicacionJinete);
//		DistanciaRelativa distanciaJineteASoldado = soldado.getDistanciaRelativa(jinete);
//	//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
//		int vidaTrasAtaque = jinete.getVida() - soldado.getAtaqueLejano();
//		soldado.ejecutarComportamiento(distanciaJineteASoldado,jinete);
//		assertEquals(vidaTrasAtaque,jinete.getVida());
//	};

//	@Test
//	public void testCatapultaAtacaASoldadoCercanoYNoSeRestaVidaDelAtacado(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
//		soldado.setUbicacion(ubicacionSoldado);
//		Catapulta catapulta = new Catapulta();
//		Ubicacion ubicacionCatapulta = new Ubicacion(1,2);
//		catapulta.setUbicacion(ubicacionCatapulta);
//		DistanciaRelativa distanciaSoldadoACatapulta = catapulta.getDistanciaRelativa(soldado);
//		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
//		int vidaTrasAtaque = soldado.getVida() - catapulta.getAtaqueCercano();
//		catapulta.ejecutarComportamiento(distanciaSoldadoACatapulta,soldado);
//		assertEquals(vidaTrasAtaque,soldado.getVida());
//	};
//
////	public void testCatapultaAtacaPiezaLejana() {
////		Jugador jugador1 = new Jugador();
////		Jugador jugador2 = new Jugador();
////		Tablero unTablero = new Tablero(jugador1, jugador2);
////	}
//
//	@Test
//	public void testCatapultaAtacaASoldadoADistanciaMediaYRestaVida(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
//		soldado.setUbicacion(ubicacionSoldado);
//		Catapulta catapulta = new Catapulta();
//		Ubicacion ubicacionCatapulta = new Ubicacion(1,4);
//		catapulta.setUbicacion(ubicacionCatapulta);
//		DistanciaRelativa distanciaSoldadoACatapulta = catapulta.getDistanciaRelativa(soldado);
//		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
//		int vidaTrasAtaque = soldado.getVida() - catapulta.getAtaqueMedio();
//		catapulta.ejecutarComportamiento(distanciaSoldadoACatapulta,soldado);
//		assertEquals(vidaTrasAtaque,soldado.getVida());
//	};

//	@Test
//	public void testCuranderoPuedeCurarSoldadoCercano(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
//		soldado.setUbicacion(ubicacionSoldado);
//		Curandero curandero = new Curandero();
//		Ubicacion ubicacionCurandero = new Ubicacion(1,2);
//		curandero.setUbicacion(ubicacionCurandero);
//		DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldado);
//		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
//		int vidaTrasCuracion = soldado.getVida() + curandero.getSanacion();
//		curandero.ejecutarComportamiento(distanciaSoldadoACurandero,soldado);
//		assertEquals(vidaTrasCuracion,soldado.getVida());
//	};
//
//	@Test
//	public void testCuranderoNoPuedeCurarSoldadoLejano(){
//		Soldado soldado = new Soldado();
//		Ubicacion ubicacionSoldado = new Ubicacion(1,10);
//		soldado.setUbicacion(ubicacionSoldado);
//		Curandero curandero = new Curandero();
//		Ubicacion ubicacionCurandero = new Ubicacion(1,2);
//		curandero.setUbicacion(ubicacionCurandero);
//		DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldado);
//		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
//		int vidaSoldadoSinSerAlcanzadoPorCuracion = soldado.getVida();
//		curandero.ejecutarComportamiento(distanciaSoldadoACurandero,soldado);
//		assertEquals(vidaSoldadoSinSerAlcanzadoPorCuracion,soldado.getVida());
//	};
//
//	@Test
//	public void testCuranderoNoPuedeCurarCatapultaCercana(){
//		Catapulta catapulta = new Catapulta();
//		Ubicacion ubicacionCatapulta = new Ubicacion(1,1);
//		catapulta.setUbicacion(ubicacionCatapulta);
//		Curandero curandero = new Curandero();
//		Ubicacion ubicacionCurandero = new Ubicacion(1,2);
//		curandero.setUbicacion(ubicacionCurandero);
//		DistanciaRelativa distanciaCatapultaACurandero = curandero.getDistanciaRelativa(catapulta);
//		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
//		int vidaCatapultaSinSerAlcanzadoPorCuracion = catapulta.getVida();
//		curandero.ejecutarComportamiento(distanciaCatapultaACurandero,catapulta);
//		assertEquals(vidaCatapultaSinSerAlcanzadoPorCuracion,catapulta.getVida());
//	};

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

