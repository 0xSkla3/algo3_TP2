package edu.fiuba.algoChess;

public class BandoJugador2 extends Bando {

    @Override
    public void atacar(Pieza pieza, Ataque ataque, Bando bando){
        bando.atacar(pieza, ataque, this);
    };

    @Override
    public void atacar(Pieza pieza, Ataque ataque, BandoJugador1 bandojugador1){
        pieza.recibirAtaque(ataque);
    };

    @Override
    public void atacar(Pieza pieza, Ataque ataque, BandoJugador2 bandojugador2){
        //exception mismo jugador no se puede atacar
    };
}
