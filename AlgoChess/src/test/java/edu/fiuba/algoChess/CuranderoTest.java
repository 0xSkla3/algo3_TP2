package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Salud.Salud;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CuranderoTest {

    // este test deberia dar expection, una pieza no puede tener mas que su vida maxima
    @Test
    public void test00CuranderoPuedeCurarSoldadoAliadoCercano(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();

        Ubicacion ubicacionSoldado = new Ubicacion(1,1);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1);

        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);

        DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldado);
        Salud vidaTrasCuracion = soldado.getVida();
        curandero.curar(distanciaSoldadoACurandero,soldado);

        assertEquals(vidaTrasCuracion,soldado.getVida());
    };

    @Test
    public void test01CuranderoNoPuedeCurarSoldadoLejano(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        Ubicacion ubicacionSoldado = new Ubicacion(1,10);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1);

        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);

        DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldado);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        Salud vidaSoldadoSinSerAlcanzadoPorCuracion = soldado.getVida();
        curandero.curar(distanciaSoldadoACurandero,soldado);
        assertEquals(vidaSoldadoSinSerAlcanzadoPorCuracion,soldado.getVida());
    };

    @Test
    public void test02CuranderoNoPuedeCurarCatapultaCercana(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        Ubicacion ubicacionCatapulta = new Ubicacion(1,1);
        Catapulta catapulta = new Catapulta(ubicacionCatapulta,bandoJugador1);

        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);

        DistanciaRelativa distanciaCatapultaACurandero = curandero.getDistanciaRelativa(catapulta);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        Salud vidaCatapultaSinSerAlcanzadoPorCuracion = catapulta.getVida();
        curandero.curar(distanciaCatapultaACurandero,catapulta);
        assertEquals(vidaCatapultaSinSerAlcanzadoPorCuracion,catapulta.getVida());
    };

    @Test
    public void test03CuranderoNoPuedeCurarCatapultaLejana(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        Ubicacion ubicacionCatapulta = new Ubicacion(1,9);
        Catapulta catapulta = new Catapulta(ubicacionCatapulta,bandoJugador1);

        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);

        DistanciaRelativa distanciaCatapultaACurandero = curandero.getDistanciaRelativa(catapulta);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        Salud vidaCatapultaSinSerAlcanzadoPorCuracion = catapulta.getVida();
        curandero.curar(distanciaCatapultaACurandero,catapulta);
        assertEquals(vidaCatapultaSinSerAlcanzadoPorCuracion,catapulta.getVida());
    };

    @Test
    public void test04CuranderoNoPuedeCurarSoldadoEnemigoCercano(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();

        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);

        Ubicacion ubicacionSoldado = new Ubicacion(1,1);
        Soldado soldadoEnemigo = new Soldado(ubicacionSoldado,bandoJugador2);

        DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldadoEnemigo);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        Salud vidaTrasCuracion = soldadoEnemigo.getVida();
        curandero.curar(distanciaSoldadoACurandero,soldadoEnemigo);
        assertEquals(vidaTrasCuracion,soldadoEnemigo.getVida());
    };


}
