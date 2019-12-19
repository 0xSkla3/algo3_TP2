package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ObservadorTablero {

    static protected Tablero tablero = null;

    public void setTablero(Tablero tablero){
        this.tablero = tablero;
    }

    public Celda obtenerCelda(Ubicacion ubicacion){
        return this.tablero.getCelda(ubicacion);
    }

    public Pieza obtenerPieza(Ubicacion ubicacion){
        return this.tablero.getCelda(ubicacion).piezaActual;
    }

}