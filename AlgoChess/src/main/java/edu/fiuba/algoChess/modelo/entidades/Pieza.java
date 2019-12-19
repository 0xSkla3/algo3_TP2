package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.modelo.entorno.*;
import edu.fiuba.algoChess.modelo.excepciones.AccionAgrupableInvalidaException;
import edu.fiuba.algoChess.modelo.excepciones.CeldaYaOcupadaException;
import edu.fiuba.algoChess.modelo.excepciones.InteraccionInvalidaException;
import edu.fiuba.algoChess.modelo.rangos.Rango;
import edu.fiuba.algoChess.modelo.salud.Salud;
import edu.fiuba.algoChess.modelo.salud.SaludLlena;
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
	@Getter
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

 	public void aumentarVida(double aumento) {
		this.vida = this.vida.curar(aumento);
	}

	public void recibirAtaque(Ataque ataque){
 		this.setVida(this.bando.recibirAtaque(this.vida, ataque, this.bandoCeldaActual));
	}

	public void pisar(Celda celda, Pieza piezaAUbicar){
		throw new CeldaYaOcupadaException("No se puede ubicar la pieza porque la celda ya esta ocupada");
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
			Ubicacion ubicacionVieja = this.getUbicacion();
			campoDeBatalla.ubicarEnCeldaFaseJuego(this, ubicacion);
			campoDeBatalla.eliminar(ubicacionVieja);
			this.setUbicacion(ubicacion);
	}

	public void moverPiezaDeBatallon( Tablero campoDeBatalla, Ubicacion ubicacion){
		this.vida.stateComportarse();
			Ubicacion ubicacionVieja = this.getUbicacion();
			campoDeBatalla.ubicarEnCeldaFaseJuego(this, ubicacion);
			campoDeBatalla.eliminar(ubicacionVieja);
			this.setUbicacion(ubicacion);
	}

	public Rango actualizaRango(Tablero tablero){
		throw new AccionAgrupableInvalidaException("No se puede actualizar el rango de una pieza no agrupable");
	}

	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion){
		throw new InteraccionInvalidaException("No se puede agrupar una pieza distinta de soldado");
	}

	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack){
		try {
			stack.add(this);
			return stack;
		} catch(NullPointerException ex){
			ArrayList<Pieza> nuevoStack = new ArrayList<>();
			nuevoStack.add(this);
			return  nuevoStack;
		}
	}

	public ArrayList<Pieza> aniadirSoldadoAliadoStack(ArrayList<Pieza> stack, Pieza pieza){
		return stack;
	}

	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack){
		try {
			stack.add(this);
			return stack;
		} catch(NullPointerException ex){
			ArrayList<Pieza> nuevoStack = new ArrayList<>();
			nuevoStack.add(this);
			return  nuevoStack;
		}
	}

	public ArrayList<Pieza>  getSoldadosContiguos(){
		throw new AccionAgrupableInvalidaException("No se pueden obtener los soldados contiguos de una pieza no agrupable");
	}

	public boolean soldadosInmediatosSePuedenUnir(){
		throw new AccionAgrupableInvalidaException("No se pueden obtener los soldados contiguos de una pieza no agrupable");
	}

	public int getX(){
		return this.getUbicacion().getX();
	}

	public int getY(){
		return this.getUbicacion().getY();
	}

	public abstract void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza);
	public abstract void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza);
	public abstract void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza);

	public void atacar(Pieza atacado){
		DistanciaRelativa distanciaEntrePiezas = DistanciaRelativa.getDistanciaRelativa(this.ubicacion, atacado.ubicacion);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, atacado);
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

	public Batallon crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		throw new AccionAgrupableInvalidaException("No se puede crear un batallon de una pieza distinta a Soldado");
	}

	@Override
	public Batallon darDeAltaBatallon() {
		throw new AccionAgrupableInvalidaException("No se puede crear un batallon de una pieza distinta a Soldado");
	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		throw new AccionAgrupableInvalidaException("No se pueden obtener las piezas en equipo de una entidad no agrupable");
	}

	@Override
	public ArrayList<Pieza> getSoldadosEquipo() {
		throw new AccionAgrupableInvalidaException("No se pueden obtener las piezas en equipo de una entidad no agrupable");
	}

	@Override
	public Rango actualizaRangoInmediato(Pieza piezaCentral, Tablero tablero) {
		throw new AccionAgrupableInvalidaException("No se pueden obtener las piezas en rango de una entidad no agrupable");
	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {
		throw new AccionAgrupableInvalidaException("No se pueden obtener las piezas en rango de una entidad no agrupable");
	}

	@Override
	public void actualizaRangoSoldado(Pieza piezaCentral, Tablero tablero) {
		throw new AccionAgrupableInvalidaException("No se puede actualizar el rango de una pieza que no sea un soldado");
	}

	public void setBatallonActual(Batallon batallonActual){
		throw new AccionAgrupableInvalidaException("No se le puede asignar un batallon a una pieza distinta de Soldado");
	}

}
