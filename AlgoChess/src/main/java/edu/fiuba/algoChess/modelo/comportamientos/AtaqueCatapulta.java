package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaSobreObjetoNuloException;


public class AtaqueCatapulta extends Ataque{

    public AtaqueCatapulta(double danio) {
        super(danio);
    }

    public void atacar(Pieza pieza) {

        pieza.recibirAtaque(this);
        this.atacarArriba(pieza.obtenerPiezaArriba());
        this.atacarDerecha(pieza.obtenerPiezaDerecha());
        this.atacarAbajo(pieza.obtenerPiezaAbajo());
        this.atacarIzquierda(pieza.obtenerPiezaIzquierda());

    }

    public void atacarArriba(Pieza pieza){
        try {
            pieza.recibirAtaque(this);
            this.atacarArriba(pieza.obtenerPiezaArriba());
        }catch (OperacionInvalidaSobreObjetoNuloException exc){

        }
    }

    public void atacarDerecha(Pieza pieza){
        try {
            pieza.recibirAtaque(this);
            this.atacarDerecha(pieza.obtenerPiezaDerecha());
        }catch (OperacionInvalidaSobreObjetoNuloException exc){

        }
    }

    public void atacarAbajo(Pieza pieza){
        try {
            pieza.recibirAtaque(this);
            this.atacarAbajo(pieza.obtenerPiezaAbajo());
        }catch (OperacionInvalidaSobreObjetoNuloException exc){

        }
    }

    public void atacarIzquierda(Pieza pieza){
        try {
            pieza.recibirAtaque(this);
            this.atacarIzquierda(pieza.obtenerPiezaIzquierda());
        }catch (OperacionInvalidaSobreObjetoNuloException exc){

        }
    }

}