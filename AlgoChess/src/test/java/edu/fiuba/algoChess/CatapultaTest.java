package edu.fiuba.algoChess;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CatapultaTest {

    @Test
    public void test000CatapultaAtacaAEnemigoADistanciaMedia(){
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Ubicacion ubicacionCatapulta = new Ubicacion(11,4);
        Catapulta catapultaAliada = new Catapulta(ubicacionCatapulta,bandoJugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,1);
        Jinete jineteEnemigo = new Jinete(ubicacionJinete,bandoJugador1);
        tableroTest.ubicarEnCelda(catapultaAliada, ubicacionCatapulta);
        tableroTest.ubicarEnCelda(jineteEnemigo,ubicacionJinete);
        int vidaTrasAtaque = jineteEnemigo.getVida() - catapultaAliada.getAtaqueMedio().getValorComportamiento();
        catapultaAliada.atacar(jineteEnemigo);
        assertEquals(vidaTrasAtaque, jineteEnemigo.getVida());
    }

    @Test (expected = FueraDeRangoParaEjecutarComportamientoException.class)
    public void test001SeArrojaExceptionCuandoSeQuiereAtacarAUnEnemigoADistanciaCercana(){
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Ubicacion ubicacionCatapulta = new Ubicacion(11,1);
        Catapulta catapultaAliada = new Catapulta(ubicacionCatapulta,bandoJugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,1);
        Jinete jineteEnemigo = new Jinete(ubicacionJinete,bandoJugador1);
        tableroTest.ubicarEnCelda(catapultaAliada, ubicacionCatapulta);
        tableroTest.ubicarEnCelda(jineteEnemigo,ubicacionJinete);
        catapultaAliada.atacar(jineteEnemigo);
    }

    @Test (expected = FueraDeRangoParaEjecutarComportamientoException.class)
    public void test002SeArrojaExceptionCuandoSeQuiereAtacarAUnEnemigoADistanciaLejana(){
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Ubicacion ubicacionCatapulta = new Ubicacion(11,10);
        Catapulta catapultaAliada = new Catapulta(ubicacionCatapulta,bandoJugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,1);
        Jinete jineteEnemigo = new Jinete(ubicacionJinete,bandoJugador1);
        tableroTest.ubicarEnCelda(catapultaAliada, ubicacionCatapulta);
        tableroTest.ubicarEnCelda(jineteEnemigo,ubicacionJinete);
        catapultaAliada.atacar(jineteEnemigo);
    }


    @Test (expected = NoSePuedeAtacarUnAliadoException.class)
    public void test003SeArrojaExceptionCuandoSeQuiereAtacarAliado(){
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador2, bandoJugador1);
        Ubicacion ubicacionCatapulta = new Ubicacion(10,5);
        Catapulta catapultaAliada = new Catapulta(ubicacionCatapulta,bandoJugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,1);
        Jinete jineteAliado = new Jinete(ubicacionJinete,bandoJugador2);
        tableroTest.ubicarEnCelda(catapultaAliada, ubicacionCatapulta);
        tableroTest.ubicarEnCelda(jineteAliado,ubicacionJinete);
        catapultaAliada.atacar(jineteAliado);
    }
}
