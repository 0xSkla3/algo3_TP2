package edu.fiuba.algoChess;



public abstract class Bando {

    public abstract void atacar(Pieza pieza, Ataque ataque, Bando bando);

    public abstract void atacar(Pieza pieza, Ataque ataque, BandoJugador1 bandojugador1);

    public abstract void atacar(Pieza pieza, Ataque ataque, BandoJugador2 bandojugador2);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bando bando = (Bando) o;
        return this.getClass() == o.getClass();
    }

}
