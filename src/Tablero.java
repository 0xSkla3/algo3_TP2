import org.jetbrains.annotations.Contract;

public class Tablero {

	private Celda[][]  campoDeBatalla;
	private Celda celdaActiva;
	private Jugador jugadorActivo;

	public void Tablero() {
		this.campoDeBatalla = new Celda[20][20];
		this.celdaActiva = new Celda();
		this.jugadorActivo = new Jugador();

	}

	public void moverFicha(Celda nuevaActiva) {
		this.celdaActiva.setVacia(true);
		this.celdaActiva = nuevaActiva;
	}

}
