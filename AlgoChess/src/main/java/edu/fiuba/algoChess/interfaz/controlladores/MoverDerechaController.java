package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.interfaz.vista.MapView;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MoverDerechaController implements EventHandler<MouseEvent> {
	private Pieza pieza;
	private Tablero tablero;
	private MapView map;
	private ImageView imagenPieza;

	public MoverDerechaController(Pieza pieza, Tablero tablero, MapView map, ImageView imagenPieza) {
		this.pieza = pieza;
		this.tablero = tablero;
		this.map = map;
		this.imagenPieza = imagenPieza;
	}

	public void handle(MouseEvent mouseEvent) {
		pieza.moverseALaDerecha(tablero);
		moverDerecha(imagenPieza, map, pieza.getUbicacion().getCoordenadaX(), pieza.getUbicacion().getCoordenadaY());
	}

	public void moverDerecha(ImageView imagenPieza, MapView map, int x, int y ){

		DropShadow rollOverColor = new DropShadow();
		imagenPieza.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> imagenPieza.setEffect(rollOverColor));
		imagenPieza.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> imagenPieza.setEffect(null));

		map.addViewOnMap(imagenPieza, x+1, y);

	}
}
