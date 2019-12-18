package edu.fiuba.algoChess.modelo.rangos;

import java.util.ArrayList;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.batallones.BatallonNull;
import edu.fiuba.algoChess.modelo.batallones.BatallonUtil;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import lombok.Getter;
import lombok.Setter;

public class RangoSoldado extends RangoInmediato {

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

	private ArrayList<Pieza> actualizaSoldadosCercanos(Pieza piezaCentral){

		this.actualizaPiezasEnRango(piezaCentral);
		ArrayList<Pieza> piezas = piezaCentral.getRango().getPiezasEnRango();
		ArrayList<Pieza> nuevosSoldadosCercanos = new ArrayList<>();

		try{piezas.size();}catch(NullPointerException e){return new ArrayList<>();}

		this.getArriba().getPiezaActual().aniadirSoldadoAliadoStack(nuevosSoldadosCercanos, piezaCentral);
		this.getAbajo().getPiezaActual().aniadirSoldadoAliadoStack(nuevosSoldadosCercanos, piezaCentral);
		this.getIzquierda().getPiezaActual().aniadirSoldadoAliadoStack(nuevosSoldadosCercanos, piezaCentral);
		this.getDerecha().getPiezaActual().aniadirSoldadoAliadoStack(nuevosSoldadosCercanos, piezaCentral);

		this.setSoldadosEquipo(nuevosSoldadosCercanos);

		return nuevosSoldadosCercanos;
	}

	public void actualizaObstaculosInmediatos(Pieza piezaCentral){

		this.actualizaPiezasEnRango(piezaCentral);
		ArrayList<Pieza> piezas = piezaCentral.getRango().getPiezasEnRango();
		ArrayList<Pieza> nuevosObstaculosCercanos = new ArrayList<>();
		try{piezas.size();}catch(NullPointerException e){return;}

		this.getArriba().getPiezaActual().aniadirTodoMenosSoldadoAlStack(nuevosObstaculosCercanos);
		this.getAbajo().getPiezaActual().aniadirTodoMenosSoldadoAlStack(nuevosObstaculosCercanos);
		this.getIzquierda().getPiezaActual().aniadirTodoMenosSoldadoAlStack(nuevosObstaculosCercanos);
		this.getDerecha().getPiezaActual().aniadirTodoMenosSoldadoAlStack(nuevosObstaculosCercanos);

		this.setObstaculos(nuevosObstaculosCercanos);
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral,Tablero tablero) {
		super.actualizaRangoInmediato(piezaCentral,tablero);
		this.actualizaSoldadosCercanos(piezaCentral);
		this.actualizaObstaculosInmediatos(piezaCentral);
	}

	@Override
	public Batallon darDeAltaBatallon(){
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
