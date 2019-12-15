package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.comportamientos.AtaqueNormal;
import edu.fiuba.algoChess.Modelo.entidades.Catapulta;
import edu.fiuba.algoChess.Modelo.entidades.Curandero;
import edu.fiuba.algoChess.Modelo.entidades.Soldado;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeCurarUnaCatapultaException;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeCurarUnaUnidadEnemigaException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CuranderoTest {

    @Test
    public void test01CuranderoPuedeCurarSoldadoAliadoCercano(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tablero = new Tablero(bandoJugador1,bandoJugador2);

        Ubicacion ubicacionSoldado = new Ubicacion(6,6);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1,tablero);

        Ubicacion ubicacionCurandero = new Ubicacion(5,6);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1,tablero);

        AtaqueNormal ataqueNormal = new AtaqueNormal(15);
        soldado.recibirAtaque(ataqueNormal);
        double vidaSoldadoCurado = soldado.getVida().getValorActual() + curandero.getCuracion().getValorCuracion();
        curandero.curar(soldado);
        assertEquals(vidaSoldadoCurado,soldado.getVida().getValorActual(), 0.0);
    }

    @Test (expected = NoSePuedeCurarUnaUnidadEnemigaException.class)
    public void test02SeLanzaExceptionCuandoCuranderoIntentaCurarSoldadoEnemigoCercano(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tablero = new Tablero(bandoJugador1,bandoJugador2);

        Ubicacion ubicacionSoldado = new Ubicacion(10,3);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1,tablero);
        Ubicacion ubicacionCurandero = new Ubicacion(11,3);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador2,tablero);

        AtaqueNormal ataqueNormal = new AtaqueNormal(15);
        soldado.recibirAtaque(ataqueNormal);
        curandero.curar(soldado);
    }

    @Test (expected = FueraDeRangoParaEjecutarComportamientoException.class)
    public void test03SeLanzaExceptionCuandoCuranderoIntentaCurarSoldadoAliadoLejano(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tablero = new Tablero(bandoJugador1,bandoJugador2);

        Ubicacion ubicacionSoldado = new Ubicacion(5,5);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1,tablero);

        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1,tablero);

        AtaqueNormal ataqueNormal = new AtaqueNormal(15);
        soldado.recibirAtaque(ataqueNormal);
        curandero.curar(soldado);
    }

    @Test (expected = NoSePuedeCurarUnaCatapultaException.class)
    public void test04SeLanzaExceptionCuandoCuranderoIntentaCurarUnaCatapulta(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tablero = new Tablero(bandoJugador1,bandoJugador2);

        Ubicacion ubicacionCatapulta = new Ubicacion(1,3);
        Catapulta catapulta = new Catapulta(ubicacionCatapulta,bandoJugador1,tablero);

        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1,tablero);

        AtaqueNormal ataqueNormal = new AtaqueNormal(15);
        catapulta.recibirAtaque(ataqueNormal);
        curandero.curar(catapulta);
    }

}