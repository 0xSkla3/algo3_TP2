package edu.fiuba.algoChess.interfaz.vista;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SaludView extends Rectangle {
	private static final int ANCHO_BARRA = 35;
	private static final int ALTO_BARRA = 3;
	private static final int X_BARRA = 5;
	private static final int Y_BARRA = 1;
	private double vidaMax;

	public SaludView(double vidaMax) {
		this.vidaMax = vidaMax;
		double vidaActual = vidaMax;

		setWidth(vidaActual / vidaMax * ANCHO_BARRA);
		setHeight(ALTO_BARRA);
		setX(X_BARRA);
		setY(Y_BARRA);
		setFill(Color.GREEN);
	}

	public void actualizarBarra(double vidaActual) {
		setWidth(vidaActual / vidaMax * ANCHO_BARRA);
	}
}