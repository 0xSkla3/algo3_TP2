package edu.fiuba.algoChess.batallones;

import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.entorno.Tablero;
import edu.fiuba.algoChess.entorno.Ubicacion;
import edu.fiuba.algoChess.rangos.Agrupable;
import edu.fiuba.algoChess.rangos.Rango;
import edu.fiuba.algoChess.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Batallon implements Batalloneable {
	@Override
	public Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

	@Override
	public Collection<Pieza> desagrupar(Agrupable grupo) {
		return null;
	}

	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		return null;
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {

	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		return null;
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {
	}

	@Override
	public Batalloneable crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return null;
	}

	@Override
	public void moverseALaDerecha(Tablero campoDeBatalla) {

	}

	@Override
	public void moverseALaIzquierda(Tablero campoDeBatalla) {

	}

	@Override
	public void moverseArriba(Tablero campoDeBatalla) {

	}

	@Override
	public void moverseAbajo(Tablero campoDeBatalla) {

	}

	@Override
	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {

	}

	public static Batalloneable darDeAltaBatallon(Pieza soldado){
		ArrayList<Pieza> soldadosBatallon;
		soldadosBatallon = armarPosibleBatallon(soldado);

		if (soldadosBatallon.size() > 1){
			BatallonUtil batallonUtil = new BatallonUtil();
			batallonUtil.setPieza1(soldadosBatallon.get(0));
			batallonUtil.setPieza2(soldadosBatallon.get(1));
			batallonUtil.setPieza3(soldadosBatallon.get(2));
			return batallonUtil;
		}

		return new BatallonNull();
	}

	private static ArrayList<Pieza> armarPosibleBatallon(Pieza soldado) {
		return _armarPosibleBatallon(soldado,0);
	}

	private static ArrayList<Pieza> _armarPosibleBatallon(Pieza soldado, int control) {
		ArrayList<Pieza> soldadosBatallon = new ArrayList<>();
		int corte = 0;
		Pieza soldado1 = soldado;
		soldadosBatallon = soldado1.getSoldadosContiguos();
		while (soldadosBatallon.size() != 0 && corte < 10) {
			if (soldadosBatallon.size() >= 2) {
				//Para que siempre entre el central, que es el que tiene por companieros a los demas
				//Esto es importante cuando hay mas de dos soldados contiguos.
				//AGREGADO DE LIONEL PARA CHEQUEAR BANDOS
				//aca va lo mio - lionel
				soldadosBatallon.add(0, soldado1);
				return soldadosBatallon;
			}
			if (soldadosBatallon.size() == 1 && control == 0) {
				return _armarPosibleBatallon(soldadosBatallon.get(0),1);
			}
			corte++; // por las dudas, luego testear sin el corte
		}
		return soldadosBatallon;
	}

	public static Batalloneable batallonAsociadoONull(Pieza soldado1){
		Batalloneable batallon = new BatallonNull();
		batallon = darDeAltaBatallon(soldado1);
		return batallon;
	}

	public static boolean esBatallon(Pieza soldado1, Pieza soldado2, Pieza soldado3) {
		ArrayList<Pieza> soldadosBatallon = new ArrayList<>();

		soldadosBatallon = armarPosibleBatallon(soldado1);
		return (soldadosBatallon.size()>=2);
	}

	public boolean equals(Batalloneable batallon){
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

	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){

		Ubicacion ubicacionVieja1 = getPieza1().getUbicacion();
		Ubicacion ubicacionVieja2 = getPieza2().getUbicacion();
		Ubicacion ubicacionVieja3 = getPieza3().getUbicacion();

		campoDeBatalla.eliminar(ubicacionVieja1);
		campoDeBatalla.eliminar(ubicacionVieja2);
		campoDeBatalla.eliminar(ubicacionVieja3);

		try {
			this.getPieza1().mover(campoDeBatalla, ubicacion1);
		}catch(NoSePuedeUbicarPorqueEstaOcupadoException ex) {
			campoDeBatalla.ubicarEnCelda(this.getPieza1(),ubicacionVieja1);
			return new BatallonNull();
		}
		try {
			this.getPieza2().mover(campoDeBatalla, ubicacion2);
		}catch(NoSePuedeUbicarPorqueEstaOcupadoException ex) {
			campoDeBatalla.ubicarEnCelda(this.getPieza2(),ubicacionVieja2);
			return new BatallonNull();
		}
		try {
			this.getPieza3().mover(campoDeBatalla, ubicacion3);
		}catch(NoSePuedeUbicarPorqueEstaOcupadoException ex) {
			campoDeBatalla.ubicarEnCelda(this.getPieza3(),ubicacionVieja3);
			return new BatallonNull();
		}

		return this;

	}
}
