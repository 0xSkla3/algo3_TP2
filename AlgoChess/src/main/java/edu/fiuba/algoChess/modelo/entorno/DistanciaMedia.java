package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.entidades.Pieza;

public class DistanciaMedia extends DistanciaRelativa {

    @Override
    public void ejecutarComportamientoPorDistancia(Pieza atacante, Pieza atacado) {
        atacante.ejecutarComportamientoPorDistancia(this, atacado);
    }
}
