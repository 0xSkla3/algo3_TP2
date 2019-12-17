package edu.fiuba.algoChess.modelo.bandos;

import edu.fiuba.algoChess.modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.modelo.comportamientos.Curacion;
import edu.fiuba.algoChess.modelo.entidades.Jinete;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.salud.Herible;
import edu.fiuba.algoChess.modelo.salud.Salud;

import java.util.ArrayList;

public abstract class Bando {

    public abstract void atacar(Pieza pieza, Ataque ataque, Bando bando);
    public abstract void atacar(Pieza pieza, Ataque ataque, BandoJugador1 bandojugador1);
    public abstract void atacar(Pieza pieza, Ataque ataque, BandoJugador2 bandojugador2);

    public abstract void curar(Pieza pieza, Curacion curacion, Bando bando);
    public abstract void curar(Pieza pieza, Curacion curacion, BandoJugador1 bandojugador1);
    public abstract void curar(Pieza pieza, Curacion curacion, BandoJugador2 bandojugador2);

    public abstract Salud recibirAtaque(Herible salud, Ataque ataque, Bando bando);
    public abstract Salud recibirAtaque(Herible salud, Ataque ataque, BandoJugador1 bandoJugador1);
    public abstract Salud recibirAtaque(Herible salud, Ataque ataque, BandoJugador2 bandoJugador2);

    public abstract ArrayList<Pieza> aniadirSoldadoAliadoAlStack(Pieza piezaPeriferia, ArrayList<Pieza> stack, Bando bando);
    public abstract ArrayList<Pieza> aniadirSoldadoAliadoAlStack(Pieza piezaPeriferia, ArrayList<Pieza> stack, BandoJugador1 bandoJugador1);
    public abstract ArrayList<Pieza> aniadirSoldadoAliadoAlStack(Pieza piezaPeriferia, ArrayList<Pieza> stack, BandoJugador2 bandoJugador2);

    public abstract void jineteReconocerEnemigoParaAtacarADistanciaMedia(Jinete jinete, Bando bando);
    public abstract void jineteReconocerEnemigoParaAtacarADistanciaMedia(Jinete jinete, BandoJugador1 bandoJugador1);
    public abstract void jineteReconocerEnemigoParaAtacarADistanciaMedia(Jinete jinete, BandoJugador2 bandoJugador2);

    public abstract void jineteReconocerAliadoParaAtacarADistanciaMedia(Jinete jinete, Bando bando);
    public abstract void jineteReconocerAliadoParaAtacarADistanciaMedia(Jinete jinete, BandoJugador1 bandoJugador1);
    public abstract void jineteReconocerAliadoParaAtacarADistanciaMedia(Jinete jinete, BandoJugador2 bandoJugador2);

    public abstract boolean bandoAliado(Bando bando);
    public abstract boolean bandoAliado(BandoJugador1 bando);
    public abstract boolean bandoAliado(BandoJugador2 bando);

    public abstract boolean bandoEnemigo(Bando bando);
    public abstract boolean bandoEnemigo(BandoJugador1 bando);
    public abstract boolean bandoEnemigo(BandoJugador2 bando);

    public abstract String getNombre();

}
