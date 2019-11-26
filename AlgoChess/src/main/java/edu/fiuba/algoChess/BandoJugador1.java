package edu.fiuba.algoChess;

public class BandoJugador1 extends Bando{


    @Override
    public void atacar(Pieza pieza, Ataque ataque, Bando bando){
         bando.atacar(pieza, ataque, this);
    };

    @Override
    public void atacar(Pieza pieza, Ataque ataque, BandoJugador1 bandojugador1){
        //exception mismo bando no se puede atacar
    };

    @Override
    public void atacar(Pieza pieza, Ataque ataque, BandoJugador2 bandojugador2){
        pieza.recibirAtaque(ataque);
    };

}
