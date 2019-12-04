package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class AceptarNombresHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final Popup popupNombres;
    private final String nombreJugador1;
    private final String nombreJugador2;


    public AceptarNombresHandler(String nombreJugador1,String nombreJugador2, Stage stage, Popup popupNombres) {
        this.stage = stage;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.popupNombres = popupNombres;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.popupNombres.hide();
        PantallaPrincipal pantalla = new PantallaPrincipal(this.nombreJugador1 , this.nombreJugador2, stage);
    }
}