package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeMoverUnGrupoParaUnaPiezaUnica;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeMoverUnaPiezaUnicaParaUnGrupo;
import edu.fiuba.algoChess.entidades.Observable;

public abstract class Movible extends Observable {

	public void moverseALaDerecha(Tablero campoDeBatalla){
		throw new NoSePuedeMoverUnaPiezaUnicaParaUnGrupo("No se puede mover una pieza unica para un grupo");
	};

	public  void moverseALaIzquierda(Tablero campoDeBatalla){
		throw new NoSePuedeMoverUnaPiezaUnicaParaUnGrupo("No se puede mover una pieza unica para un grupo");
	}

	public  void moverseArriba(Tablero campoDeBatalla){
		throw new NoSePuedeMoverUnaPiezaUnicaParaUnGrupo("No se puede mover una pieza unica para un grupo");
	}

	public  void moverseAbajo(Tablero campoDeBatalla){
		throw new NoSePuedeMoverUnaPiezaUnicaParaUnGrupo("No se puede mover una pieza unica para un grupo");
	}

	public  void mover(Tablero campoDeBatalla, Ubicacion ubicacion){
		throw new NoSePuedeMoverUnaPiezaUnicaParaUnGrupo("No se puede mover una pieza unica para un grupo");
	}

	public Batallon moverBatallonDerecha(Tablero campoDeBatalla){
		throw new NoSePuedeMoverUnGrupoParaUnaPiezaUnica("No se puede mover un grupo para una pieza unica");
	}

	public Batallon moverBatallonIzquierda(Tablero campoDeBatalla){
		throw new NoSePuedeMoverUnGrupoParaUnaPiezaUnica("No se puede mover un grupo para una pieza unica");
	}

	public Batallon moverBatallonArriba(Tablero campoDeBatalla){
		throw new NoSePuedeMoverUnGrupoParaUnaPiezaUnica("No se puede mover un grupo para una pieza unica");
	}

	public Batallon moverBatallonAbajo(Tablero campoDeBatalla){
		throw new NoSePuedeMoverUnGrupoParaUnaPiezaUnica("No se puede mover un grupo para una pieza unica");
	}

	public Batallon moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){
		throw new NoSePuedeMoverUnGrupoParaUnaPiezaUnica("No se puede mover un grupo para una pieza unica");
	}

}
