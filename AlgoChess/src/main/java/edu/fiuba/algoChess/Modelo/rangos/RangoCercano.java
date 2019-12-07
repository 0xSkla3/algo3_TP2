package edu.fiuba.algoChess.Modelo.rangos;

import edu.fiuba.algoChess.Modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Celda;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.StrictMath.abs;

public class RangoCercano implements Rango{

	@Getter
	@Setter
	private Map<Ubicacion, Celda> rangoCarcano;

	@Getter
	@Setter
	ArrayList<Pieza> piezasEnRango;

	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {

		//Excepcion
		return null;
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {
		ArrayList<Pieza> nuevoRangoCercano = new ArrayList<>();
		this.getPiezasEnRango().forEach(celda -> celda.aniadirPiezaAlStack(nuevoRangoCercano));
		this.setPiezasEnRango(nuevoRangoCercano);
	}

	@Override
	public void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero) {
		Map<Ubicacion, Celda> nuevoRangoCarcano = new HashMap<>();
		final int xInicial = piezaCentral.getUbicacion().getX() - 2;
		final int yInicial = piezaCentral.getUbicacion().getY() - 2;
		int x;
		int y;

		for(x = xInicial; abs(x - xInicial) < 5; x++){
			for(y = yInicial; abs(y - yInicial) < 5; y++){
				nuevoRangoCarcano.put(new Ubicacion(x, y), tablero.getCampoDeBatalla().get(new Ubicacion(x,y)));
			}
		}
			this.setRangoCarcano(nuevoRangoCarcano);
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public Batalloneable darDeAltaBatallon() {
		return null;
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		return null;
	}
}
