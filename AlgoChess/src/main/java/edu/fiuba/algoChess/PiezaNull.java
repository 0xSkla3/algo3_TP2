package edu.fiuba.algoChess;

import java.util.ArrayList;

public class PiezaNull extends Pieza {

    public PiezaNull(Ubicacion ubicacion) {
        super(ubicacion);
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
    public void unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {

    }

    @Override
    public void aniadirPiezaAlStack(ArrayList<Pieza> stack) {

    }

    @Override
    public void aniadirSoldadoAlStack(ArrayList<Pieza> stack) {

    }

    @Override
    public void aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {

    }

    @Override
    public ArrayList<Pieza> getSoldadosContiguos() {
        return null;
    }

    @Override
    public boolean soldadosInmediatosSePuedenUnir() {
        return false;
    }

    public void recibirAtaque(Ataque ataque){
    // lanza exception "no se puede atacar a casillero vacio
    }
}
