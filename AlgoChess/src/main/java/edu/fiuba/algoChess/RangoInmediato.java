package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class RangoInmediato extends Rango{

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
	ArrayList<Pieza> piezasEnEntorno;

	public void actualizaRango(Pieza piezaCentral, Tablero tablero){
		setArriba(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionArriba()));
		setAbajo(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionAbajo()));
		setDerecha(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionIzquierda()));
		setIzquierda(tablero.getCelda(piezaCentral.getUbicacion().getUbicacionDerecha()));

		actualizaEntornoInmediato(piezaCentral);
	}

	public void actualizaEntornoInmediato(Pieza piezaCentral){

		setPiezasEnEntorno(new ArrayList<>());

		if(arriba.getContenido().isPresent()){
			getPiezasEnEntorno().add(this.getArriba().getContenido().get());
		}
		if(abajo.getContenido().isPresent()){
			getPiezasEnEntorno().add(this.getAbajo().getContenido().get());
		}
		if(izquierda.getContenido().isPresent()){
			getPiezasEnEntorno().add(this.getIzquierda().getContenido().get());
		}
		if(derecha.getContenido().isPresent()){
			getPiezasEnEntorno().add(this.getDerecha().getContenido().get());
		}

	}

}
