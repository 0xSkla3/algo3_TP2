package edu.fiuba.algoChess;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Pieza implements Movible {

	//protected TipoPieza nombre;
	private int vida;
	private int costo;
	protected Ubicacion ubicacion;
	protected Jugador jugadorDueño;
	private System system;

	public Pieza(Ubicacion ubicacion, int costo, int vida) {

		this.ubicacion = ubicacion;
		this.vida = vida;
		this.costo = costo;

	}

	public Pieza(int costo, int vida) {

		this.ubicacion = ubicacion;
		this.vida = vida;
		this.costo = costo;

	}

	public Pieza(Ubicacion ubicacion) {

		this.vida = 0;
		this.costo = 0;
		this.ubicacion = ubicacion;

	}

	public void ejecutarComportamiento(DistanciaRelativa distancia, Pieza pieza){

	};

	public DistanciaRelativa getDistanciaRelativa (Pieza pieza){
		Ubicacion ubicacionPiezaAfectada = pieza.getUbicacion();
		Ubicacion ubicacionPiezaAfectante = this.getUbicacion();
		int coordenadaXAtacado = ubicacionPiezaAfectada.getCoordenadaX();
		int coordenadaYAtacado = ubicacionPiezaAfectada.getCoordenadaY();
		int coordenadaXAtacante = ubicacionPiezaAfectante.getCoordenadaX();
		int coordenadaYAtacante = ubicacionPiezaAfectante.getCoordenadaY();

		DistanciaRelativa distanciaRelativa = DistanciaRelativa.LEJANO;

		//DistanciaRelativa distanciaRelativa = DistanciaRelativa.LEJANO;
		if ((Math.abs(coordenadaXAtacado-coordenadaXAtacante)+(Math.abs(coordenadaYAtacado-coordenadaYAtacante)))<3) {
			distanciaRelativa = DistanciaRelativa.CERCANO;
		}
		if (((Math.abs(coordenadaXAtacado-coordenadaXAtacante)+(Math.abs(coordenadaYAtacado-coordenadaYAtacante)))>2)&&
				((Math.abs(coordenadaXAtacado-coordenadaXAtacante)+(Math.abs(coordenadaYAtacado-coordenadaYAtacante)))<6)){
			distanciaRelativa = DistanciaRelativa.MEDIO;
		}
//		if ((Math.abs(coordenadaXAtacado-coordenadaXAtacante)+(Math.abs(coordenadaYAtacado-coordenadaYAtacante)))>5){
//			distanciaRelativa = DistanciaRelativa.LEJANO;
//		};
		return distanciaRelativa;
	};



	public Jugador getJugador() {
		return this.jugadorDueño;
		}

	public void setJugador(Jugador jugador){
		this.jugadorDueño = jugador;
		}

	public int getCosto(){
		return this.costo;
		}

	//public TipoPieza getNombre(){return this.nombre;}

	public int getVida() {
		return this.vida;
		}

	public Ubicacion getUbicacion() {
		//system.out.println(this.ubicacion);
		return this.ubicacion;
		}

	public void aumentarVida(int aumento) {
		this.vida = this.vida + aumento;
		}

	public void bajarVida(int disminucion){
		this.vida = this.vida - disminucion;
		}

	public void setUbicacion(Ubicacion ubicacion){
		this.ubicacion=ubicacion;
		}

	public void moverseALaDerecha(Tablero campoDeBatalla){
		Ubicacion ubicacionDerecha = this.ubicacion.getUbicacionDerecha();
		this.mover(campoDeBatalla, ubicacionDerecha);
	}

	public void moverseALaIzquierda(Tablero campoDeBatalla) {
		Ubicacion ubicacionIzquierda = this.ubicacion.getUbicacionIzquierda();
		this.mover(campoDeBatalla, ubicacionIzquierda);
	}

	public void moverseArriba(Tablero campoDeBatalla) {
		Ubicacion ubicacionArriba = this.ubicacion.getUbicacionArriba();
		this.mover(campoDeBatalla, ubicacionArriba);
	}

	public void moverseAbajo(Tablero campoDeBatalla) {
		Ubicacion ubicacionAbajo = this.ubicacion.getUbicacionAbajo();
		this.mover(campoDeBatalla, ubicacionAbajo);
	}

	public void mover( Tablero campoDeBatalla, Ubicacion ubicacion) {
		if(campoDeBatalla.getCelda(ubicacion).isEmpty()){
			Ubicacion ubicacionVieja = this.getUbicacion();
			campoDeBatalla.ubicarEnCelda(this, ubicacion);
			campoDeBatalla.eliminar(ubicacionVieja);
			this.ubicacion = ubicacion;}
	}

	//public abstract void reconocerTerreno(int distanciaAReconocer, Pieza piezaCentral, Tablero campoDeBatalla);
}

