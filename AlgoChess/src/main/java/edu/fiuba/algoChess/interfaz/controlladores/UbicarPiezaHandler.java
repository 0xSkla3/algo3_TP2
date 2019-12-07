package edu.fiuba.algoChess.interfaz.controlladores;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UbicarPiezaHandler implements EventHandler<ActionEvent> {

    private String nombrePieza;
    private Juego juego;


    public UbicarPiezaHandler(Juego juego, String nombrePieza){
        this.juego = juego;
        this.nombrePieza = nombrePieza;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        
    }
}
