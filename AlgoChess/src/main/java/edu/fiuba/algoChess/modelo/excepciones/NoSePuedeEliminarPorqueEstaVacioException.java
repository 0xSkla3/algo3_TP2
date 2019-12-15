package edu.fiuba.algoChess.modelo.excepciones;


public class NoSePuedeEliminarPorqueEstaVacioException extends RuntimeException {
    public NoSePuedeEliminarPorqueEstaVacioException(String s) {
        super(s);
    }
}