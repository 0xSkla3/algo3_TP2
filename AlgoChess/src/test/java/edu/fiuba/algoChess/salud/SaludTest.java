package edu.fiuba.algoChess.salud;
import edu.fiuba.algoChess.Modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.Modelo.salud.Salud;
import edu.fiuba.algoChess.Modelo.salud.SaludLlena;
import edu.fiuba.algoChess.Modelo.salud.SaludMedia;
import edu.fiuba.algoChess.Modelo.salud.SaludMuerto;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaludTest {

	@Test
	public void saludLlenaSeHiereCorrectamente(){
		final double saludValorTotal = 50;
		final double saludValorHerir = 5;
		final Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud.herir(saludValorHerir);

		assertEquals(unaSalud.getValorActual(), saludValorTotal- saludValorHerir, 0.0);
	}

	@Test
	public void saludLlenaHeridaDevuelveSaludMedia(){
		final double saludValorTotal = 50;
		final double saludValorHerir = 5;
		Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud = unaSalud.herir(saludValorHerir);

		assertTrue(unaSalud.igualA(new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerir)));
	}

	@Test
	public void saludMediaCuradaDevuelveSaludLlena(){
		final double saludValorTotal = 50;
		final double saludValorHerido = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerido);
		unaSalud = unaSalud.curar(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludLlena(saludValorTotal)));
	}

	@Test
	public void saludLlenaNoSeLlenaMas(){
		final double saludValorTotal = 50;
		final double saludValorCurar = 5;
		Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud = unaSalud.curar(saludValorCurar);

		assertTrue(unaSalud.igualA(new SaludLlena(50)));
	}

	@Test
	public void saludMediaMuere(){
		final double saludValorTotal = 50;
		final double saludValorHerido = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerido);
		unaSalud = unaSalud.herir(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludMuerto()));
	}

	@Test
	public void saludMediaSeLLena(){
		final double saludValorTotal = 50;
		final double saludValorHerir = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerir);
		unaSalud = unaSalud.curar(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludLlena(saludValorTotal)));
	}

	@Test
	public void saludMuertoNoSeLlena(){
		final double saludValorTotal = 50;
		final double saludValorCurar = 5;
		Salud unaSalud = new SaludMuerto();
		unaSalud = unaSalud.curar(saludValorCurar);

		assertTrue(unaSalud.igualA(new SaludMuerto()));
	}

}
