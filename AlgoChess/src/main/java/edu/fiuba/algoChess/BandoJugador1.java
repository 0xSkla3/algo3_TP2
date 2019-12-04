package edu.fiuba.algoChess;

import edu.fiuba.algoChess.excepciones.NoSePuedeAtacarUnAliadoException;
import edu.fiuba.algoChess.excepciones.NoSePuedeCurarUnaCatapultaException;
import edu.fiuba.algoChess.excepciones.NoSePuedeCurarUnaUnidadEnemigaException;

public class BandoJugador1 extends Bando{


    @Override
    public void atacar(Pieza pieza, Comportamiento comportamiento, Bando bando){

        bando.atacar(pieza, comportamiento, this);
    };

    @Override
    public void atacar(Pieza pieza, Comportamiento comportamiento, BandoJugador1 bandojugador1){
        throw new NoSePuedeAtacarUnAliadoException("No se puede atacar un aliado");
    };

    @Override
    public void atacar(Pieza pieza, Comportamiento comportamiento, BandoJugador2 bandojugador2){
        pieza.recibirAtaque(comportamiento.getValorComportamiento());
    }

    @Override
    public void curar(Pieza pieza, Comportamiento comportamiento, Bando bando) {
        if (!(pieza instanceof Catapulta)){
            bando.curar(pieza, comportamiento, this);
        }
        else {
            throw new NoSePuedeCurarUnaCatapultaException("No se puede curar una catapulta");
        }
    };

    @Override
    public void curar(Pieza pieza, Comportamiento comportamiento, BandoJugador1 bandojugador1){
        pieza.aumentarVida(comportamiento.getValorComportamiento());
    }

    @Override
    public void curar(Pieza pieza, Comportamiento comportamiento, BandoJugador2 bandojugador2){
        throw new NoSePuedeCurarUnaUnidadEnemigaException("No se puede curar un enemigo");
    }



}
