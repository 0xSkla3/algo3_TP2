package edu.fiuba.algoChess.Modelo.juego;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;

public class EstadoFaseInicial extends EstadoJuego {

    @Override
    public void ubicarEnCelda(Pieza pieza, Ubicacion ubicacion, Tablero tablero) {
        tablero.ubicarEnCeldaFaseInicial(pieza, ubicacion);

    }
}
