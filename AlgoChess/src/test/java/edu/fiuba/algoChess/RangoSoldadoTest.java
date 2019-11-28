package edu.fiuba.algoChess;

import org.junit.Test;
import static org.junit.Assert.*;
/*
public class RangoSoldadoTest {

	@Test
	public void rangoActualizaSoldadosContiguosCorrectamente(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());
		RangoSoldado rango = new RangoSoldado();
		rango.actualizaRango(soldado2,tableroTest);

		assertTrue(rango.getSoldadosContiguos().contains(soldado1));
		assertTrue(rango.getSoldadosContiguos().contains(soldado3));

	}

	@Test
	public void rangoActualizaObstaculosContiguosCorrectamente(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Jinete jinete = new Jinete(new Ubicacion(3,3));
		soldado1.setBando(bandoJugador1);
		soldado2.setBando(bandoJugador1);
		soldado3.setBando(bandoJugador1);
		jinete.setBando(bandoJugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());
		tableroTest.ubicarEnCelda(jinete, jinete.getUbicacion());
		RangoSoldado rango = new RangoSoldado();
		rango.actualizaRango(soldado2,tableroTest);

		assertTrue(rango.getObstaculos().contains(jinete));

	}


}
*/