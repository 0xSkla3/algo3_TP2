package edu.fiuba.algoChess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CuranderoTest {

    @Test
    public void test00CuranderoPuedeCurarSoldadoAliadoCercano(){
        Jugador jugadorAliado = new Jugador();
        Soldado soldado = new Soldado();
        Ubicacion ubicacionSoldado = new Ubicacion(1,1);
        soldado.setUbicacion(ubicacionSoldado);
        soldado.setJugador(jugadorAliado);
        Curandero curandero = new Curandero();
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        curandero.setUbicacion(ubicacionCurandero);
        curandero.setJugador(jugadorAliado);
        DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldado);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        int vidaTrasCuracion = soldado.getVida() + curandero.getSanacion();
        curandero.ejecutarComportamiento(distanciaSoldadoACurandero,soldado);
        assertEquals(vidaTrasCuracion,soldado.getVida());
    };

    @Test
    public void test01CuranderoNoPuedeCurarSoldadoLejano(){
        Soldado soldado = new Soldado();
        Ubicacion ubicacionSoldado = new Ubicacion(1,10);
        soldado.setUbicacion(ubicacionSoldado);
        Curandero curandero = new Curandero();
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        curandero.setUbicacion(ubicacionCurandero);
        DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldado);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        int vidaSoldadoSinSerAlcanzadoPorCuracion = soldado.getVida();
        curandero.ejecutarComportamiento(distanciaSoldadoACurandero,soldado);
        assertEquals(vidaSoldadoSinSerAlcanzadoPorCuracion,soldado.getVida());
    };

    @Test
    public void test02CuranderoNoPuedeCurarCatapultaCercana(){
        Catapulta catapulta = new Catapulta();
        Ubicacion ubicacionCatapulta = new Ubicacion(1,1);
        catapulta.setUbicacion(ubicacionCatapulta);
        Curandero curandero = new Curandero();
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        curandero.setUbicacion(ubicacionCurandero);
        DistanciaRelativa distanciaCatapultaACurandero = curandero.getDistanciaRelativa(catapulta);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        int vidaCatapultaSinSerAlcanzadoPorCuracion = catapulta.getVida();
        curandero.ejecutarComportamiento(distanciaCatapultaACurandero,catapulta);
        assertEquals(vidaCatapultaSinSerAlcanzadoPorCuracion,catapulta.getVida());
    };

    @Test
    public void test03CuranderoNoPuedeCurarCatapultaLejana(){
        Catapulta catapulta = new Catapulta();
        Ubicacion ubicacionCatapulta = new Ubicacion(1,9);
        catapulta.setUbicacion(ubicacionCatapulta);
        Curandero curandero = new Curandero();
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        curandero.setUbicacion(ubicacionCurandero);
        DistanciaRelativa distanciaCatapultaACurandero = curandero.getDistanciaRelativa(catapulta);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        int vidaCatapultaSinSerAlcanzadoPorCuracion = catapulta.getVida();
        curandero.ejecutarComportamiento(distanciaCatapultaACurandero,catapulta);
        assertEquals(vidaCatapultaSinSerAlcanzadoPorCuracion,catapulta.getVida());
    };

    @Test
    public void test04CuranderoNoPuedeCurarSoldadoEnemigoCercano(){
        Jugador jugadorAliado = new Jugador();
        Jugador jugadorEnemigo = new Jugador();
        Soldado soldadoEnemigo = new Soldado();
        Ubicacion ubicacionSoldado = new Ubicacion(1,1);
        soldadoEnemigo.setUbicacion(ubicacionSoldado);
        soldadoEnemigo.setJugador(jugadorEnemigo);
        Curandero curandero = new Curandero();
        Ubicacion ubicacionCurandero = new Ubicacion(1,2);
        curandero.setUbicacion(ubicacionCurandero);
        curandero.setJugador(jugadorAliado);
        DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldadoEnemigo);
        //	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
        int vidaTrasCuracion = soldadoEnemigo.getVida();
        curandero.ejecutarComportamiento(distanciaSoldadoACurandero,soldadoEnemigo);
        assertEquals(vidaTrasCuracion,soldadoEnemigo.getVida());
    };


}
