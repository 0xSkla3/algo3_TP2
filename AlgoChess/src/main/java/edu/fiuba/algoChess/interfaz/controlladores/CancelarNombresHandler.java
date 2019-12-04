package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.interfaz.vista.Inicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class CancelarNombresHandler implements EventHandler<ActionEvent> {


     private final Stage stage;
     private final Popup popupNombres;

    public CancelarNombresHandler( Stage stage, Popup popupNombres) {
        this.stage = stage;
        this.popupNombres = popupNombres;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.popupNombres.hide();
        Inicio inicio =  new Inicio(this.stage);
    }

}
