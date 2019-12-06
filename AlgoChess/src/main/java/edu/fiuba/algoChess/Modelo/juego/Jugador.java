package edu.fiuba.algoChess.Modelo.juego;
import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;

import java.util.Collections;
import java.util.Set;

public class Jugador {

	private String nombre;
	private int puntaje;
	private int creditos;
	private Bando bando;
	//private JugadorStatus status;
	private Set<Pieza> piezas;
	private Turno turno;

	public Jugador() {
		this.nombre = "";
		this.puntaje = 0;
		this.creditos = 20;
	//	this.status = JugadorStatus.INACTIVO;
		this.piezas = Collections.emptySet();
	}

	public Jugador(String unNombre) {
		this.puntaje = 0;
		this.nombre = unNombre;
		this.creditos = 20;
	//	this.status = JugadorStatus.INACTIVO;
		this.piezas = Collections.emptySet();
	}

	public void sumarPuntaje(int unPuntaje){this.puntaje += unPuntaje;}

	/*public void activarTurno(){this.status = JugadorStatus.EN_TURNO;}

	public void ponerEnEspera(){this.status = JugadorStatus.EN_ESPERA;}

	public void inhabilitar(){this.status = JugadorStatus.INACTIVO;}

	public void ganador(){this.status = JugadorStatus.GANADOR;}

	public void perdedor(){this.status = JugadorStatus.PERDEDOR;}*/

	public String nombre() {
		return this.nombre;
	}

	public int puntaje() {
		return this.puntaje;
	}

	//public JugadorStatus getStatus(){
	//	return this.status;
	//}
/*
	public void validarPerdedor(){
		if(this.piezas.isEmpty())
			this.perdedor();
	}
*/
	public void adquirirPieza(Pieza pieza){
		if(pieza.getCosto() <= this.creditos){
			this.creditos = this.creditos - pieza.getCosto();
			this.piezas.add(pieza);
		}
	}

}
