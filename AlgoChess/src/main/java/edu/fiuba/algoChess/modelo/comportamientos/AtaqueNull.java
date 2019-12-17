package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.excepciones.AtaqueInvalidoException;

public class AtaqueNull extends Ataque{

    public AtaqueNull(double danio) {
        super(danio);
    }

    @Override
    public void atacar(Pieza pieza) {
        throw new AtaqueInvalidoException("Jinete no puede atacar a distancia por haber un enemigo cerca");
    }

}
