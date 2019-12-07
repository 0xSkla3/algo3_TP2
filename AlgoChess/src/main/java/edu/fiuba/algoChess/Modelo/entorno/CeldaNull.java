package edu.fiuba.algoChess.Modelo.entorno;

import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeObtenerUnaPiezaDeCeldaaNull;

public class CeldaNull extends Celda {

	CeldaNull(){
		this.piezaActual = new PiezaNull();
		this.sectorDelJugador = null;
	}

	@Override
	public Pieza getPiezaActual(){
		throw new NoSePuedeObtenerUnaPiezaDeCeldaaNull("No se puede obtener pieza de CeldaNull");
		}

	@Override
	public void setSectorDelJugador(Bando bandoJugador){
		//Excepcion
	}

	@Override
	public void guardarComienzo(Pieza piezaAUbicar){
		//Excepcion
	}

	@Override
	public void guardarEnJuego(Pieza piezaAUbicar) {
		//Excepcion
	}

	@Override
	public void eliminar() {
		//Excepcion
	}

	@Override
	public void ubicar(Pieza piezaAGuardar) {
		//Excepcion
	}
}
