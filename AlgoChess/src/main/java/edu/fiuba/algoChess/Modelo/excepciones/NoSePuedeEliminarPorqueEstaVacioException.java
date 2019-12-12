package edu.fiuba.algoChess.Modelo.excepciones;


public class NoSePuedeEliminarPorqueEstaVacioException extends RuntimeException {
    public NoSePuedeEliminarPorqueEstaVacioException(String s) {
        super(s);
    }
}