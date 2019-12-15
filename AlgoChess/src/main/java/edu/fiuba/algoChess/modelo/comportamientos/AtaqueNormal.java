package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entidades.Pieza;

public class AtaqueNormal extends Ataque {

    public AtaqueNormal(double danio) {
        super(danio);
    }

    @Override
    public void atacar(Pieza pieza) {
        pieza.recibirAtaque(this);
    }

}
