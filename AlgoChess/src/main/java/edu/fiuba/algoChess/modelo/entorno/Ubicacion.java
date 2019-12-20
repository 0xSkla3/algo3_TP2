package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.entidades.Jinete;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import lombok.Getter;

import java.util.Objects;

public class Ubicacion {
	@Getter
	private final int x;

	@Getter
	private final int y;

	private ObservadorTablero observable = new ObservadorTablero();

	public Ubicacion(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public boolean equals(Object o) {
		Ubicacion ubicacion = (Ubicacion) o;
		return (x == ubicacion.x && y == ubicacion.y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	public Ubicacion getUbicacionDerecha() {
		return new Ubicacion(this.x + 1, this.y);
	}

	public Ubicacion getUbicacionIzquierda() {
		return new Ubicacion(this.x - 1, this.y);
	}

	public Ubicacion getUbicacionArriba() {
		return new Ubicacion(this.x, this.y + 1);
	}

	public Ubicacion getUbicacionAbajo() {
		return new Ubicacion(this.x, this.y - 1);
	}

	public int getCoordenadaX() {
		return this.x;
	}

	public int getCoordenadaY() {
		return this.y;
	}

	public Celda obtenerCelda(Ubicacion ubicacion) {
		return this.observable.obtenerCelda(ubicacion);
	}

	public ObservadorTablero getObservable() {
		return this.observable;
	}



	public void reconocerTerrenoParaAtacarADistanciaMedia(Jinete jinete, int distanciaAReconocerEnTerreno, Ubicacion ubicacionJinete, Bando jineteBando) {
		reconocerEnemigoAXDistancia(jinete, distanciaAReconocerEnTerreno, ubicacionJinete, jineteBando);
		reconocerAliadoAXDistancia(jinete, distanciaAReconocerEnTerreno, ubicacionJinete, jineteBando);
	}

	private void reconocerEnemigoAXDistancia(Jinete jinete, int distanciaAReconocerEnTerreno ,Ubicacion ubicacionJinete, Bando jineteBando) {

		int coordenadaXJinete = ubicacionJinete.x;
		int coordenadaYJinete = ubicacionJinete.y;

		for (int i = coordenadaXJinete - distanciaAReconocerEnTerreno; i <= coordenadaXJinete + distanciaAReconocerEnTerreno; i++) {
			for (int j = coordenadaYJinete - distanciaAReconocerEnTerreno; j <= coordenadaYJinete + distanciaAReconocerEnTerreno; j++) {
					if ((j < 1 || i < 1) || (j > 20 || i > 20)) {
						continue;
					}
				Ubicacion ubicacion = new Ubicacion(i, j);

				if (ubicacion.equals(ubicacionJinete)) {
					continue;
				}
					Celda celda = obtenerCelda(ubicacion);
				try {

					celda.obtenerBandoDePieza().jineteReconocerEnemigoParaAtacarADistanciaMedia(jinete, jineteBando);

				} catch (NullPointerException ex){
					continue;

				}

			}
		}
	}

	private void reconocerAliadoAXDistancia(Jinete jinete, int distanciaAReconocerEnTerreno ,Ubicacion ubicacionJinete, Bando jineteBando) {

		int coordenadaXJinete = ubicacionJinete.x;
		int coordenadaYJinete = ubicacionJinete.y;

		for (int i = coordenadaXJinete - distanciaAReconocerEnTerreno; i <= coordenadaXJinete + distanciaAReconocerEnTerreno; i++) {

			for (int j = coordenadaYJinete - distanciaAReconocerEnTerreno; j <= coordenadaYJinete + distanciaAReconocerEnTerreno; j++) {
				if ((j < 1 || i < 1) || (j > 20 || i > 20)) {
					continue;
				}
				Ubicacion ubicacion = new Ubicacion(i, j);

				if (ubicacion.equals(ubicacionJinete)) {
					continue;
				}
					Celda celda = obtenerCelda(ubicacion);
				try {
					celda.obtenerBandoDePieza().jineteReconocerAliadoParaAtacarADistanciaMedia(jinete, jineteBando);

				} catch (NullPointerException ex){
					continue;
				}

			}
		}
	}



	public Pieza obtenerPieza(Ubicacion ubicacion) {
		return this.observable.obtenerPieza(ubicacion);
	}
}

