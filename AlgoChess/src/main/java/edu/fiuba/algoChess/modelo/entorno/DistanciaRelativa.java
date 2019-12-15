package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.entidades.Pieza;

public class DistanciaRelativa {

    //protected int distancia;

    public DistanciaRelativa(//int distancia
     ){
       // this.distancia = distancia;
    }

    public static DistanciaRelativa getDistanciaRelativa (Ubicacion ubicacionPiezaCentral, Ubicacion ubicacionOtraPieza){

        int otraPiezaX = ubicacionOtraPieza.getCoordenadaX();
        int otraPiezaY = ubicacionOtraPieza.getCoordenadaY();
        int piezaEjeX = ubicacionPiezaCentral.getCoordenadaX();
        int piezaEjeY = ubicacionPiezaCentral.getCoordenadaY();

        DistanciaRelativa distanciaRelativa = new DistanciaLejana();

        if ((Math.abs(otraPiezaX-piezaEjeX)+(Math.abs(otraPiezaY-piezaEjeY)))<3) {
            distanciaRelativa = new DistanciaCercana();
        }
        if (((Math.abs(otraPiezaX-piezaEjeX)+(Math.abs(otraPiezaY-piezaEjeY)))>2)&&
                ((Math.abs(otraPiezaX-piezaEjeX)+(Math.abs(otraPiezaY-piezaEjeY)))<6)) {
            distanciaRelativa = new DistanciaMedia();
        }

       return distanciaRelativa;
    };

    public void ejecutarComportamientoPorDistancia(Pieza atacante, Pieza atacado) { }

}
