package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.entidades.*;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.interfaz.vista.*;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class UbicarEnMapa {
	private Pieza pieza;
	private Tablero tablero;
	private VistaTablero mapView;

	public UbicarEnMapa(Pieza unidad, Tablero tablero, VistaTablero mapView) {
		this.pieza = unidad;
		this.tablero = tablero;
		this.mapView = mapView;
	}

	public void handle(MouseEvent mouseEvent) {
		int x = (int) mouseEvent.getX() / 32;
		int y = (int) mouseEvent.getY() / 32;

		try {
			if(pieza != null) {
				tablero.ubicarEnCeldaFaseInicial(pieza, new Ubicacion(x, y));

				if (pieza.getClass() == Soldado.class) {
					new SoldadoView(mapView, pieza);
				} else if (pieza.getClass() == Jinete.class) {
					new JineteView(mapView, pieza);
				} else if (pieza.getClass() == Curandero.class) {
					new CuranderoView(mapView, pieza);
				} else {
					new CatapultaView(mapView, pieza);
				}

				//Cambiar de turno

				pieza = new PiezaNull();
			}
		} catch(RuntimeException e) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.showAndWait();
		}
	}

}
