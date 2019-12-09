package edu.fiuba.algoChess.interfaz.controlladores;
import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.vista.MapView;
import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import edu.fiuba.algoChess.interfaz.vista.PieceView;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;


import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

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
        pieceView.setPieceMap(mapView, nombrePieza, x, y);
        pantallaPrincipal.cambioTurno(head, nombrePieza);
        stageUbicar.close();
        Class piezaClass = listaPieza.get(nombrePieza);
        Ubicacion ubicacion = new Ubicacion(x,y);
        Tablero tablero = juego.getTablero();
  /*      try {
            try {
                Pieza pieza = (Pieza) piezaClass.getDeclaredConstructor().newInstance();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            }
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
*/
    }

        
    }