package edu.fiuba.algoChess;

import java.util.ArrayList;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class RangoSoldado {

	@Getter
	@Setter
	Celda arriba;

	@Getter
	@Setter
	Celda abajo;

	@Getter
	@Setter
	Celda izquierda;

	@Getter
	@Setter
	Celda derecha;

	@Getter
	@Setter
	ArrayList<Soldado> soldadosContiguos;

	@Getter
	@Setter
	ArrayList<Pieza> obstaculos;

	public RangoSoldado(Soldado soldado, Tablero tablero){
		RangoSoldado rango = new RangoSoldado();
		rango.actualizaRango(soldado,tablero);
	}

	public void actualizaRango(Soldado soldado, Tablero tablero){
		setArriba(tablero.getCelda(soldado.getUbicacion().getUbicacionArriba()));
		setAbajo(tablero.getCelda(soldado.getUbicacion().getUbicacionAbajo()));
		setDerecha(tablero.getCelda(soldado.getUbicacion().getUbicacionIzquierda()));
		setIzquierda(tablero.getCelda(soldado.getUbicacion().getUbicacionDerecha()));

		actualizaSoldadosCercanos(soldado);
		actualizaObstaculosCercanos(soldado);

	}

	public void actualizaSoldadosCercanos(Soldado soldado){

		setSoldadosContiguos(new ArrayList<Soldado>());
		if(arriba.getContenido().isPresent() && arriba.getContenido().get().getClass().equals(Soldado.class)){
			getSoldadosContiguos().add((Soldado) arriba.getContenido().get());
		}
		if(abajo.getContenido().isPresent() && abajo.getContenido().get().getClass().equals(Soldado.class)){
			getSoldadosContiguos().add((Soldado) abajo.getContenido().get());
		}
		if(izquierda.getContenido().isPresent() && izquierda.getContenido().get().getClass().equals(Soldado.class)){
			getSoldadosContiguos().add((Soldado) izquierda.getContenido().get());
		}
		if(derecha.getContenido().isPresent() && derecha.getContenido().get().getClass().equals(Soldado.class)){
			getSoldadosContiguos().add((Soldado) derecha.getContenido().get());
		}

	}

	public void actualizaObstaculosCercanos(Soldado soldado){

		setObstaculos(new ArrayList<Pieza>());

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
