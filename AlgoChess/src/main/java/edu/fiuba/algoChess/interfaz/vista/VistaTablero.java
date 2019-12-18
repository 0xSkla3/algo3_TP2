package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.juego.Juego;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.function.Consumer;

public class VistaTablero extends Group {

    public double width;
    public double heigth;
    private double tileWidth = 30;
    private double tileHeigth = 30;
    public Juego juego;
    public PantallaPrincipal pantallaPrincipal;
    public GridPane table = new GridPane();
    public Pane[][] panes;

    private Consumer<Ubicacion> handler = null;

    public VistaTablero(Juego juego, PantallaPrincipal pantallaPrincipal) {
        this.juego = juego;
        this.pantallaPrincipal = pantallaPrincipal;

        this.table = new GridPane();
        width = tileWidth * 15;
        heigth = tileHeigth * 15;
        panes = new Pane[ (int)width][(int)heigth];
        this.table.setHgap(5);
        this.table.setVgap(5);
        this.table.setPrefSize(600, 600);
        this.table.setAlignment(Pos.CENTER);
        this.setPickOnBounds(false);
        for (int i = 1; i <=20; i++) {
            for (int j = 1; j <= 20; j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileHeigth);
                v.setMinWidth(this.tileWidth);
                v.setStyle("-fx-border-color: black;-fx-position-shape:true; -fx-background-color: " + (j > 10 ? "#ffcc8a" : "#932330"));

                v.setUserData(new Ubicacion(j, i));
                v.setOnMouseClicked((event) -> this.celdaClickeada((Ubicacion)((Pane)event.getSource()).getUserData()));

                panes[j][i] = v;
                table.add(v , j, i);
            }
        }

        table.setStyle("-fx-padding: 20;");
        this.instanciarVista(table);
    }

    void celdaClickeada(Ubicacion u) {
        if(this.handler != null) {
            this.handler.accept(u);
        }
    }

    public void registrarControlador(Consumer<Ubicacion> handler) {
        this.handler = handler;
    }

    public void actualizarVista() {
        for(int i = 1; i <= 20; i++)
            for(int j = 1; j <= 20; j++) {
               panes[i][j].getChildren().clear();
            }

        for(Pieza p : this.juego.getPiezasEnTablero()) {
            VistaPieza vp = new VistaPieza(p, juego, pantallaPrincipal);
            Ubicacion u = p.getUbicacion();
            panes[u.getCoordenadaX()][u.getCoordenadaY()].getChildren().add(0, vp.crearNodo());
        }
    }

    public void instanciarVista(Node view) {
        this.getChildren().add(view);
    }
}