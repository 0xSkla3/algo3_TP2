package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DistanciaRelativa {

    public static DistanciaRelativa calcularDistanciaRelativa(Ubicacion ubicacionPiezaCentral, Ubicacion ubicacionOtraPieza){

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
