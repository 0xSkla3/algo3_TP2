package edu.fiuba.algoChess.Modelo.batallones;

import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.Modelo.entidades.Movible;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.Modelo.rangos.Agrupable;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
public class BatallonUtil extends Batallon implements Movible, Agrupable {

	@Setter
	@Getter
	Pieza pieza1;

	@Setter
	@Getter
	Pieza pieza2;

	@Setter
	@Getter
	Pieza pieza3;

	@Override
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		Ubicacion ubicacionDerecha1 = getPieza1().getUbicacion().getUbicacionDerecha();
		Ubicacion ubicacionDerecha2 = getPieza2().getUbicacion().getUbicacionDerecha();
		Ubicacion ubicacionDerecha3 = getPieza3().getUbicacion().getUbicacionDerecha();
		return this.moverBatallon(campoDeBatalla, ubicacionDerecha1, ubicacionDerecha2, ubicacionDerecha3);
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		Ubicacion ubicacionIzquierda1 = getPieza1().getUbicacion().getUbicacionIzquierda();
		Ubicacion ubicacionIzquierda2 = getPieza2().getUbicacion().getUbicacionIzquierda();
		Ubicacion ubicacionIzquierda3 = getPieza3().getUbicacion().getUbicacionIzquierda();
		return this.moverBatallon(campoDeBatalla, ubicacionIzquierda1, ubicacionIzquierda2, ubicacionIzquierda3);
	}

	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		Ubicacion ubicacionArriba1 = getPieza1().getUbicacion().getUbicacionArriba();
		Ubicacion ubicacionArriba2 = getPieza2().getUbicacion().getUbicacionArriba();
		Ubicacion ubicacionArriba3 = getPieza3().getUbicacion().getUbicacionArriba();
		return this.moverBatallon(campoDeBatalla, ubicacionArriba1, ubicacionArriba2, ubicacionArriba3);
	}

	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		Ubicacion ubicacionAbajo1 = getPieza1().getUbicacion().getUbicacionAbajo();
		Ubicacion ubicacionAbajo2 = getPieza2().getUbicacion().getUbicacionAbajo();
		Ubicacion ubicacionAbajo3 = getPieza3().getUbicacion().getUbicacionAbajo();
		return this.moverBatallon(campoDeBatalla, ubicacionAbajo1, ubicacionAbajo2, ubicacionAbajo3);
	}

	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){

		Ubicacion ubicacionVieja1 = getPieza1().getUbicacion();
		Ubicacion ubicacionVieja2 = getPieza2().getUbicacion();
		Ubicacion ubicacionVieja3 = getPieza3().getUbicacion();

		campoDeBatalla.eliminar(ubicacionVieja1);
		campoDeBatalla.eliminar(ubicacionVieja2);
		campoDeBatalla.eliminar(ubicacionVieja3);

		try {
			this.getPieza1().moverPiezaDeBatallon(campoDeBatalla, ubicacion1);
		}catch(NoSePuedeUbicarPorqueEstaOcupadoException ex) {
			campoDeBatalla.ubicarEnCeldaFaseInicial(this.getPieza1(),ubicacionVieja1);
		}
		try {
			this.getPieza2().moverPiezaDeBatallon(campoDeBatalla, ubicacion2);
		}catch(NoSePuedeUbicarPorqueEstaOcupadoException ex) {
			campoDeBatalla.ubicarEnCeldaFaseInicial(this.getPieza2(),ubicacionVieja2);

		}
		try {
			this.getPieza3().moverPiezaDeBatallon(campoDeBatalla, ubicacion3);
		}catch(NoSePuedeUbicarPorqueEstaOcupadoException ex) {
			campoDeBatalla.ubicarEnCeldaFaseInicial(this.getPieza3(),ubicacionVieja3);
		}

		this.getPieza1().actualizaRango(campoDeBatalla);
		this.getPieza2().actualizaRango(campoDeBatalla);
		this.getPieza3().actualizaRango(campoDeBatalla);

		return BatallonUtil.darDeAltaBatallon(this.getPieza1());

	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Batallon crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return new BatallonUtil(pieza1, pieza2, pieza3);
	}

	@Override
	public void actualizaRangoMedio(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void actualizaRangoCercano(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
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

