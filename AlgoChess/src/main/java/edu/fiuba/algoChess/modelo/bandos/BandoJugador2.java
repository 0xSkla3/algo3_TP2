package edu.fiuba.algoChess.modelo.bandos;

import edu.fiuba.algoChess.modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.modelo.comportamientos.Curacion;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeAtacarUnAliadoException;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeCurarUnaUnidadEnemigaException;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.salud.Herible;
import edu.fiuba.algoChess.modelo.salud.Salud;

public class BandoJugador2 extends Bando {

    @Override
    public void atacar(Pieza pieza, Ataque ataque, Bando bando){
        bando.atacar(pieza, ataque, this);
    }

    @Override
    public void atacar(Pieza pieza, Ataque ataque, BandoJugador1 bandojugador1){
        pieza.recibirAtaque(ataque);
    }

    @Override
    public void atacar(Pieza pieza, Ataque ataque, BandoJugador2 bandojugador2){
        throw new NoSePuedeAtacarUnAliadoException("No se puede atacar un aliado");
    }

    @Override
    public void curar(Pieza pieza, Curacion curacion, Bando bando){
        bando.curar(pieza, curacion, this);
    }

    @Override
    public void curar(Pieza pieza, Curacion curacion, BandoJugador1 bandojugador1){
        throw new NoSePuedeCurarUnaUnidadEnemigaException("No se puede curar un enemigo");
    }

    @Override
    public void curar(Pieza pieza, Curacion curacion, BandoJugador2 bandojugador2){
        pieza.aumentarVida(curacion.getValorCuracion());
    }

    @Override
    public Salud recibirAtaque(Herible herible, Ataque ataque, Bando bando) {
        return bando.recibirAtaque(herible, ataque, this);
    }

    @Override
    public Salud recibirAtaque(Herible herible, Ataque ataque, BandoJugador1 bandoJugador1) {
        return ataque.hacerDanioSectorEnemigo(herible);
    }

    @Override
    public Salud recibirAtaque(Herible herible, Ataque ataque, BandoJugador2 bandoJugador2) {
        return ataque.hacerDanioSectorAliado(herible);
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

    @Override
    public String getNombre() {
        return "jugador2";
    }

}
