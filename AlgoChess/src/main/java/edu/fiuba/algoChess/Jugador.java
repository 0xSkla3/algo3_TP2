package edu.fiuba.algoChess;
import java.util.Collections;
import java.util.Set;

public class Jugador {

	private String nombre;
	private int puntaje;
	private int creditos;
	private JugadorStatus status;
	private Set<Ficha> fichas;

	public Jugador() {
		this.nombre = "";
		this.puntaje = 0;
		this.creditos = 20;
		this.status = JugadorStatus.INACTIVO;
		this.fichas = Collections.emptySet();
	}

	public Jugador(String unNombre) {
		this.puntaje = 0;
		this.nombre = unNombre;
		this.creditos = 20;
		this.status = JugadorStatus.INACTIVO;
		this.fichas = Collections.emptySet();
	}

	public void sumarPuntaje(int unPuntaje){this.puntaje += unPuntaje;}

	public void activarTurno(){this.status = JugadorStatus.EN_TURNO;}

	public void ponerEnEspera(){this.status = JugadorStatus.EN_ESPERA;}

	public void inhabilitar(){this.status = JugadorStatus.INACTIVO;}

	public void ganador(){this.status = JugadorStatus.GANADOR;}

	public void perdedor(){this.status = JugadorStatus.PERDEDOR;}

	public String nombre() {
		return this.nombre;
	}

	public int puntaje() {
		return this.puntaje;
	}

	public JugadorStatus getStatus(){ return this.status;}

	public void validarPerdedor(){
		if(this.fichas.isEmpty())
			this.perdedor();
	}

	public void adquirirFicha(Ficha ficha){
		if(ficha.getCosto() <= this.creditos){
			this.creditos = this.creditos - ficha.getCosto();
			//this.fichas.add(ficha);
		}else{
			this.status = JugadorStatus.POR_COMENZAR;
		}
	}

}
