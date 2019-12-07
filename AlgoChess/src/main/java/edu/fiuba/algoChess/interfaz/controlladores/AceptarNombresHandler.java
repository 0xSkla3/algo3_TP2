package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.control.TextField;



public class AceptarNombresHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final Popup popupNombres;
    private final TextField TFnombreJugador1;
    private final TextField TFnombreJugador2;


    public AceptarNombresHandler(TextField TFnombreJugador1, TextField TFnombreJugador2, Stage stage, Popup popupNombres){
        this.stage = stage;
        this.TFnombreJugador1 = TFnombreJugador1;
        this.TFnombreJugador2 = TFnombreJugador2;
        this.popupNombres = popupNombres;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.popupNombres.hide();

        PantallaPrincipal pantalla = new PantallaPrincipal(this.TFnombreJugador1.getText() , this.TFnombreJugador2.getText(), stage);
    }
}