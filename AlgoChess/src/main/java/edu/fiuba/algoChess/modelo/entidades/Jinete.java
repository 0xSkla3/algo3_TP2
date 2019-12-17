package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.modelo.comportamientos.AtaqueNormal;
import edu.fiuba.algoChess.modelo.comportamientos.AtaqueNull;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.modelo.excepciones.PiezaActualNoFormaBatallonDeSoldadosException;

import edu.fiuba.algoChess.modelo.rangos.Agrupable;
import edu.fiuba.algoChess.modelo.rangos.Rango;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.abs;
public class Jinete extends Pieza {

	@Getter
	@Setter
	private Ataque ataqueMedio;

	@Getter
	@Setter
	private AtaqueNormal ataqueCercano;

	public boolean piezaAliadaCercana;

	public boolean piezaEnemigaCercana;

	@Getter
	@Setter
	private int distanciaAReconocerEnTerreno = 2;

	@Getter
	private double danioCercano = 5;

	@Getter
	private double danioMedio = 15;

	public Jinete(Ubicacion ubicacion, Bando bando, Tablero tablero) {

		super(3, 100, ubicacion, bando);
		tablero.ubicarEnCeldaFaseInicial(this, ubicacion);
		this.ataqueCercano = new AtaqueNormal(danioCercano);
		this.ataqueMedio = new AtaqueNormal(danioMedio);
		//this.ataqueMedio = new AtaqueNormal(danioMedio);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCeldaFaseJuego(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
			this.bando.atacar(pieza, this.ataqueCercano, pieza.getBando());
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		this.ubicacion.reconocerTerrenoParaAtacarADistanciaMedia(this, distanciaAReconocerEnTerreno, ubicacion, bando);
		this.concretarAtaqueMedio(pieza);
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	public void concretarAtaqueMedio(Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
	}

	public void ataqueMedioInvalido() {
		this.ataqueMedio = new AtaqueNull(0);
	}

	public void ataqueMedioValido() {
		this.ataqueMedio = new AtaqueNormal(danioMedio);
	}
}
