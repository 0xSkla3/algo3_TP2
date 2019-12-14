package edu.fiuba.algoChess.Modelo.excepciones;

public class NoPuedeInteractuarseConAlgoNoVivo extends RuntimeException {
    public NoPuedeInteractuarseConAlgoNoVivo(String s) { super(s); }
}