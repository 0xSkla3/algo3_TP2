package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.*;
import edu.fiuba.algoChess.modelo.rangos.Agrupable;
import edu.fiuba.algoChess.modelo.rangos.Rango;
import edu.fiuba.algoChess.modelo.salud.Salud;
import edu.fiuba.algoChess.modelo.salud.SaludLlena;
import edu.fiuba.algoChess.modelo.salud.SaludMuerto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public abstract class Pieza extends Movible implements Batalloneable {

	@Setter
	@Getter
	protected Salud vida;

	@Setter
	@Getter
	protected int costo;

	@Setter
	@Getter
	protected Ubicacion ubicacion;

	@Setter
	@Getter
	protected Bando bando;

	@Setter
	@Getter
	protected  Bando bandoCeldaActual;

	@Setter
	protected Rango rango;

	@Setter
	@Getter
	protected DistanciaRelativa calculadorDistancia;

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

 	public void aumentarVida(double aumento) {
		this.vida.curar(aumento);
	}

	public void recibirAtaque(double ataque){
		double danioARecibir = ataque;
		if(this.bandoEnemigo(bandoCeldaActual)){
			danioARecibir = ataque*0.05;
		}
		this.setVida(this.vida.herir(danioARecibir));
	}

	// FIXME: revisar si esto no tiene que ser static
	public void pisar(Celda celda, Pieza pieza){
		celda.setPiezaActual(pieza);
	}

	public void moverseALaDerecha(Tablero campoDeBatalla){
 		this.vida.stateComportarse();
		Ubicacion ubicacionDerecha = this.ubicacion.getUbicacionDerecha();
		this.mover(campoDeBatalla, ubicacionDerecha);
	}

	public void moverseALaIzquierda(Tablero campoDeBatalla) {
 		this.vida.stateComportarse();
		Ubicacion ubicacionIzquierda = this.ubicacion.getUbicacionIzquierda();
		this.mover(campoDeBatalla, ubicacionIzquierda);
	}

	public void moverseArriba(Tablero campoDeBatalla) {
 		this.vida.stateComportarse();
		Ubicacion ubicacionArriba = this.ubicacion.getUbicacionArriba();
		this.mover(campoDeBatalla, ubicacionArriba);
	}

	public void moverseAbajo(Tablero campoDeBatalla) {
 		this.vida.stateComportarse();
		Ubicacion ubicacionAbajo = this.ubicacion.getUbicacionAbajo();
		this.mover(campoDeBatalla, ubicacionAbajo);
	}

	public void mover( Tablero campoDeBatalla, Ubicacion ubicacion) {
		this.vida.stateComportarse();
		try {
			Ubicacion ubicacionVieja = this.getUbicacion();
			campoDeBatalla.ubicarEnCeldaFaseJuego(this, ubicacion);
			campoDeBatalla.eliminar(ubicacionVieja);
			this.setUbicacion(ubicacion);
		}catch (NoSePuedeUbicarPorqueEstaOcupadoException ex){
			//mensaje de error en vista y darle el turno al mismo jugador
		}
	}

	public void moverPiezaDeBatallon( Tablero campoDeBatalla, Ubicacion ubicacion){
		this.vida.stateComportarse();
		try {
			Ubicacion ubicacionVieja = this.getUbicacion();
			campoDeBatalla.ubicarEnCeldaFaseInicial(this, ubicacion);
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

	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack){
		stack.add(this);
		return stack;
	}

	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack, Pieza pieza){
		if (stack == null) return new ArrayList<>();
		return stack;
	};

	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack){
		stack.add(this);
		return stack;
	}

	public abstract ArrayList<Pieza>  getSoldadosContiguos();

	public abstract boolean soldadosInmediatosSePuedenUnir();

	public int getX(){
		return this.getUbicacion().getX();
	}

	public int getY(){
		return this.getUbicacion().getY();
	}

	public boolean notEqualsNull(){
		boolean condicion1 = !this.getVida().igualA(new SaludMuerto());
		boolean condicion2 = this.getCosto() != 0;
		boolean condicion3 = this.getBando() != null;

		return condicion1 && condicion2 && condicion3;
	}

	public abstract void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza);
	public abstract void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza);
	public abstract void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza);

	public void atacar(Pieza atacado){
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this.ubicacion, atacado.ubicacion);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, atacado);
	}

	public abstract void curar(Pieza curado);

	public boolean bandoAliado(Bando bando){
		return this.bando.bandoAliado(bando);
	}

	public boolean bandoEnemigo(Bando bando){
		return this.bando.bandoEnemigo(bando);
	}

	public Pieza obtenerPiezaArriba(){
		return ubicacion.obtenerPieza(ubicacion.getUbicacionArriba());
	}

	public Pieza obtenerPiezaAbajo(){
		return ubicacion.obtenerPieza(ubicacion.getUbicacionAbajo());
	}

	public Pieza obtenerPiezaDerecha(){
		return ubicacion.obtenerPieza(ubicacion.getUbicacionDerecha());
	}

	public Pieza obtenerPiezaIzquierda(){
		return ubicacion.obtenerPieza(ubicacion.getUbicacionIzquierda());
	}

	public Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3){
		throw new NoSePuedeAgruparUnaPiezaDistintaDeSoldado("No se puede agrupar una pieza que no sea un soldado");
	}

	public Batallon crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		throw new NoSePuedeCrearUnBatallonDePiezaDistintaASoldado("No se puede crear un batallon de una pieza distinta a Soldado");
	}

	@Override
	public Batallon darDeAltaBatallon() {
		throw new NoSePuedeCrearUnBatallonDePiezaDistintaASoldado("No se puede crear un batallon de una pieza distinta a Soldado");
	}

}
