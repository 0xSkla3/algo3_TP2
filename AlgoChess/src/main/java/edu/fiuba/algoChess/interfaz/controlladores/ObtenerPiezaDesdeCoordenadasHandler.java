package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.juego.Juego;
import lombok.Getter;

public class ObtenerPiezaDesdeCoordenadasHandler {

	Juego juego;
	Ubicacion ubicacionPiezaObjetivo;
	@Getter
	Pieza piezaObjetivo;

	public ObtenerPiezaDesdeCoordenadasHandler(Juego juego, int x, int y){
		this.juego = juego;
		this.ubicacionPiezaObjetivo = new Ubicacion(x,y);
		this.piezaObjetivo = juego.obtenerPiezaAPartirDeUbicacion(this.ubicacionPiezaObjetivo);
	}

}
