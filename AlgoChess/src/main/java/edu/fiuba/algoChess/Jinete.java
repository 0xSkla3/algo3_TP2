package edu.fiuba.algoChess;

import edu.fiuba.algoChess.batallones.Batalloneable;
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

	@Getter
	@Setter
	public boolean piezaAliadaCercana;

	@Getter
	@Setter
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

	public Jinete(Ubicacion ubicacion,Bando bando){

		super(3, 100,ubicacion,bando);
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

	public Jinete(Ubicacion ubicacion, Bando bando, Tablero tablero){

		super(3, 100,ubicacion,bando);
		this.ataqueCercano = new AtaqueCercanoJinete(5);
		this.ataqueMedio = new AtaqueMedioJinete(15);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;
		tablero.ubicarEnCelda(this,ubicacion);

	}

	public Jinete(Ubicacion ubicacion, Tablero tablero){

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
		return null;
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		return null;
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		return null;
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {

	}

	@Override
	public Rango actualizaRango(Tablero tablero) {

		return null;
	}

	@Override
	public Rango getRango() {
		return null;
	}

	@Override
	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		//throw new IllegalStateException("Un jinete no se puede unir a un batallon de Soldado");
		return stackDeUnion;
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
		return null;
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return false;
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {

	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {

	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {

	}

	public void atacar(DistanciaRelativa distancia, Pieza atacado){
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


	public boolean getPiezaAliadaCercana(){
			return this.piezaAliadaCercana;
	}

	public boolean getPiezaEnemigaCercana(){
		return this.piezaEnemigaCercana;
	}

	@Override
	public void recibirAtaque(Ataque ataque) {

	}

	public void atacar(Pieza pieza) {

	}

}


