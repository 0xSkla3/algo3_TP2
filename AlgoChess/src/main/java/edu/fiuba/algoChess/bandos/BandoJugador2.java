package edu.fiuba.algoChess.bandos;

import edu.fiuba.algoChess.comportamientos.Comportamiento;
import edu.fiuba.algoChess.entidades.Catapulta;
import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.excepciones.NoSePuedeAtacarUnAliadoException;
import edu.fiuba.algoChess.excepciones.NoSePuedeCurarUnaCatapultaException;
import edu.fiuba.algoChess.excepciones.NoSePuedeCurarUnaUnidadEnemigaException;

public class BandoJugador2 extends Bando {

    @Override
    public void atacar(Pieza pieza, Comportamiento comportamiento, Bando bando){
        bando.atacar(pieza, comportamiento, this);
    }

    @Override
    public void atacar(Pieza pieza, Comportamiento comportamiento, BandoJugador1 bandojugador1){
        pieza.recibirAtaque(comportamiento.getValorComportamiento());
    }

    @Override
    public void atacar(Pieza pieza, Comportamiento comportamiento, BandoJugador2 bandojugador2){
        throw new NoSePuedeAtacarUnAliadoException("No se puede atacar un aliado");
    }

    @Override
    public void curar(Pieza pieza, Comportamiento comportamiento, Bando bando){
        if (!(pieza instanceof Catapulta)){
            bando.curar(pieza, comportamiento, this);
        }
        else {
            throw new NoSePuedeCurarUnaCatapultaException("No se puede curar una catapulta");
        }
    }

    @Override
    public void curar(Pieza pieza, Comportamiento comportamiento, BandoJugador2 bandojugador2){
        pieza.aumentarVida(comportamiento.getValorComportamiento());
    }

    @Override
    public void curar(Pieza pieza, Comportamiento comportamiento, BandoJugador1 bandojugador1){
        throw new NoSePuedeCurarUnaUnidadEnemigaException("No se puede curar un enemigo");
    }

    @Override
    public boolean bandoAliado(Bando bando) { return bando.bandoAliado(this); }

    @Override
    public boolean bandoAliado(BandoJugador1 bando) { return false; }

    @Override
    public boolean bandoAliado(BandoJugador2 bando) { return true; }

    @Override
    public boolean bandoEnemigo(Bando bando) { return bando.bandoEnemigo(this); }

    @Override
    public boolean bandoEnemigo(BandoJugador1 bando) { return true; }

    @Override
    public boolean bandoEnemigo(BandoJugador2 bando) { return false; }

}
