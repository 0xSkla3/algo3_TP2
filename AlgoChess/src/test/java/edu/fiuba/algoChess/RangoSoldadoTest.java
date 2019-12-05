package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.entidades.Curandero;
import edu.fiuba.algoChess.Modelo.entidades.Soldado;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.rangos.RangoSoldado;
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
		Soldado soldado = new Soldado();
		rango.getSoldadosEquipo().add(soldado);
		assertTrue(rango.getSoldadosEquipo().contains(soldado));
	}

}
