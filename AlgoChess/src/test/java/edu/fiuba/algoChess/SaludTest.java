package edu.fiuba.algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SaludTest {

	@Test
	void saludLlenaSeHiereCorrectamente(){
		final int saludValorTotal = 50;
		final int saludValorHerir = 5;
		final Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud.herir(saludValorHerir);

		assertEquals(unaSalud.valorActual, saludValorTotal- saludValorHerir);
	}

	@Test
	void saludLlenaHeridaDevuelveSaludMedia(){
		final int saludValorTotal = 50;
		final int saludValorHerir = 5;
		Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud = unaSalud.herir(saludValorHerir);

		assertTrue(unaSalud.igualA(new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerir)));
	}

	@Test
	void saludMediaCuradaDevuelveSaludLlena(){
		final int saludValorTotal = 50;
		final int saludValorHerido = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerido);
		unaSalud = unaSalud.curar(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludLlena(saludValorTotal)));
	}

	@Test
	void saludLlenaNoSeLlenaMas(){
		final int saludValorTotal = 50;
		final int saludValorCurar = 5;
		Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud = unaSalud.curar(saludValorCurar);

		assertTrue(unaSalud.igualA(new SaludLlena(50)));
	}

	@Test
	void saludMediaMuere(){
		final int saludValorTotal = 50;
		final int saludValorHerido = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerido);
		unaSalud = unaSalud.herir(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludMuerto()));
	}

	@Test
	void saludMediaSeLLena(){
		final int saludValorTotal = 50;
		final int saludValorHerir = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerir);
		unaSalud = unaSalud.curar(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludLlena(saludValorTotal)));
	}

	@Test
	void saludMuertoNoSeLlena(){
		final int saludValorTotal = 50;
		final int saludValorCurar = 5;
		Salud unaSalud = new SaludMuerto();
		unaSalud = unaSalud.curar(saludValorCurar);

		assertTrue(unaSalud.igualA(new SaludMuerto()));
	}

}
