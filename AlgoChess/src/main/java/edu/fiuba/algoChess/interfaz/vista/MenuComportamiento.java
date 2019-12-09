package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

public class MenuComportamiento {

	@Getter
	@Setter
	Pieza atacante;

	@Getter
	@Setter
	Pieza atacado;

	@Getter
	@Setter
	Tablero tablero;


	@Getter
	@Setter
	ImageView imageView;

	@Getter
	@Setter
	MapView mapView;


	MenuComportamiento(Pieza atacante, Pieza atacado , Tablero tablero, ImageView imagenPieza , MapView map){
		this.atacante = atacante;
		this.atacado = atacado;
		this.tablero = tablero;
		this.imageView = imagenPieza;
		this.mapView = map;
	}

	public void MenuAtaqueSoldado(){

	}

	public void MenuAtaqueBatallon(){

	}

	public void MenuAtaqueJinete(){

	}


	public void MenuAtaqueCatapulta(){

	}

}
