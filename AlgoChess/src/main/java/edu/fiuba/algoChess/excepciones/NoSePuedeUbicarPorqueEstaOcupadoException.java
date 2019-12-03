package edu.fiuba.algoChess.excepciones;

public class NoSePuedeUbicarPorqueEstaOcupadoException extends RuntimeException {
    public NoSePuedeUbicarPorqueEstaOcupadoException(String s) {
        super(s);
    }
}