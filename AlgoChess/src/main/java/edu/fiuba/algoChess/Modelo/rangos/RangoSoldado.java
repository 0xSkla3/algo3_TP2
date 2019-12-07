package edu.fiuba.algoChess.Modelo.rangos;

import java.util.ArrayList;

import edu.fiuba.algoChess.Modelo.batallones.BatallonUtil;
import edu.fiuba.algoChess.Modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.Modelo.batallones.BatallonNull;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import lombok.Getter;
import lombok.Setter;

public class RangoSoldado extends RangoInmediato implements Rango {

	@Getter
	ArrayList<Pieza> soldadosEquipo;

	@Getter
	@Setter
	ArrayList<Pieza> obstaculos;

	public void setSoldadosEquipo(ArrayList<Pieza> soldadosEquipo) {
		this.soldadosEquipo = soldadosEquipo;
	}

	public RangoSoldado(){
		this.soldadosEquipo = new ArrayList<>();
		this.obstaculos = new ArrayList<>();
	}

	public RangoSoldado(Pieza soldado, Tablero tableroActual){
		super(soldado,tableroActual);
		this.soldadosEquipo = new ArrayList<>();
		this.obstaculos = new ArrayList<>();
		this.actualizaSoldadosCercanos(soldado);
		this.actualizaObstaculosInmediatos(soldado);
	}

	private void actualizaSoldadosCercanos(Pieza piezaCentral){

		this.actualizaPiezasEnRango(piezaCentral);
		ArrayList<Pieza> piezas = piezaCentral.getRango().getPiezasEnRango();
		ArrayList<Pieza> nuevosSoldadosCercanos = new ArrayList<>();
		if (piezas.size() == 0) return;

//		ROCHI'S VERSION
//		this.getArriba().getPiezaActual().aniadirSoldadoAlStack(nuevosSoldadosCercanos);
//		this.getAbajo().getPiezaActual().aniadirSoldadoAlStack(nuevosSoldadosCercanos);
//		this.getIzquierda().getPiezaActual().aniadirSoldadoAlStack(nuevosSoldadosCercanos);
//		this.getDerecha().getPiezaActual().aniadirSoldadoAlStack(nuevosSoldadosCercanos);
//
//		this.setSoldadosEquipo(nuevosSoldadosCercanos);

//		LIO'S VERSION
		//Pieza soldadoArriba = this.getArriba().getPiezaActual();
		this.getArriba().getPiezaActual().aniadirSoldadoAlStack(nuevosSoldadosCercanos, piezaCentral);
		this.getAbajo().getPiezaActual().aniadirSoldadoAlStack(nuevosSoldadosCercanos, piezaCentral);
		this.getIzquierda().getPiezaActual().aniadirSoldadoAlStack(nuevosSoldadosCercanos, piezaCentral);
		this.getDerecha().getPiezaActual().aniadirSoldadoAlStack(nuevosSoldadosCercanos, piezaCentral);
		this.setSoldadosEquipo(nuevosSoldadosCercanos);
	}

	public void actualizaObstaculosInmediatos(Pieza piezaCentral){

		this.actualizaPiezasEnRango(piezaCentral);
		ArrayList<Pieza> piezas = piezaCentral.getRango().getPiezasEnRango();
		ArrayList<Pieza> nuevosObstaculosCercanos = new ArrayList<>();
		if (piezas.size() == 0) return;

		this.getArriba().getPiezaActual().aniadirTodoMenosSoldadoAlStack(nuevosObstaculosCercanos);
		this.getAbajo().getPiezaActual().aniadirTodoMenosSoldadoAlStack(nuevosObstaculosCercanos);
		this.getIzquierda().getPiezaActual().aniadirTodoMenosSoldadoAlStack(nuevosObstaculosCercanos);
		this.getDerecha().getPiezaActual().aniadirTodoMenosSoldadoAlStack(nuevosObstaculosCercanos);

		this.setObstaculos(nuevosObstaculosCercanos);
	}

	@Override
	public void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral,Tablero tablero) {
		super.actualizaRangoInmediato(piezaCentral,tablero);
		this.actualizaSoldadosCercanos(piezaCentral);
		this.actualizaObstaculosInmediatos(piezaCentral);
	}

	public Batalloneable darDeAltaBatallon(Batalloneable batallon){
		ArrayList<Pieza> soldadosBatallon = new ArrayList<>();
		this.getPiezasEnRango().forEach(pieza -> {if(pieza.soldadosInmediatosSePuedenUnir()){
			soldadosBatallon.add(this.getPiezasEnRango().get(1));
			soldadosBatallon.add(this.getPiezasEnRango().get(2));
			soldadosBatallon.add(this.getPiezasEnRango().get(3));
		}});

		if (soldadosBatallon.size() >= 1){
			return new BatallonUtil(soldadosBatallon.get(1), soldadosBatallon.get(2), soldadosBatallon.get(3));
		}
		return new BatallonNull();
	}

}
