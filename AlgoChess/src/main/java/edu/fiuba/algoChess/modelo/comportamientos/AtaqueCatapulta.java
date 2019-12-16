package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeAtacarPiezaNull;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;

import java.util.concurrent.CopyOnWriteArrayList;

public class AtaqueCatapulta extends Ataque{

    //private Ataque danio;
    private CopyOnWriteArrayList<Pieza> atacados;
    private CopyOnWriteArrayList<Pieza> aAtacar;

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
        }catch (NoSePuedeAtacarPiezaNull exc){

        }
    }

    public void atacarDerecha(Pieza pieza){
        try {
            pieza.recibirAtaque(this);
            this.atacarDerecha(pieza.obtenerPiezaDerecha());
        }catch (NoSePuedeAtacarPiezaNull exc){

        }
    }

    public void atacarAbajo(Pieza pieza){
        try {
            pieza.recibirAtaque(this);
            this.atacarAbajo(pieza.obtenerPiezaAbajo());
        }catch (NoSePuedeAtacarPiezaNull exc){

        }
    }

    public void atacarIzquierda(Pieza pieza){
        try {
            pieza.recibirAtaque(this);
            this.atacarIzquierda(pieza.obtenerPiezaIzquierda());
        }catch (NoSePuedeAtacarPiezaNull exc){

        }
    }

}




 /*   public void atacar(Pieza pieza){

        atacados = new CopyOnWriteArrayList<>();
        aAtacar = new CopyOnWriteArrayList<>();

        for (Pieza piezaAAtacar: aAtacar
        ) {
            if(!atacados.contains(piezaAAtacar)) {
                try {
                    piezaAAtacar.recibirAtaque(danio);
                    atacados.add(piezaAAtacar);
                    aAtacar.add(piezaAAtacar.obtenerPiezaArriba());
                    aAtacar.add(piezaAAtacar.obtenerPiezaDerecha());
                    aAtacar.add(piezaAAtacar.obtenerPiezaAbajo());
                    aAtacar.add(piezaAAtacar.obtenerPiezaIzquierda());
                }catch(OperacionInvalidaException ex){

                }
            }
        }
    }*/