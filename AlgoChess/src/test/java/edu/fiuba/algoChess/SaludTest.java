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
	void saludLlenaNoSeLlenaMas(){
		final int saludValorTotal = 50;
		final int saludValorCurar = 5;
		final Salud unaSalud = new SaludLlena(saludValorTotal);
		unaSalud.curar(saludValorCurar);

		assertEquals(unaSalud.valorActual, saludValorTotal);
	}

	@Test
	void saludMediaMuere(){
		final int saludValorTotal = 50;
		final int saludValorHerir = 5;
		Salud unaSalud = new SaludMedia(saludValorTotal,saludValorTotal-saludValorHerir);
		unaSalud = unaSalud.herir(saludValorTotal);

		assertTrue(unaSalud.igualA(new SaludMuerto()));
	}






}
