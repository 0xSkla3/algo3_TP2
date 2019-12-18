package edu.fiuba.algoChess.modelo.excepciones;

public class CeldaYaOcupadaException extends RuntimeException {
    public CeldaYaOcupadaException(String s) {
        super(s);
    }
}