public class Jugador {

	private String nombre;
	private int puntaje;


	public Jugador() {
		this.nombre = "";
	}

	public Jugador(String unNombre) {
		this.nombre = unNombre;
	}

	public String nombre() {
		return this.nombre;
	}

	public int puntaje() {
		return this.puntaje;
	}

}