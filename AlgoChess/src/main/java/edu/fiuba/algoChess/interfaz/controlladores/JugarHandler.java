package edu.fiuba.algoChess.interfaz.controlladores;


import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.*;



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

        Label Ljugador1 = new Label("nombre Jugador 1");
        TextField areaTextoNombreJugador1 = new TextField();
        HBox HBnombreJugador1 = new HBox();
        HBnombreJugador1.getChildren().addAll(Ljugador1, areaTextoNombreJugador1);
        HBnombreJugador1.setSpacing(10);

        Label Ljugador2 = new Label("nombre Jugador 2");
        TextField areaTextoNombreJugador2 = new TextField();
        HBox HBnombreJugador2 = new HBox();
        HBnombreJugador2.getChildren().addAll(Ljugador2, areaTextoNombreJugador2);
        HBnombreJugador2.setSpacing(10);

        Popup popupNombresJugador = new Popup();
        VBox vboxNombres = new VBox();
        Label tituloDeCuadroNombres = new Label("Agregar Nombres");
        vboxNombres.getChildren().addAll(HBnombreJugador1,HBnombreJugador2);

        AceptarNombresHandler aceptarNombresHandler = new AceptarNombresHandler(areaTextoNombreJugador1.getText(),areaTextoNombreJugador2.getText(),stage, popupNombresJugador);
        Button aceptarNombresButton = new Button("Aceptar");
        aceptarNombresButton.setOnAction(aceptarNombresHandler);

        CancelarNombresHandler cancelarNombresHandler = new CancelarNombresHandler(stage, popupNombresJugador);
        Button cancelarNombresButton = new Button("Cancelar");
        cancelarNombresButton.setOnAction(cancelarNombresHandler);

        HBox hBoxBotones = new HBox();
        hBoxBotones.getChildren().addAll(aceptarNombresButton,cancelarNombresButton);
        hBoxBotones.setSpacing(75);

        BorderPane border = new BorderPane();
        BorderPane.setAlignment(vboxNombres,Pos.CENTER);
        BorderPane.setMargin(tituloDeCuadroNombres,new Insets(25,10,10,120));
        border.setTop(tituloDeCuadroNombres);
        BorderPane.setMargin(vboxNombres,new Insets(11,11,11,11));
        border.setCenter(vboxNombres);
        border.setPrefSize(350,122);
        border.setBottom(hBoxBotones);
        BorderPane.setMargin(hBoxBotones,new Insets(11,11,11,85));
        border.setStyle("-fx-background-color: #DBDBDF");

        popupNombresJugador.getContent().addAll(border);
        popupNombresJugador.setY(375);
        popupNombresJugador.setX(520);
        popupNombresJugador.show(this.stage);

    }
}
