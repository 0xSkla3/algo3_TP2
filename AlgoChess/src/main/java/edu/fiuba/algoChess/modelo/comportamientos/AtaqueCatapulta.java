package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaException;

import java.util.concurrent.CopyOnWriteArrayList;

public class AtaqueCatapulta extends Comportamiento{

    private double danio;
    private CopyOnWriteArrayList<Pieza> atacados;
    private CopyOnWriteArrayList<Pieza> aAtacar;

    public AtaqueCatapulta(double danio) {
        super(danio);
    }

    public void atacar(Pieza pieza){

        atacados = new CopyOnWriteArrayList<>();
        aAtacar = new CopyOnWriteArrayList<>();
        aAtacar.add(pieza);
       // pieza.recibirAtaque(danio);
        //atacados.add(pieza);
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
    }

    public double getDanio(){
        return danio;
    }


}

