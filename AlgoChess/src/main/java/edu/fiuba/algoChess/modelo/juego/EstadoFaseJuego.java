package edu.fiuba.algoChess.modelo.juego;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;

public class EstadoFaseJuego extends EstadoJuego {


    @Override
    public void ubicarEnCelda(Pieza pieza, Ubicacion ubicacion, Tablero tablero) {
        tablero.ubicarEnCeldaFaseJuego(pieza, ubicacion);
    }
}
