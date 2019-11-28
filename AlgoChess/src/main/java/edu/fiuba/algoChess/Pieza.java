package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Salud.Salud;
import edu.fiuba.algoChess.Salud.SaludLlena;
import edu.fiuba.algoChess.Salud.SaludMuerto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
public abstract class Pieza implements Movible, Atacable {

	//protected TipoPieza nombre;
	@Setter
	@Getter
	private Salud vida;

	@Setter
	@Getter
	private int costo;

	@Setter
	@Getter
	protected Ubicacion ubicacion;

	@Setter
	@Getter
	protected Bando bando;

	@Setter
	@Getter
	protected Rango rango;


	/*	public Pieza(Ubicacion ubicacion, int costo, int vida, Bando bando) {

		this.bando = bando;
		this.ubicacion = ubicacion;
		this.vida = vida;
		this.costo = costo;

	}
*/
	Pieza(int costo, int vida) {

		this.vida = new SaludLlena(vida);
		this.costo = costo;

	}

	public Pieza(int costo, int vida, Ubicacion ubicacion, Bando bando) {

		this.bando = bando;
		this.ubicacion = ubicacion;
		this.vida = new SaludLlena(vida);
		this.costo = costo;

	}

	public Pieza(Ubicacion ubicacion) {

		this.vida = new SaludMuerto();
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

	//public TipoPieza getNombre(){return this.nombre;}

	public void aumentarVida(int aumento) {this.setVida(this.vida.curar(aumento));
		}

	public void recibirAtaque(Ataque ataque){
		this.vida.herir(ataque.getDanio());
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

	public ArrayList<Pieza> unirAInmediato(ArrayList<Pieza> piezasInmediatas) {
		piezasInmediatas.add(this);
		return piezasInmediatas;
	}

	public abstract void actualizaRango(Tablero tablero);

	public abstract Rango getRango();

	public abstract void unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion);

	public abstract void aniadirPiezaAlStack(ArrayList<Pieza> stack);

	public abstract void aniadirSoldadoAlStack(ArrayList<Pieza> stack);

	public abstract void aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack);

	public abstract ArrayList<Pieza>  getSoldadosContiguos();

	public abstract boolean soldadosInmediatosSePuedenUnir();

	//COMENTARIO IMPORTANTE: DECIDI MOVER EL METODO DE JINETE











	//public abstract void reconocerTerreno(int distanciaAReconocer, Pieza piezaCentral, Tablero campoDeBatalla);
}

