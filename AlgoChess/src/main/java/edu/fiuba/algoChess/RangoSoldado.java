package edu.fiuba.algoChess;

import java.util.ArrayList;
import java.util.Arrays;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class RangoSoldado extends RangoInmediate implements Rango {

	@Getter
	@Setter
	ArrayList<Pieza> soldadosContiguos;

	@Getter
	@Setter
	ArrayList<Pieza> obstaculos;

	public void actualizaRango(Soldado soldado, Tablero tablero){
		super.actualizaRango(soldado,tablero);
		ArrayList<Pieza> piezasInmediatas = new ArrayList<>();
		this.getPiezasEnEntorno().forEach(pieza -> pieza.unirAInmediato(piezasInmediatas));

		this.setSoldadosContiguos( piezasInmediatas);
	}

	public void actualizaSoldadosCercanos(Soldado soldado){

		setSoldadosContiguos(new ArrayList<>());
		if(arriba.getContenido().isPresent() && arriba.getContenido().get().getClass().equals(Soldado.class)){
			getSoldadosContiguos().add(arriba.getContenido().get());
		}
		if(abajo.getContenido().isPresent() && abajo.getContenido().get().getClass().equals(Soldado.class)){
			getSoldadosContiguos().add(abajo.getContenido().get());
		}
		if(izquierda.getContenido().isPresent() && izquierda.getContenido().get().getClass().equals(Soldado.class)){
			getSoldadosContiguos().add(izquierda.getContenido().get());
		}
		if(derecha.getContenido().isPresent() && derecha.getContenido().get().getClass().equals(Soldado.class)){
			getSoldadosContiguos().add(derecha.getContenido().get());
		}

	}

	public void actualizaObstaculosInmediatos(Pieza piezaCentral){

		setObstaculos(new ArrayList<>());

		if(arriba.getContenido().isPresent() && !arriba.getContenido().get().getClass().equals(Soldado.class)){
			getObstaculos().add(arriba.getContenido().get());
		}
		if(abajo.getContenido().isPresent() && abajo.getContenido().get().getClass().equals(Soldado.class)){
			getObstaculos().add(abajo.getContenido().get());
		}
		if(izquierda.getContenido().isPresent() && izquierda.getContenido().get().getClass().equals(Soldado.class)){
			getObstaculos().add(izquierda.getContenido().get());
		}
		if(derecha.getContenido().isPresent() && derecha.getContenido().get().getClass().equals(Soldado.class)){
			getObstaculos().add(derecha.getContenido().get());
		}

	}
}
