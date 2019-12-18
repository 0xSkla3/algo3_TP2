package edu.fiuba.algoChess.modelo.rangos;

import edu.fiuba.algoChess.modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.modelo.entidades.Curandero;
import edu.fiuba.algoChess.modelo.entidades.Soldado;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.rangos.RangoSoldado;
import org.junit.Test;
import static org.junit.Assert.*;

public class RangoSoldadoTest {

	@Test
	public void rangoActualizaSoldadosContiguosCorrectamente(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2), bandoJugador1, tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1, tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2), bandoJugador1, tableroTest);
		soldado2.getRango().actualizaRangoInmediato(soldado2,tableroTest);
		soldado2.getRango().actualizaRangoSoldado(soldado2, tableroTest);
		assertTrue(soldado2.getRango().getSoldadosEquipo().contains(soldado1));
		assertTrue(soldado2.getRango().getSoldadosEquipo().contains(soldado3));

	}

	@Test
	public void rangoActualizaObstaculosContiguosCorrectamente(){

		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2), bandoJugador1, tableroTest);
		Soldado soldado2 = new Soldado(new Ubicacion(3,2), bandoJugador1,tableroTest);
		Soldado soldado3 = new Soldado(new Ubicacion(4,2), bandoJugador1,tableroTest);
		Curandero curandero = new Curandero(new Ubicacion(3,3), bandoJugador1, tableroTest);
		RangoSoldado rango = new RangoSoldado(soldado2,tableroTest);
		soldado2.getRango().actualizaPiezasEnRango(soldado2);
		soldado2.actualizaRango(tableroTest);
		rango.actualizaObstaculosInmediatos(soldado2);

		assertTrue(rango.getObstaculos().contains(curandero));
	}

	@Test
	public void RangoSoldadoDevuelvePiezasEnEquipo() {
		RangoSoldado rango = new RangoSoldado();
		BandoJugador1 bandoJugador1 = new BandoJugador1();
		BandoJugador2 bandoJugador2 = new BandoJugador2();
		Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
		Soldado soldado = new Soldado(new Ubicacion(2,2), bandoJugador1, tableroTest);
		rango.getSoldadosEquipo().add(soldado);
		assertTrue(rango.getSoldadosEquipo().contains(soldado));
	}

}
