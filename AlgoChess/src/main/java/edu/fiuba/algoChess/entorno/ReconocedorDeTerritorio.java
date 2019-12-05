package edu.fiuba.algoChess.entorno;

import edu.fiuba.algoChess.entidades.Jinete;
import edu.fiuba.algoChess.entidades.Pieza;

public class ReconocedorDeTerritorio {

    Tablero campoDeBatalla;
    Boolean piezaAliadaCercana = false;
    Boolean piezaEnemigaCercana = false;

    public ReconocedorDeTerritorio(Tablero campoDeBatalla){
        this.campoDeBatalla = campoDeBatalla;
    }

    public void reconocerTerreno(Jinete jinete, int distancia, Pieza pieza){

            int coordenadaX = jinete.getUbicacion().getCoordenadaX();
            int coordenadaY = jinete.getUbicacion().getCoordenadaY();

            for (int i = coordenadaX - distancia; i <= coordenadaX + distancia; i++) {
                if (i < 1 || i > 20) {
                    continue;
                }
                for (int j = coordenadaY - distancia; j <= coordenadaY + distancia; j++) {
                    if (j < 1 || j > 20) {
                        continue;
                    }
                    Ubicacion ubicacion = new Ubicacion(i, j);
                    if (ubicacion.equals(jinete.getUbicacion())) {
                        continue;
                    }

                    Celda celda = campoDeBatalla.getCelda(ubicacion);
                    if ((celda.getPiezaActual().bandoAliado(jinete.getBando())) ) {
                        piezaAliadaCercana = true;
                    } else if ((celda.getPiezaActual().bandoEnemigo(jinete.getBando()))) {
                        piezaEnemigaCercana = true;
                    }
                }
            }

            if(piezaEnemigaCercana && !piezaAliadaCercana){

                //throw new AtaqueInvalidoException
                return;
            }

            jinete.concretarAtaqueMedio(pieza);

    }



}
