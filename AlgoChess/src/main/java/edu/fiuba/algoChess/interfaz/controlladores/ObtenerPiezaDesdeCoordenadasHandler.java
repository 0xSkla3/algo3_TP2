package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import lombok.Getter;
import lombok.Setter;

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
