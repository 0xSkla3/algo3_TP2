package edu.fiuba.algoChess;

import edu.fiuba.algoChess.rangos.Rango;
import edu.fiuba.algoChess.salud.Salud;
import edu.fiuba.algoChess.salud.SaludLlena;
import edu.fiuba.algoChess.salud.SaludMuerto;
import edu.fiuba.algoChess.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public abstract class Pieza implements Movible, Atacable {

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

	@Setter
	@Getter
	protected DistanciaRelativa calculadorDistancia;

	Pieza(int costo, int vida) {

		this.vida = new SaludLlena(vida);
		this.costo = costo;
		this.calculadorDistancia = new DistanciaRelativa();

	}

	public Pieza(int costo, int vida, Ubicacion ubicacion, Bando bando) {
		this.bando = bando;
		this.ubicacion = ubicacion;
		this.vida = new SaludLlena(vida);
		this.costo = costo;
		this.calculadorDistancia = new DistanciaRelativa();
	}

	public Pieza(Ubicacion ubicacion) {
		this.vida = new SaludMuerto();
		this.costo = 0;
		this.ubicacion = ubicacion;
		this.bando = null;
		this.calculadorDistancia = new DistanciaRelativa();
	}

	boolean equals(Pieza pieza){

		boolean condicion1 = pieza.getVida().igualA(this.getVida());
		boolean condicion2 = pieza.getCosto() == this.getCosto();
		return condicion1 && condicion2 ;

	}

	public void ejecutarComportamiento(DistanciaRelativa distancia, Pieza pieza){
	};

	public void aumentarVida(int aumento) {
		this.setVida(this.getVida().curar(aumento));
	}

	public void recibirAtaque(int ataque){
		this.setVida(this.getVida().herir(ataque));
	}

	public void pisar(Celda celda, Pieza pieza){
		celda.setPiezaActual(pieza);
		//throw new NoSePuedeUbicarPorqueEstaOcupadoException("No se puede ubicar porque esta ocupado la celda");
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
		try {
			Ubicacion ubicacionVieja = this.getUbicacion();
			campoDeBatalla.ubicarEnCelda(this, ubicacion);
			campoDeBatalla.eliminar(ubicacionVieja);
			this.setUbicacion(ubicacion);
		}catch (NoSePuedeUbicarPorqueEstaOcupadoException ex){
			//mensaje de error en vista y darle el turno al mismo jugador
		}

	}

	public void moverPiezaDeBatallon( Tablero campoDeBatalla, Ubicacion ubicacion){
		try {
			Ubicacion ubicacionVieja = this.getUbicacion();
			campoDeBatalla.ubicarEnCelda(this, ubicacion);
			campoDeBatalla.eliminar(ubicacionVieja);
			this.setUbicacion(ubicacion);
		}catch (NoSePuedeUbicarPorqueEstaOcupadoException ex){
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
			//mensaje de error en vista y darle el turno al mismo jugador
		}
	}

	public abstract Rango actualizaRango(Tablero tablero);

	public abstract Rango getRango();

	public abstract ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion);

	public abstract ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack);

	public abstract ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack);

	public abstract ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack);

	public abstract ArrayList<Pieza>  getSoldadosContiguos();

	public abstract boolean soldadosInmediatosSePuedenUnir();

	public boolean notEqualsNull(){
		boolean condicion1 = !this.getVida().igualA(new SaludMuerto());
		boolean condicion2 = this.getCosto() != 0;
		boolean condicion3 = this.getBando() != null;

		return condicion1 && condicion2 && condicion3;
	}

	public void aumentarVida(Comportamiento comportamiento) {
		getVida().curar(comportamiento.getValorComportamiento());
	}

	public void recibirAtaque(Comportamiento comportamiento){
		this.setVida(getVida().herir(comportamiento.getValorComportamiento()));
	}

	public void ejecutarComportamientoPorDistancia(DistanciaRelativa distancia, Pieza pieza) { }

	public abstract void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza);
	public abstract void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza);
	public abstract void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza);

	public DistanciaRelativa getCalculadorDistancia(){
		return this.calculadorDistancia;
	}

	public void setUbicacion(Ubicacion ubicacion){
		this.ubicacion=ubicacion;
	}

}
