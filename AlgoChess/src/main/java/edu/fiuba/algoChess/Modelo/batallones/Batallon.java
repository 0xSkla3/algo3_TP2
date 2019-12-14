package edu.fiuba.algoChess.Modelo.batallones;

import edu.fiuba.algoChess.Modelo.entidades.Movible;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeMoverUnBatallonNull;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.Modelo.rangos.Agrupable;
import edu.fiuba.algoChess.Modelo.rangos.Rango;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Batallon extends Movible {

	@Setter
	@Getter
	Pieza pieza1;

	@Setter
	@Getter
	Pieza pieza2;

	@Setter
	@Getter
	Pieza pieza3;

	public static Batallon darDeAltaBatallon(Pieza soldado){
		ArrayList<Pieza> soldadosBatallon;
		soldadosBatallon = BatallonUtil.armarPosibleBatallon(soldado);

		if (soldadosBatallon.size() > 1){
			BatallonUtil batallonUtil = new BatallonUtil();
			batallonUtil.setPieza1(soldadosBatallon.get(0));
			batallonUtil.setPieza2(soldadosBatallon.get(1));
			batallonUtil.setPieza3(soldadosBatallon.get(2));
			return batallonUtil;
		}

		return new BatallonNull();
	}

	public static Batallon batallonAsociadoONull(Pieza soldado1){
		Batallon batallon = new BatallonNull();
		batallon = darDeAltaBatallon(soldado1);
		return batallon;
	}

	public static boolean esBatallon(Pieza soldado1, Pieza soldado2, Pieza soldado3) {
		ArrayList<Pieza> soldadosBatallon = new ArrayList<>();

		soldadosBatallon = BatallonUtil.armarPosibleBatallon(soldado1);
		return (soldadosBatallon.size()>=2);
	}

	public Batallon moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){

		throw new NoSePuedeMoverUnBatallonNull("No se puede mover un batallon null");
	}

	public boolean equals(Batallon batallon){
		Set<Pieza> itemsBatallonActual = new HashSet<>();
		Set<Pieza>itemsBatallonAComparar = new HashSet<>();

		itemsBatallonActual.add(this.getPieza1());
		itemsBatallonActual.add(this.getPieza2());
		itemsBatallonActual.add(this.getPieza3());

		itemsBatallonAComparar.add(batallon.getPieza1());
		itemsBatallonAComparar.add(batallon.getPieza2());
		itemsBatallonAComparar.add(batallon.getPieza3());

		return itemsBatallonActual.equals(itemsBatallonAComparar);
	}

}
