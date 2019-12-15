package edu.fiuba.algoChess.Modelo.comportamientos;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;

public class AtaqueNormal extends Ataque {

    public AtaqueNormal(double danio) {
        super(danio);
    }

    @Override
    public void atacar(Pieza pieza) {
        pieza.recibirAtaque(this);
    }

}
