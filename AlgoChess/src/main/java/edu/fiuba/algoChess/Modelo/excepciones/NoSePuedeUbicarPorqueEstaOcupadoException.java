package edu.fiuba.algoChess.Modelo.excepciones;

public class NoSePuedeUbicarPorqueEstaOcupadoException extends RuntimeException {
    public NoSePuedeUbicarPorqueEstaOcupadoException(String s) {
        super(s);
    }
}