package edu.fiuba.algoChess;

public class PiezaNull extends Pieza {

    public PiezaNull(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public PiezaNull() {

    }

    @Override
    public void pisar(Celda celda, Pieza piezaAGuardar){
        celda.guardar(piezaAGuardar);
    }

    public void recibirAtaque(Ataque ataque){
    // lanza exception "no se puede atacar a casillero vacio
    }
}
