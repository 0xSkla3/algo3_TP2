package edu.fiuba.algoChess.modelo.excepciones;

public class NoSePuedeUbicarPorqueEstaOcupadoException extends RuntimeException {
    public NoSePuedeUbicarPorqueEstaOcupadoException(String s) {
        super(s);
    }
}