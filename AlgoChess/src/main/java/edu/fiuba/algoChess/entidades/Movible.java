package edu.fiuba.algoChess.entidades;

import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.entorno.Tablero;
import edu.fiuba.algoChess.entorno.Ubicacion;

public interface Movible {

	public void moverseALaDerecha(Tablero campoDeBatalla);

	public void moverseALaIzquierda(Tablero campoDeBatalla);

	public void moverseArriba(Tablero campoDeBatalla);

	public void moverseAbajo(Tablero campoDeBatalla);

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion);

	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla);

	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla);

	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla);

	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla);

	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3);

	public void moverPiezaDeBatallon( Tablero campoDeBatalla, Ubicacion ubicacion);


}
