package edu.fiuba.algoChess;

import org.junit.Test;

public class SoldadoTest {

	@Test
	public void testVerificaBatallon(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		soldado1.setJugador(jugador1);
		soldado2.setJugador(jugador1);
		soldado3.setJugador(jugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		assert(!soldado1.verificaBatallon(tableroTest).equals(null));

	}

	@Test
	public void tresSoldadosContiguosSeMuevenEnLaMismaDireccion(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));


	}

	@Test
	public void tresSoldadosConObstaculoSeMuevenDos(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Jinete jinete = new Jinete(new Ubicacion(1,2));


	}

	@Test
	public void tresSoldadosConObstaculoDisuelveBatallon(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Jinete jinete = new Jinete(new Ubicacion(1,2));
	}

	@Test
	public void CuatroSoldadosContiguosMuevenTres(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Soldado soldado4 = new Soldado(new Ubicacion(5,2));

	}

}
