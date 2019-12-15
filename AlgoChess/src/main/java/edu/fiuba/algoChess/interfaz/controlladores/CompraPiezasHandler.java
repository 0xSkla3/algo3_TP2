package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.modelo.juego.Juego;
import lombok.Getter;
import lombok.Setter;

public class CompraPiezasHandler {

	@Getter
	@Setter
	Juego juego;

	@Getter
	@Setter
	boolean jugador1 = true;

	//luego cambiar, les puse 5 para que el first stage termine pronto
	@Getter
	@Setter
	int creditosJugador1 = 5;

	@Getter
	@Setter
	int creditosJugador2 = 5;

	public CompraPiezasHandler(Juego juego){
		this.juego = juego;
	}

	public void comprarPieza(String nombre){

		if (this.jugador1 && creditosJugador1 > 0) {

			if (nombre.contains("Soldado")) {
				this.creditosJugador1 = creditosJugador1 - 1;
			}

			if (nombre.contains("Catapulta")) {
				this.creditosJugador1 = creditosJugador1 - 5;
			}

			if (nombre.contains("Jinete")) {
				this.creditosJugador1 = creditosJugador1 - 3;
			}

			if (nombre.contains("Curandero")) {
				this.creditosJugador1 = creditosJugador1 - 2;
			}
		} else if(creditosJugador2 > 0) {

			if (nombre.contains("Soldado")) {
				this.creditosJugador2 = creditosJugador2 - 1;
			}

			if (nombre.contains("Catapulta")) {
				this.creditosJugador2 = creditosJugador2 - 5;
			}

			if (nombre.contains("Jinete")) {
				this.creditosJugador2 = creditosJugador2 - 3;
			}

			if (nombre.contains("Curandero")) {
				this.creditosJugador2 = creditosJugador2 - 2;
			}
		}

	}



}
