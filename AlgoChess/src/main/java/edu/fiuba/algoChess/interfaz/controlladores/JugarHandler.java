package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.*;
import java.io.File;
//import static interfaz.ConstantesInterfaz.RUTA_SONIDO_DESTELLO;

public class JugarHandler implements EventHandler<ActionEvent> {

    private final Stage stage;

    public JugarHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Stage ventanaNombres = new Stage();
        Popup popupNombresJugador = new Popup();
       // popupNombresJugador.
        Label jugador1 = new Label("nombre Jugador 1");
        TextField areaTextoNombreJugador1 = new TextField();

        PantallaPrincipal pantalla = new PantallaPrincipal(areaTextoNombreJugador1.getText(),stage);
       //Scene escenaJuego = pantalla.getEscena();
        //this.stage.setScene(escenaJuego);
        //Media sonido = new Media(new File(RUTA_SONIDO_DESTELLO).toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(sonido);
        //mediaPlayer.setVolume(0.05);
        //mediaPlayer.play();
        ventanaNombres.close();
        popupNombresJugador.show(stage);
        popupNombresJugador.hide();
    }
}

