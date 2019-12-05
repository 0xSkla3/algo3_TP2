package edu.fiuba.algoChess.entidades;

import edu.fiuba.algoChess.bandos.Bando;
import edu.fiuba.algoChess.batallones.BatallonNull;
import edu.fiuba.algoChess.batallones.Batalloneable;
import edu.fiuba.algoChess.comportamientos.Ataque;
import edu.fiuba.algoChess.entorno.*;
import edu.fiuba.algoChess.rangos.Rango;
import edu.fiuba.algoChess.rangos.RangoNull;
import edu.fiuba.algoChess.salud.Salud;
import edu.fiuba.algoChess.salud.SaludMuerto;
import lombok.Getter;
import lombok.Setter;

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
    public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack){
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
}
