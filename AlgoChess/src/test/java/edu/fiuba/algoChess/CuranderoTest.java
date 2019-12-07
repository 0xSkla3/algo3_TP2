package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.comportamientos.AtaqueMedioJinete;
import edu.fiuba.algoChess.Modelo.comportamientos.Comportamiento;
import edu.fiuba.algoChess.Modelo.entidades.Catapulta;
import edu.fiuba.algoChess.Modelo.entidades.Curandero;
import edu.fiuba.algoChess.Modelo.entidades.Soldado;
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
        Ubicacion ubicacionSoldado = new Ubicacion(1,3);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1);
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);
        Comportamiento comportamiento = new AtaqueMedioJinete(15);
        soldado.recibirAtaque(comportamiento.getValorComportamiento());
        int vidaSoldadoCurado = soldado.getVida().getValorActual() + curandero.getCuracion().getValorComportamiento();
        curandero.curar(soldado);
        assertEquals(vidaSoldadoCurado,soldado.getVida().getValorActual());
    };

    @Test (expected = NoSePuedeCurarUnaUnidadEnemigaException.class)
    public void test02SeLanzaExceptionCuandoCuranderoIntentaCurarSoldadoEnemigoCercano(){
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Ubicacion ubicacionSoldado = new Ubicacion(1,3);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1);
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador2);
        Comportamiento comportamiento = new AtaqueMedioJinete(15);
        soldado.recibirAtaque(comportamiento.getValorComportamiento());
        curandero.curar(soldado);
    };


    @Test (expected = FueraDeRangoParaEjecutarComportamientoException.class)
    public void test03SeLanzaExceptionCuandoCuranderoIntentaCurarSoldadoAliadoLejano(){
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        Ubicacion ubicacionSoldado = new Ubicacion(1,8);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1);
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);
        Comportamiento comportamiento = new AtaqueMedioJinete(15);
        soldado.recibirAtaque(comportamiento.getValorComportamiento());
        curandero.curar(soldado);
    };
    @Test (expected = NoSePuedeCurarUnaCatapultaException.class)
    public void test04SeLanzaExceptionCuandoCuranderoIntentaCurarUnaCatapulta(){
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        Ubicacion ubicacionCatapulta = new Ubicacion(1,3);
        Catapulta catapulta = new Catapulta(ubicacionCatapulta,bandoJugador1);
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);
        Comportamiento comportamiento = new AtaqueMedioJinete(15);
        catapulta.recibirAtaque(comportamiento.getValorComportamiento());
        curandero.curar(catapulta);
    };

}