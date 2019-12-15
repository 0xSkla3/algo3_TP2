package edu.fiuba.algoChess.modelo.comportamientos;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.salud.Herible;
import edu.fiuba.algoChess.modelo.salud.Salud;

public abstract class Ataque {

    protected double danio;
    protected final double C_extraSectorEnemigo = 0.05;

    public Ataque(double danio){
        this.danio = danio;
    }

    public abstract void atacar(Pieza pieza);

    public Salud hacerDanioSectorAliado(Herible herible) {
        return this.daniar(herible, danio);
    }

    public Salud hacerDanioSectorEnemigo(Herible herible) {
        return this.daniar(herible, this.danio*C_extraSectorEnemigo);
    }

    protected Salud daniar(Herible herible, double danio) {
       return herible.herir(danio);
    }

    public double getDanio(){
        return danio;
    }


}
