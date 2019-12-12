package edu.fiuba.algoChess.Modelo.entorno;

import edu.fiuba.algoChess.Modelo.entidades.Jinete;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.excepciones.OperacionInvalidaException;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Ubicacion {
	@Getter
	@Setter
	private final int x;

	@Getter
	@Setter
	private final int y;

	private ObservadorTablero observable = new ObservadorTablero();

	public Ubicacion(int x, int y) {
		this.x = x;
		this.y = y;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return x == ubicacion.x && y == ubicacion.y;
    }

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	public Ubicacion getUbicacionDerecha() {
		return new Ubicacion(this.x+1, this.y);
	}
	public Ubicacion getUbicacionIzquierda() {
		return new Ubicacion(this.x-1, this.y);
	}
	public Ubicacion getUbicacionArriba() { return new Ubicacion(this.x, this.y+1);}
	public Ubicacion getUbicacionAbajo() { return new Ubicacion(this.x, this.y-1);}

	public int getCoordenadaX(){
		return this.x;
	};

	public int getCoordenadaY(){
		return this.y;
	};

	public Celda obtenerCelda(Ubicacion ubicacion){
		return this.observable.obtenerCelda(ubicacion);
	}
	public ObservadorTablero getObservable(){
		return this.observable;
	}


	public void reconocerTerrenoParaAtacarADistanciaMedia(Jinete jinete, Pieza pieza, int distanciaAReconocerEnTerreno, Ubicacion ubicacionJinete) {
		int coordenadaXJinete = ubicacionJinete.x;
		int coordenadaYJinete = ubicacionJinete.y;
		boolean piezaEnemigaCercana = false;
		boolean piezaAliadaCercana = false;

		for (int i = coordenadaXJinete - distanciaAReconocerEnTerreno; i <= coordenadaXJinete + distanciaAReconocerEnTerreno; i++) {
			if (i < 1 || i > 20) {
				continue;
			}
			for (int j = coordenadaYJinete - distanciaAReconocerEnTerreno; j <= coordenadaYJinete + distanciaAReconocerEnTerreno; j++) {
				if (j < 1 || j > 20) {
					continue;
				}
				Ubicacion ubicacion = new Ubicacion(i, j);
				if (ubicacion.equals(ubicacionJinete)) {
					continue;
				}

				Celda celda = obtenerCelda(ubicacion); //campoDeBatalla.getCelda(ubicacion);
				if ((celda.piezaBandoAliado(jinete.getBando())) ) {
					piezaAliadaCercana = true;
				} else if ((celda.piezaBandoEnemigo(jinete.getBando()))) {
					piezaEnemigaCercana = true;
				}
			}
		}

		if(piezaEnemigaCercana && !piezaAliadaCercana){

			throw new OperacionInvalidaException("Operacion invalida");

		}

		jinete.concretarAtaqueMedio(pieza);

	}

	public Pieza obtenerPieza(Ubicacion ubicacion) {
		return this.observable.obtenerPieza(ubicacion);
	}
}

