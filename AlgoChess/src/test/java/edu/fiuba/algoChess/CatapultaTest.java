package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.comportamientos.Comportamiento;
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

public class CatapultaTest {

        @Test
        public void testCatapultaPuedeAtacarAEnemigoLejano(){

            BandoJugador1 bandoJugador1 = new BandoJugador1();
            BandoJugador2 bandoJugador2 = new BandoJugador2();
            Tablero tablero = new Tablero(bandoJugador1,bandoJugador2);

            Ubicacion ubicacionCatapulta = new Ubicacion(6,6);
            Catapulta catapulta = new Catapulta(ubicacionCatapulta,bandoJugador1,tablero);

            Ubicacion ubicacionSoldado = new Ubicacion(15,15);
            Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador2,tablero);

            double vidaSoldado = soldado.getVida().getValorActual() - catapulta.getAtaque().getDanio();
            catapulta.atacar(soldado);

            assertEquals(vidaSoldado,soldado.getVida().getValorActual(), 0.0);
        }

    @Test
    public void testCatapultaPuedeDañarAVariosEnemigosLejanos(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tablero = new Tablero(bandoJugador1,bandoJugador2);

        Ubicacion ubicacionCatapulta = new Ubicacion(6,6);
        Catapulta catapulta = new Catapulta(ubicacionCatapulta,bandoJugador1,tablero);

        Ubicacion ubicacionSoldado1 = new Ubicacion(15,15);
        Soldado soldado1 = new Soldado(ubicacionSoldado1,bandoJugador2,tablero);

        Ubicacion ubicacionSoldado2 = new Ubicacion(16,15);
        Soldado soldado2 = new Soldado(ubicacionSoldado2,bandoJugador2,tablero);

        Ubicacion ubicacionSoldado3 = new Ubicacion(14,15);
        Soldado soldado3 = new Soldado(ubicacionSoldado3,bandoJugador2,tablero);

        double vidaSoldado1 = soldado1.getVida().getValorActual() - catapulta.getAtaque().getDanio();
        double vidaSoldado2= soldado2.getVida().getValorActual() - catapulta.getAtaque().getDanio();
        double vidaSoldado3 = soldado3.getVida().getValorActual() - catapulta.getAtaque().getDanio();

        catapulta.atacar(soldado1);

        assertEquals(vidaSoldado1,soldado1.getVida().getValorActual(), 0.0);
        assertEquals(vidaSoldado2,soldado2.getVida().getValorActual(), 0.0);
        assertEquals(vidaSoldado3,soldado3.getVida().getValorActual(), 0.0);
    }


    @Test
    public void testCatapultaPuedeDañarAVariosEnemigosLejanosPeroNoAUnoSeparado(){

        BandoJugador1 bandoJugador1 = new BandoJugador1();
        BandoJugador2 bandoJugador2 = new BandoJugador2();
        Tablero tablero = new Tablero(bandoJugador1,bandoJugador2);

        Ubicacion ubicacionCatapulta = new Ubicacion(6,6);
        Catapulta catapulta = new Catapulta(ubicacionCatapulta,bandoJugador1,tablero);

        Ubicacion ubicacionSoldado1 = new Ubicacion(15,15);
        Soldado soldado1 = new Soldado(ubicacionSoldado1,bandoJugador2,tablero);

        Ubicacion ubicacionSoldado2 = new Ubicacion(16,15);
        Soldado soldado2 = new Soldado(ubicacionSoldado2,bandoJugador2,tablero);

        Ubicacion ubicacionSoldado3 = new Ubicacion(14,15);
        Soldado soldado3 = new Soldado(ubicacionSoldado3,bandoJugador2,tablero);

        Ubicacion ubicacionSoldado4 = new Ubicacion(18,17);
        Soldado soldado4 = new Soldado(ubicacionSoldado4,bandoJugador2,tablero);

        double vidaSoldado1 = soldado1.getVida().getValorActual() - catapulta.getAtaque().getDanio();
        double vidaSoldado2= soldado2.getVida().getValorActual() - catapulta.getAtaque().getDanio();
        double vidaSoldado3 = soldado3.getVida().getValorActual() - catapulta.getAtaque().getDanio();
        double vidaSoldado4 = soldado4.getVida().getValorActual();

        catapulta.atacar(soldado1);

        assertEquals(vidaSoldado1,soldado1.getVida().getValorActual(), 0.0);
        assertEquals(vidaSoldado2,soldado2.getVida().getValorActual(), 0.0);
        assertEquals(vidaSoldado3,soldado3.getVida().getValorActual(), 0.0);
        assertEquals(vidaSoldado4,soldado4.getVida().getValorActual(), 0.0);
    }

}

