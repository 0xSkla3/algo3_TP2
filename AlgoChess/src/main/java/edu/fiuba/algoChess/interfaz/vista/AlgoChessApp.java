package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AlgoChessApp extends Application implements EventHandler<ActionEvent> {

    private Juego juego;
    private PieceView player;
    private MapView mapView;
    private Inicio inicio;
    private Button button;

    @Override
    public void start(Stage firstStage) {
        firstStage.setTitle("AlgoChess");
        inicio = new Inicio(firstStage);
        StackPane layout = new StackPane();

        Scene firstScene = new Scene(inicio, Color.BLACK);

        firstStage.setScene(firstScene);
        firstStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}