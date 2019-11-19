package edu.fiuba.algoChess;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class JineteTest {

    @Test
    public void test01JineteReconoceAPiezaAliadaEnTerrenoCercanoCeldaContigua(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador1);
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(jinete,tableroTest);
        assertTrue(jinete.getPiezaAliadaCercana());
    }


    @Test
    public void test02JineteReconoceAPiezaAliadaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador1);
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,3);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(jinete,tableroTest);
        assertTrue(jinete.getPiezaAliadaCercana());
    }

    @Test
    public void test03JineteNoReconoceEnTerrenoCercanoAPiezaAliadaAdistancia3(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador1);
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,2);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(jinete,tableroTest);
        assertFalse(jinete.getPiezaAliadaCercana());
    }


    @Test
    public void test04JineteReconoceAPiezaEnemigaEnTerrenoCercanoCeldaContigua(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(11,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(jinete,tableroTest);
        assertTrue(jinete.getPiezaEnemigaCercana());
    }


    @Test
    public void test05jineteReconoceAPiezaAliadaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(12,5);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(jinete,tableroTest);
        assertTrue(jinete.getPiezaEnemigaCercana());
    }

    @Test
    public void test06jineteNoReconoceEnTerrenoCercanoAPiezaAliadaAdistancia3(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(13,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(jinete,tableroTest);
        assertFalse(jinete.getPiezaEnemigaCercana());
    }

    @Test
    public void test07jineteReconoceAPiezaAliadaYPiezaEnemigaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jineteJugador1 = new Jinete();
        Curandero curanderoJugador1 = new Curandero();
        Curandero curanderoJugador2 = new Curandero();
        jineteJugador1.setJugador(jugador1);
        curanderoJugador1.setJugador(jugador1);
        curanderoJugador2.setJugador(jugador2);
        Ubicacion ubicacionJineteJugador1 = new Ubicacion(10,5);
        Ubicacion ubicacionCuranderoJugador1 = new Ubicacion(10,4);
        Ubicacion ubicacionCuranderoJugador2 = new Ubicacion(12,5);
        tableroTest.ubicarEnCelda(jineteJugador1,ubicacionJineteJugador1);
        tableroTest.ubicarEnCelda(curanderoJugador1,ubicacionCuranderoJugador1);
        tableroTest.ubicarEnCelda(curanderoJugador2,ubicacionCuranderoJugador2);
        jineteJugador1.reconocerTerreno(jineteJugador1,tableroTest);
        assertTrue((jineteJugador1.getPiezaAliadaCercana() && jineteJugador1.getPiezaEnemigaCercana()));
    }

}


