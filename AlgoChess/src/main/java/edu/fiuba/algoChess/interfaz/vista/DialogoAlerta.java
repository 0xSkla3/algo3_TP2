package edu.fiuba.algoChess.interfaz.vista;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogoAlerta {
    public static void Alerta(String Titulo, String Texto, int segundos){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(Titulo);
        alert.setHeaderText(Texto);

        Thread thread = new Thread(() -> {
            try {

                Thread.sleep(1000 * segundos);
                if (alert.isShowing()) {
                    Platform.runLater(() -> alert.close());
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        Optional<ButtonType> result = alert.showAndWait();
    }
}
