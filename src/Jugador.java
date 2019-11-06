package edu.fiuba.algo3.tp2;

public class Jugador {

	private String nombre;
	private int puntaje;
	private JugadorStatus status;

	public Jugador() {
		this.nombre = "";
		this.puntaje = 0;
		this.status = JugadorStatus.INACTIVO;
	}

	public Jugador(String unNombre) {
		this.puntaje = 0;
		this.nombre = unNombre;
		this.status = JugadorStatus.INACTIVO;
	}

	public void sumarPuntaje(int unPuntaje){this.puntaje += unPuntaje;}

	public void activarTurno(){this.status = JugadorStatus.EN_TURNO;}

	public void ponerEnEspera(){this.status = JugadorStatus.EN_ESPERA;}

	public void inhabilitar(){this.status = JugadorStatus.INACTIVO;}

	public String nombre() {
		return this.nombre;
	}

	public int puntaje() {
		return this.puntaje;
	}

	public JugadorStatus getStatus(){ return this.status;}

}