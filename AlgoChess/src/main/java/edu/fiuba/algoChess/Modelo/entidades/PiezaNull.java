package edu.fiuba.algoChess.Modelo.entidades;

import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.Modelo.entorno.*;
import edu.fiuba.algoChess.Modelo.batallones.BatallonNull;
import edu.fiuba.algoChess.Modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.Modelo.entorno.*;
import edu.fiuba.algoChess.Modelo.rangos.Rango;
import edu.fiuba.algoChess.Modelo.salud.SaludMuerto;

import java.util.ArrayList;

public class PiezaNull extends Pieza {

    public PiezaNull(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public PiezaNull() {
        this.vida = new SaludMuerto();
        this.costo = 0;
        this.ubicacion = null;
        this.bando = null;
        this.rango = null;
        }

    @Override
    public void pisar(Celda celda, Pieza piezaAGuardar){
        celda.ubicar(piezaAGuardar);
    }

    @Override
    public Rango actualizaRango(Tablero tablero) {
        return null;
    }

    @Override
    public Rango getRango() {
        return null;
    }

    @Override
    public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
        return stackDeUnion;
    }

    @Override
    public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack){
        if (stack == null){
            ArrayList<Pieza> nuevoStack = new ArrayList<Pieza>();
            return  nuevoStack;
        }
        return stack;
    }

    @Override
    public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack, Pieza pieza){
        if (stack == null){
            ArrayList<Pieza> nuevoStack = new ArrayList<Pieza>();
            return  nuevoStack;
        }
        return stack;
    }

    @Override
    public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack){
        if (stack == null){
            ArrayList<Pieza> nuevoStack = new ArrayList<Pieza>();
            return  nuevoStack;
        }
        return stack;
    }

    @Override
    public ArrayList<Pieza> getSoldadosContiguos() {
        return null;
    }

    @Override
    public boolean soldadosInmediatosSePuedenUnir() {
        return false;
    }

    @Override
    public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
    }

    @Override
    public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
    }

    @Override
    public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {

    }
    @Override
    public void atacar(Pieza atacado) {

    }

    @Override
    public void curar(Pieza curado) {

    }

    public void recibirAtaque(Ataque ataque){
    // lanza exception "no se puede atacar a casillero vacio
    }

    @Override
    public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
        return new BatallonNull();
    }

    @Override
    public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
        return new BatallonNull();
    }

    @Override
    public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
        return new BatallonNull();
    }

    @Override
    public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
        return new BatallonNull();
    }

    @Override
    public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
        return new BatallonNull();
    }
    @Override
    public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {

    }

    public boolean bandoAliado(Bando bando){
        return false;
    }

    public boolean bandoEnemigo(Bando bando){
        return false;
    }

}
