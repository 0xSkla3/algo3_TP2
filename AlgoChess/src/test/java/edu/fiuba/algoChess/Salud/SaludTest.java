package edu.fiuba.algoChess.Salud;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaludTest {

	@Test
	public void saludLlenaSeHiereCorrectamente(){
		final int saludValorTotal = 50;
		final int saludValorHerir = 5;
		final Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud.herir(saludValorHerir);

		assertEquals(unaSalud.getValorActual(), saludValorTotal- saludValorHerir);
	}

	@Test
	public void saludLlenaHeridaDevuelveSaludMedia(){
		final int saludValorTotal = 50;
		final int saludValorHerir = 5;
		Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud = unaSalud.herir(saludValorHerir);

		assertTrue(unaSalud.igualA(new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerir)));
	}

	@Test
	public void saludMediaCuradaDevuelveSaludLlena(){
		final int saludValorTotal = 50;
		final int saludValorHerido = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerido);
		unaSalud = unaSalud.curar(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludLlena(saludValorTotal)));
	}

	@Test
	public void saludLlenaNoSeLlenaMas(){
		final int saludValorTotal = 50;
		final int saludValorCurar = 5;
		Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud = unaSalud.curar(saludValorCurar);

		assertTrue(unaSalud.igualA(new SaludLlena(50)));
	}

	@Test
	public void saludMediaMuere(){
		final int saludValorTotal = 50;
		final int saludValorHerido = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerido);
		unaSalud = unaSalud.herir(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludMuerto()));
	}

	@Test
	public void saludMediaSeLLena(){
		final int saludValorTotal = 50;
		final int saludValorHerir = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerir);
		unaSalud = unaSalud.curar(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludLlena(saludValorTotal)));
	}

	@Test
	public void saludMuertoNoSeLlena(){
		final int saludValorTotal = 50;
		final int saludValorCurar = 5;
		Salud unaSalud = new SaludMuerto();
		unaSalud = unaSalud.curar(saludValorCurar);

		assertTrue(unaSalud.igualA(new SaludMuerto()));
	}

}
