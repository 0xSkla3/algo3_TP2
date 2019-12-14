package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPiezaEnSectoRival;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.vista.VistaTablero;
import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import edu.fiuba.algoChess.interfaz.vista.VistaPieza;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Optional;

public class UbicarPiezaHandler implements EventHandler<ActionEvent> {

    private String nombrePieza;
    private Juego juego;
    private Stage stagePrincipal;
    private VistaPieza pieceView;
    private PantallaPrincipal pantallaPrincipal;
    private HashMap<String,Class> listaPieza;
    private Stage stageUbicar;
    private VistaTablero mapView;
    private HBox head;
    private TextField tFX;
    private TextField tFY;
    private Bando bandoPieza;


    public UbicarPiezaHandler(Juego juego, Stage stagePrincipal, Stage stageUbicar,
                              VistaPieza pieceView, String nombrePieza, PantallaPrincipal pantallaPrincipal,
                              HashMap<String,Class> listaPiezas, VistaTablero mapView, HBox head, TextField tFX, TextField tFY, Bando bandoPieza){
        this.juego = juego;
        this.nombrePieza = nombrePieza;
        this.stagePrincipal = stagePrincipal;
        this.pieceView = pieceView;
        this.pantallaPrincipal =  pantallaPrincipal;
        this.listaPieza = listaPiezas;
        this.stageUbicar = stageUbicar;
        this.mapView = mapView;
        this.head = head;
        this.tFX = tFX;
        this.tFY = tFY;
        this.bandoPieza = bandoPieza;
    }

    @Override
    public void handle(ActionEvent e) {
        int x = Integer.parseInt((tFX.getText()));
        int y = Integer.parseInt((tFY.getText()));
        try {
            pieceView.setPieceMap(mapView, nombrePieza, x, y);
            pantallaPrincipal.cambioTurno(head);
            stageUbicar.close();
       } catch(NoSePuedeUbicarPiezaEnSectoRival exc){
            alerta3seg("Sector rival", "No se puede ubicar la pieza en el sector rival");
        } catch(NoSePuedeUbicarPorqueEstaOcupadoException ex){
            alerta3seg( "Celda ocupada", "No se puede ubicar la pieza en una celda ocupada");
        }
    }

    public void alerta3seg(String Titulo, String Texto){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(Titulo);
        alert.setHeaderText(Texto);

        Thread thread = new Thread(() -> {
            try {

                Thread.sleep(3000);
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
