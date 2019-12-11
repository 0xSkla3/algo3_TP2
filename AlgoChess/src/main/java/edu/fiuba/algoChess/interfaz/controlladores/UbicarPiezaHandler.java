package edu.fiuba.algoChess.interfaz.controlladores;
import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPiezaEnSectoRival;
import edu.fiuba.algoChess.Modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.vista.MapView;
import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import edu.fiuba.algoChess.interfaz.vista.PieceView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;


import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Optional;

public class UbicarPiezaHandler implements EventHandler<ActionEvent> {

    private String nombrePieza;
    private Juego juego;
    private Stage stagePrincipal;
    private PieceView pieceView;
    private PantallaPrincipal pantallaPrincipal;
    private HashMap<String,Class> listaPieza;
    private Stage stageUbicar;
    private MapView mapView;
    private HBox head;
    private TextField tFX;
    private TextField tFY;
    private Bando bandoPieza;


    public UbicarPiezaHandler(Juego juego, Stage stagePrincipal, Stage stageUbicar,
                              PieceView pieceView, String nombrePieza, PantallaPrincipal pantallaPrincipal,
                              HashMap<String,Class> listaPiezas, MapView mapView, HBox head, TextField tFX, TextField tFY, Bando bandoPieza){
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
            pieceView.setPieceMap(mapView, nombrePieza,"jugador1" , x, y);
            pantallaPrincipal.cambioTurno(head, nombrePieza);
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