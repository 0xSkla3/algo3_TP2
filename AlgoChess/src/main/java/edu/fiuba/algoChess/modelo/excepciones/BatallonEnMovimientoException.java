package edu.fiuba.algoChess.modelo.excepciones;

public class BatallonEnMovimientoException extends RuntimeException {
	public BatallonEnMovimientoException(String batallon_en_movimiento) { super(batallon_en_movimiento);
	}
}
