package edu.fiuba.algoChess.bandos;

import edu.fiuba.algoChess.comportamientos.Comportamiento;
import edu.fiuba.algoChess.entidades.Pieza;

public abstract class Bando {

    public abstract void atacar(Pieza pieza, Comportamiento comportamiento, Bando bando);
    public abstract void atacar(Pieza pieza, Comportamiento comportamiento, BandoJugador1 bandojugador1);
    public abstract void atacar(Pieza pieza, Comportamiento comportamiento, BandoJugador2 bandojugador2);

    public abstract void curar(Pieza pieza, Comportamiento comportamiento, Bando bando);
    public abstract void curar(Pieza pieza, Comportamiento comportamiento, BandoJugador1 bandojugador1);
    public abstract void curar(Pieza pieza, Comportamiento comportamiento, BandoJugador2 bandojugador2);

    public abstract boolean bandoAliado(Bando bando);
    public abstract boolean bandoAliado(BandoJugador1 bando);
    public abstract boolean bandoAliado(BandoJugador2 bando);


    public abstract boolean bandoEnemigo(Bando bando);
    public abstract boolean bandoEnemigo(BandoJugador1 bando);
    public abstract boolean bandoEnemigo(BandoJugador2 bando);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bando bando = (Bando) o;
        return this.getClass() == o.getClass();
    }

}

