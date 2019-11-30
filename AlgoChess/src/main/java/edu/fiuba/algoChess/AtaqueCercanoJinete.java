package edu.fiuba.algoChess;

public class AtaqueCercanoJinete extends Comportamiento {

    public AtaqueCercanoJinete(int valorComportamiento) {
        super(valorComportamiento);
    };

    @Override
    public int getValorComportamiento() {
        return super.getValorComportamiento();
    }


    //    public void ejecutarComportamiento(Jinete jinete, Pieza pieza){
//        if (jinete.getBando()!=pieza.getBando()){
//            DistanciaRelativa distanciaRelativa = this.distanciaRelativa.getDistanciaRelativa(jinete, pieza);
//            pieza.serAfectadoPorOtraPieza(this.getValorComportamiento(), distanciaRelativa);
//        }
//    };



}
