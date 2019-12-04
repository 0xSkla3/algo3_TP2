package edu.fiuba.algoChess.entorno;

import edu.fiuba.algoChess.entidades.Pieza;

public class DistanciaMedia extends DistanciaRelativa {

    @Override
    public void ejecutarComportamientoPorDistancia(Pieza atacante, Pieza atacado) {
        atacante.ejecutarComportamientoPorDistancia(this, atacado);
    }
}
