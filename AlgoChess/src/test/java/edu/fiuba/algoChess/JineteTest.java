package edu.fiuba.algoChess;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class JineteTest {
/*
    @Test
    public void test01JineteReconoceAPiezaAliadaEnTerrenoCercanoCeldaContigua(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setBando(new BandoJugador1());
        curandero.setBando(new BandoJugador1());
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertTrue(jinete.getPiezaAliadaCercana());
    }


    @Test
    public void test02JineteReconoceAPiezaAliadaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setBando(new BandoJugador1());
        curandero.setBando(new BandoJugador1());
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,3);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertTrue(jinete.getPiezaAliadaCercana());
    }

    @Test
    public void test03JineteNoReconoceEnTerrenoCercanoAPiezaAliadaAdistancia3(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setBando(new BandoJugador1());
        curandero.setBando(new BandoJugador1());
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,2);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertFalse(jinete.getPiezaAliadaCercana());
    }


    @Test
    public void test04JineteReconoceAPiezaEnemigaEnTerrenoCercanoCeldaContigua(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setBando(new BandoJugador1());
        curandero.setBando(new BandoJugador2());
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(11,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertTrue(jinete.getPiezaEnemigaCercana());
    }


    @Test
    public void test05jineteReconoceAPiezaAliadaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setBando(new BandoJugador1());
        curandero.setBando(new BandoJugador2());
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(12,5);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertTrue(jinete.getPiezaEnemigaCercana());
    }

    @Test
    public void test06jineteNoReconoceEnTerrenoCercanoAPiezaAliadaAdistancia3(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setBando(new BandoJugador1());
        curandero.setBando(new BandoJugador2());
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(13,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertFalse(jinete.getPiezaEnemigaCercana());
    }

    @Test
    public void test07jineteReconoceAPiezaAliadaYPiezaEnemigaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);
        Jinete jineteJugador1 = new Jinete();
        Curandero curanderoJugador1 = new Curandero();
        Curandero curanderoJugador2 = new Curandero();
        jineteJugador1.setBando(new BandoJugador1());
        curanderoJugador1.setBando(new BandoJugador1());
        curanderoJugador2.setBando(new BandoJugador2());
        Ubicacion ubicacionJineteJugador1 = new Ubicacion(10,5);
        Ubicacion ubicacionCuranderoJugador1 = new Ubicacion(10,4);
        Ubicacion ubicacionCuranderoJugador2 = new Ubicacion(12,5);
        tableroTest.ubicarEnCelda(jineteJugador1,ubicacionJineteJugador1);
        tableroTest.ubicarEnCelda(curanderoJugador1,ubicacionCuranderoJugador1);
        tableroTest.ubicarEnCelda(curanderoJugador2,ubicacionCuranderoJugador2);
        jineteJugador1.reconocerTerreno(tableroTest);
        assertTrue((jineteJugador1.getPiezaAliadaCercana() && jineteJugador1.getPiezaEnemigaCercana()));
    };

    @Test
    public void test08JineteAtacaAEnemigoEnDistanciaMediaCuandoHayUnSoldadoAliadoCerca(){ //este test no tiene sentido, deberia atacarlo en distancia corta, no negar la distancia media
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

        Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(15,1);
        Soldado soldadoEnemigo = new Soldado(ubicacionSoldadoEnemigo,bandoJugador2);

        Ubicacion ubicacionSoldadoAliado = new Ubicacion(10,2);
        Soldado soldadoAliado = new Soldado(ubicacionSoldadoAliado,bandoJugador1);

        Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
        Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1);


        tableroTest.ubicarEnCelda(soldadoEnemigo, ubicacionSoldadoEnemigo);
        tableroTest.ubicarEnCelda(soldadoAliado,ubicacionSoldadoAliado);
        tableroTest.ubicarEnCelda(jineteAliado,ubicacionJineteAliado);
        jineteAliado.reconocerTerreno(tableroTest);

        DistanciaRelativa distanciaSoldadoEnemigoAJineteAliado = jineteAliado.getDistanciaRelativa(soldadoEnemigo);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldadoEnemigo.getVida() - jineteAliado.getDanioMedio();
        jineteAliado.atacar(distanciaSoldadoEnemigoAJineteAliado,soldadoEnemigo);
        assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida());

    };

    @Test
    public void test09JineteNoPuedeAtacarConAtaqueMedioAEnemigoEnDistanciaCortaAunCuandoHayUnSoldadoAliadoCerca(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

        Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(11,1);
        Soldado soldadoEnemigo = new Soldado(ubicacionSoldadoEnemigo,bandoJugador2);

        Ubicacion ubicacionSoldadoAliado = new Ubicacion(10,2);
        Soldado soldadoAliado = new Soldado(ubicacionSoldadoAliado,bandoJugador1);

        Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
        Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1);

        tableroTest.ubicarEnCelda(soldadoEnemigo, ubicacionSoldadoEnemigo);
        tableroTest.ubicarEnCelda(soldadoAliado,ubicacionSoldadoAliado);
        tableroTest.ubicarEnCelda(jineteAliado,ubicacionJineteAliado);
        jineteAliado.reconocerTerreno(tableroTest);

        DistanciaRelativa distanciaSoldadoEnemigoAJineteAliado = jineteAliado.getDistanciaRelativa(soldadoEnemigo);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldadoEnemigo.getVida();
        jineteAliado.atacar(distanciaSoldadoEnemigoAJineteAliado,soldadoEnemigo);
        assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida());

    };

    @Test
    public void test10JineteAtacaConAtaqueCercanoAEnemigoEnDistanciaCortaCuandoNoHayUnSoldadoAliadoCerca(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

        Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(11,1);
        Soldado soldadoEnemigo = new Soldado(ubicacionSoldadoEnemigo,bandoJugador2);

        Ubicacion ubicacionSoldadoAliado = new Ubicacion(5,2);
        Soldado soldadoAliado = new Soldado(ubicacionSoldadoAliado,bandoJugador1);

        Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
        Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1);

        tableroTest.ubicarEnCelda(soldadoEnemigo, ubicacionSoldadoEnemigo);
        tableroTest.ubicarEnCelda(soldadoAliado,ubicacionSoldadoAliado);
        tableroTest.ubicarEnCelda(jineteAliado,ubicacionJineteAliado);
        jineteAliado.reconocerTerreno(tableroTest);

        DistanciaRelativa distanciaSoldadoEnemigoAJineteAliado = jineteAliado.getDistanciaRelativa(soldadoEnemigo);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldadoEnemigo.getVida() - jineteAliado.getDanioCercano();
        jineteAliado.atacar(distanciaSoldadoEnemigoAJineteAliado,soldadoEnemigo);
        assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida());

    };

    @Test
    public void test11JineteNoPuedeAtacarConAtaqueCercanoAEnemigoEnDistanciaCortaCuandoHayUnSoldadoAliadoCerca(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tableroTest = new Tablero(bandoJugador1, bandoJugador2);

        Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(11,1);
        Soldado soldadoEnemigo = new Soldado(ubicacionSoldadoEnemigo,bandoJugador2);

        Ubicacion ubicacionSoldadoAliado = new Ubicacion(10,2);
        Soldado soldadoAliado = new Soldado(ubicacionSoldadoAliado,bandoJugador1);

        Ubicacion ubicacionJineteAliado = new Ubicacion(10,1);
        Jinete jineteAliado = new Jinete(ubicacionJineteAliado,bandoJugador1);

        tableroTest.ubicarEnCelda(soldadoEnemigo, ubicacionSoldadoEnemigo);
        tableroTest.ubicarEnCelda(soldadoAliado,ubicacionSoldadoAliado);
        tableroTest.ubicarEnCelda(jineteAliado,ubicacionJineteAliado);
        jineteAliado.reconocerTerreno(tableroTest);

        DistanciaRelativa distanciaSoldadoEnemigoAJineteAliado = jineteAliado.getDistanciaRelativa(soldadoEnemigo);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldadoEnemigo.getVida();
        jineteAliado.atacar(distanciaSoldadoEnemigoAJineteAliado,soldadoEnemigo);
        assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida());

    };

    @Test

    public void test12JineteAtacaSoldadoCercano(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();

        Ubicacion ubicacionJinete = new Ubicacion(1,2);
        Jinete jinete = new Jinete(ubicacionJinete,bandoJugador1);

        Ubicacion ubicacionSoldado = new Ubicacion(1,1);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador2);


        DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldado.getVida() - jinete.getDanioCercano();
        jinete.atacar(distanciaSoldadoAJinete,soldado);
        Assert.assertEquals(vidaTrasAtaque,soldado.getVida());
    };
*/
    @Test
    public void test13JineteAtacaSoldadoADistanciaMedia() {

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();

        Ubicacion ubicacionJinete = new Ubicacion(1,2);
        Jinete jinete = new Jinete(ubicacionJinete,bandoJugador1);

        Ubicacion ubicacionSoldado = new Ubicacion(4,2);
        Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador2);

        DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldado.getVida() - jinete.getDanioMedio();
        jinete.atacar(distanciaSoldadoAJinete,soldado);
        Assert.assertEquals(vidaTrasAtaque,soldado.getVida());
    };

/*    @Test    ESTE TEST DEBE TIRAR FUERA_DE_RANGO_EXCEPT
    public void test14JineteAtacaSoldadoLejanoYNoSeDescuentaVidaDelSoldado(){
        Soldado soldado = new Soldado();
        Ubicacion ubicacionSoldado = new Ubicacion(10,10);
        soldado.setUbicacion(ubicacionSoldado);
        Jinete jinete = new Jinete();
        Ubicacion ubicacionJinete = new Ubicacion(1,2);
        jinete.setUbicacion(ubicacionJinete);
        DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldado.getVida() - jinete.getDanioCercano();
        jinete.ejecutarComportamiento(distanciaSoldadoAJinete,soldado);
        Assert.assertEquals(vidaTrasAtaque,soldado.getVida());
    };*/

}


