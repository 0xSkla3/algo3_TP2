package edu.fiuba.algoChess;

import java.util.ArrayList;

import static java.lang.Math.abs;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
public class Jinete extends Pieza {


	private Comportamiento ataqueMedio = new ComportamientoMedio(15);
	private Comportamiento ataqueCercano = new AtaqueCercanoJinete(5);

	private int danioCercano = 5; 
	private int danioMedio = 15;

	public boolean piezaAliadaCercana;
	public boolean piezaEnemigaCercana;
	private int distanciaAReconocerEnTerreno;


	public Jinete(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo, vida, ubicacion, bando);
	}

	public Jinete() {

		super(3, 100);

		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;
	}

	public Jinete(Ubicacion ubicacion,Bando bando){

		super(3, 100,ubicacion,bando);
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



	@Override
	public Rango actualizaRango(Tablero tablero) {
		return null;
	}

	@Override
	public Rango getRango() {
		return null;
	}

	@Override
	public void unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		//throw new IllegalStateException("Un jinete no se puede unir a un batallon de Soldado");
	}

	@Override
	public void aniadirPiezaAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
	}

	@Override
	public void aniadirSoldadoAlStack(ArrayList<Pieza> stack) {
	}

	@Override
	public void aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
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
		if(this.getPiezaAliadaCercana()){
			this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
		}
		else{
			this.bando.atacar(pieza, this.ataqueCercano, pieza.getBando());
		}
	};
  
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
	};
  
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
		};
  
  public void atacar(Pieza atacado){
	  DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this,atacado);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, atacado);
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
				if (!celda.isEmpty() && (celda.getPiezaActual().getBando().equals(this.bando))) {
					piezaAliadaCercana = true;
					continue;
				} else if (!celda.isEmpty() && !(celda.getPiezaActual().getBando().equals(this.bando))) {
					piezaEnemigaCercana = true;
					continue;
				}
			}
		}
	}




	public boolean getPiezaAliadaCercana(){
			return this.piezaAliadaCercana;
	}

	public boolean getPiezaEnemigaCercana(){
		return this.piezaEnemigaCercana;
	};

	public int getDanioMedio(){
		return this.danioMedio;
	};

	public int getDanioCercano(){
		return this.danioCercano;
	};

	public Comportamiento getAtaqueMedio(){
		return this.ataqueMedio;
	};

	public Comportamiento getAtaqueCercano(){
		return this.ataqueCercano;
	};

}


