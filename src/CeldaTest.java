import static org.junit.Assert.*;
import org.junit.Test;

public class CeldaTest {

	@Test
	public void celdaTestInicializaVacia(){

		Celda celdaPrueba = new Celda();
		assertFalse(celdaPrueba.estaVacia());
	}
}
