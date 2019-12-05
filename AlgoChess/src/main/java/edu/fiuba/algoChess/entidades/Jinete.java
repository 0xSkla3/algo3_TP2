package edu.fiuba.algoChess.entidades;

import edu.fiuba.algoChess.bandos.Bando;
import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.comportamientos.Ataque;
import edu.fiuba.algoChess.comportamientos.AtaqueCercanoJinete;
import edu.fiuba.algoChess.comportamientos.AtaqueMedioJinete;
import edu.fiuba.algoChess.comportamientos.Comportamiento;
import edu.fiuba.algoChess.entorno.*;
import edu.fiuba.algoChess.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.excepciones.NoHayBatallonFormadoException;
import edu.fiuba.algoChess.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.excepciones.PiezaActualNoFormaBatallonDeSoldadosException;
import edu.fiuba.algoChess.rangos.Rango;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import static java.lang.Math.abs;
public class Jinete extends Pieza {

	@Getter
	@Setter
	private Comportamiento ataqueMedio = new AtaqueMedioJinete(15);

	@Getter
	@Setter
	private Comportamiento ataqueCercano = new AtaqueCercanoJinete(5);

//	@Getter
//	@Setter
	public boolean piezaAliadaCercana;

//	@Getter
//	@Setter
	public boolean piezaEnemigaCercana;

	@Getter
	@Setter
	private int distanciaAReconocerEnTerreno;


	public Jinete(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo, vida, ubicacion, bando);
	}

	public Jinete() {

		super(3, 100);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;

	}

	public Jinete(Ubicacion ubicacion, Bando bando) {

		super(3, 100, ubicacion, bando);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;

	}


	public Jinete(Ubicacion ubicacion) {
		super(ubicacion);
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCelda(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}

	public Jinete(Ubicacion ubicacion, Bando bando, Tablero tablero) {

		super(3, 100, ubicacion, bando);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;
		tablero.ubicarEnCelda(this, ubicacion);

	}

	public Jinete(Ubicacion ubicacion, Tablero tablero) {

		super(ubicacion);
		tablero.getCelda(ubicacion).setPiezaActual(this);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;

	}

	@Override
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Rango actualizaRango(Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Rango getRango() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Un jinete no puede formar un batallon de soldados");

	}

	@Override
	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack) {
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Un jinete no se puede unir a un soldado");
	}


	public void atacar(DistanciaRelativa distancia, Pieza atacado) {
	}

	public void reconocerTerreno(Tablero campoDeBatalla) {

		int coordenadaX = this.ubicacion.getCoordenadaX();
		int coordenadaY = this.ubicacion.getCoordenadaY();

		for (int i = coordenadaX - distanciaAReconocerEnTerreno; i <= coordenadaX + distanciaAReconocerEnTerreno; i++) {
			if (i < 1 || i > 20) {
				continue;
			}
			for (int j = coordenadaY - distanciaAReconocerEnTerreno; j <= coordenadaX + distanciaAReconocerEnTerreno; j++) {
				if (j < 1 || j > 20) {
					continue;
				}
				Ubicacion ubicacion = new Ubicacion(i, j);
				if (ubicacion.equals(this.getUbicacion())) {
					continue;
				}
				Celda celda = campoDeBatalla.getCelda(ubicacion);
			/*	if (!celda.isEmpty() && (celda.getPiezaActual().getBando().equals(this.bando))) {
					piezaAliadaCercana = true;
					continue;
				} else if (!celda.isEmpty() && !(celda.getPiezaActual().getBando().equals(this.bando))) {
					piezaEnemigaCercana = true;
					continue;
				} */ //ROCHI
			}
		}
	}


	public boolean getPiezaAliadaCercana() {
		return this.piezaAliadaCercana;
	}

	public boolean getPiezaEnemigaCercana() {
		return this.piezaEnemigaCercana;
	}


	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		if (this.getPiezaAliadaCercana()) {
			this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
		} else {
			this.bando.atacar(pieza, this.ataqueCercano, pieza.getBando());
		}
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	public void atacar(Pieza atacado) {
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this, atacado);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, atacado);

	}
}


