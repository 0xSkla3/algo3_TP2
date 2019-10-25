import static org.junit.Assert.*;
import org.junit.Test;

public class JugadorTest {

	@Test
	public void jugadorTestInicializaVacio(){

		Jugador jugadorPrueba = new Jugador();
		assert(jugadorPrueba.nombre() == "" );
	}

	@Test
	public void jugadorTestCreadoConNombre(){

		Jugador jugadorPrueba = new Jugador("Ruben");
		assert(jugadorPrueba.nombre() == "Ruben" );
	}
}
