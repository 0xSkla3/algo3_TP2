package edu.fiuba.algoChess.modelo.excepciones;

public class NoPuedeInteractuarseConAlgoNoVivo extends RuntimeException {
    public NoPuedeInteractuarseConAlgoNoVivo(String s) { super(s); }
}