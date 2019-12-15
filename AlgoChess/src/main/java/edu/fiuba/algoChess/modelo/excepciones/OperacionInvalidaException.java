package edu.fiuba.algoChess.modelo.excepciones;

public class OperacionInvalidaException extends RuntimeException {
    public OperacionInvalidaException(String s) {
        super (s);
    }
}
