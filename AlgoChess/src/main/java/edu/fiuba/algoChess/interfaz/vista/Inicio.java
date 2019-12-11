package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.interfaz.controlladores.JugarHandler;
import edu.fiuba.algoChess.interfaz.controlladores.SalirHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Inicio extends HBox {

    public Inicio(Stage stage) {

        this.setPrefSize(600, 600);

        stage.getIcons().add(new Image("imagenes/logo.png"));

        JugarHandler jugarHandler = new JugarHandler(stage);
        Hyperlink botonJugar = new Hyperlink();
        botonJugar.setGraphic(new ImageView(new Image("imagenes/jugar.png")));
        botonJugar.setBorder(Border.EMPTY);
        botonJugar.setAlignment(Pos.CENTER);
        botonJugar.setOnAction(jugarHandler);

        SalirHandler salirHandler = new SalirHandler();
        Hyperlink botonSalir = new Hyperlink();
        botonSalir.setGraphic(new ImageView(new Image("imagenes/salir.png")));
        botonJugar.setBorder(Border.EMPTY);
        botonSalir.setAlignment(Pos.CENTER);
        botonSalir.setOnAction(salirHandler);

        ImageView titulo = new ImageView(new Image("imagenes/titulo.png"));
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(titulo);
        hbox.setPadding(new Insets(0,0,30,0));

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(hbox, botonJugar, botonSalir);
        vbox.setAlignment(Pos.CENTER);

        ImageView fondo = new ImageView(new Image("imagenes/pantalla_inicio_prueba.jpg"));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(fondo, vbox);

        this.getChildren().addAll(stackPane);
    }

}
