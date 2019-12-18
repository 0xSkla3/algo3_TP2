package edu.fiuba.algoChess;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.batallones.BatallonNull;
import edu.fiuba.algoChess.modelo.batallones.BatallonUtil;
import edu.fiuba.algoChess.modelo.entidades.Pieza;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

public class TestHelper {

	public static void assertEqualsBatallonNull(Batallon batallon){
		BatallonNull batallonNull = new BatallonNull();
		assertTrue(equalsBatallon(batallonNull, batallon));
	}

	public static void assertEqualsBatallon(Batallon batallonEsperado, Batallon batallonAComparar){
		assertTrue(equalsBatallon(batallonEsperado, batallonAComparar));
	}

	public static boolean equalsBatallon(Batallon batallon1, Batallon batallon2){
		Set<Pieza> itemsBatallonActual = new HashSet<>();
		Set<Pieza>itemsBatallonAComparar = new HashSet<>();

		itemsBatallonActual.add(batallon1.getPieza1());
		itemsBatallonActual.add(batallon1.getPieza2());
		itemsBatallonActual.add(batallon1.getPieza3());

		itemsBatallonAComparar.add(batallon2.getPieza1());
		itemsBatallonAComparar.add(batallon2.getPieza2());

		itemsBatallonAComparar.add(batallon2.getPieza3());

		return itemsBatallonActual.equals(itemsBatallonAComparar);
	}

	public static boolean esBatallon(Pieza soldado1, Pieza soldado2, Pieza soldado3) {
		ArrayList<Pieza> soldadosBatallon = BatallonUtil.armarPosibleBatallon(soldado1);
		return (soldadosBatallon.size()>=2);
	}

}
