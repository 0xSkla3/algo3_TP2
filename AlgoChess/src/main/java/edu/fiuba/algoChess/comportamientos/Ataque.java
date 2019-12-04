package edu.fiuba.algoChess.comportamientos;

public class Ataque {

    private int danio;

    public Ataque(int danio){
        this.danio = danio;
    }

    public void atacar(Atacable atacable){
    }

    public int getDanio(){
        return danio;
    }


}

