package edu.fiuba.algoChess.Modelo.entorno;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;

public class DistanciaCercana extends DistanciaRelativa {

    @Override
    public void ejecutarComportamientoPorDistancia(Pieza atacante, Pieza atacado) {
        atacante.ejecutarComportamientoPorDistancia(this, atacado);
    }
}
