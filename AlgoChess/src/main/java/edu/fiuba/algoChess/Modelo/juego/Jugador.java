package edu.fiuba.algoChess.Modelo.juego;

import edu.fiuba.algoChess.Modelo.juego.Turno;
import lombok.Getter;
import lombok.Setter;


import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Jugador {

	private String nombre;
	private int puntaje;
	private int creditos;
	@Setter
	@Getter
	private Bando bando;
	private ArrayList<Pieza> piezas;
	private Turno turno;

	public Jugador() {
		this.nombre = "";
		this.puntaje = 0;
		this.creditos = 20;
		this.piezas = new ArrayList<>();
	}

	public Jugador(String unNombre) {
		this.puntaje = 0;
		this.nombre = unNombre;
		this.creditos = 20;
		this.piezas = new ArrayList<>();
	}

	public void sumarPuntaje(int unPuntaje){this.puntaje += unPuntaje;}

	public String nombre() {
		return this.nombre;
	}

	public int puntaje() {
		return this.puntaje;
	}

	public void adquirirPieza(Pieza pieza){
		if(pieza.getCosto() <= this.creditos){
			this.creditos = this.creditos - pieza.getCosto();
			this.piezas.add(pieza);
		}else{
			//excepcion
		}
	}

}
