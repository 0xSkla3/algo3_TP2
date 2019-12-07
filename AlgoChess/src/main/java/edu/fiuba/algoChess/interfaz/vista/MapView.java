package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.entorno.Tablero;
import edu.fiuba.algoChess.entorno.Ubicacion;
import edu.fiuba.algoChess.juego.Juego;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;

public class MapView extends Group {

    public double width;
    public double heigth;
    private double tileWidth = 30;
    private double tileHeigth = 30;
    public Tablero tablero;
    public HashMap<String, Image> contenedorImagenes = new HashMap<>();
    public Juego juego;
    public GridPane table = new GridPane();
    public Pane[][] panes;

    public MapView(HashMap<String,Image> contenedorImagenes, Juego juego ) {
        this.juego = new Juego();
        this.table = new GridPane();
        width = tileWidth * 20;
        heigth = tileHeigth * 20;
        panes = new Pane[ (int)width][(int)heigth];
        this.table.setHgap(5);
        this.table.setVgap(5);
        this.table.setPrefSize(600, 600);
        this.table.setAlignment(Pos.CENTER);
        this.tablero = juego.getTablero();
        this.contenedorImagenes = contenedorImagenes;
       // this.actualizarTablero();
        this.addView(table);
       // this.getChildren().addAll(this.hboxTexto, this.grid);
    }

    public MapView(){
        table = new GridPane();
        width = tileWidth * 20;
        heigth = tileHeigth * 20;
        panes = new Pane[ (int)width][(int)heigth];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileHeigth);
                v.setMinWidth(this.tileWidth);
                v.setStyle("-fx-border-color: black;-fx-position-shape:true");
                panes[i][j] = v;
                table.add(v , i, j);
            }
        }

        table.setStyle("-fx-padding: 20;");
        this.addView(table);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //excepcion
                }
            }
        }
        panes[x][y].getChildren().add(0, view);
    }

    public Pane paneActual(Ubicacion ubicacion) {
        panes[ubicacion.getX()][ubicacion.getY()].setStyle("-fx-background-color: #46b1f2");

        return panes[ubicacion.getX()][ubicacion.getY()];
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }

    public ArrayList<Pane> getPanesAdyacentes(Pieza pieza) {
        ArrayList<Pane> panesAdyacentes = new ArrayList<Pane>();

      /*  if (pieza.getUbicacion().getY() + 1 <= 19) {
            panes[pieza.getUbicacion().getX()][pieza.getUbicacion().getY() + 1].setOnMouseClicked(new MovimientoAdelanteController(pieza));
            panesAdyacentes.add(panes[pieza.getUbicacion().getX()][pieza.getUbicacion().getY() + 1]);
        }

        if (pieza.getUbicacion().getY() - 1 >= 0) {
            panes[pieza.getUbicacion().getX()][pieza.getUbicacion().getY() - 1].setOnMouseClicked(new MovimientoAtrasController(pieza));
            panesAdyacentes.add(panes[pieza.getUbicacion().getX()][pieza.getUbicacion().getY() - 1]);
        } */

        if (pieza.getUbicacion().getX() + 1 <= 19) {
           // panes[pieza.getUbicacion().getX() + 1][pieza.getUbicacion().getY()].setOnMouseClicked(new MoverDerechaController(pieza, this.tablero, this.table, this.contenedorImagenes.get(0)));
            panesAdyacentes.add(panes[pieza.getUbicacion().getX() + 1][pieza.getUbicacion().getY()]);
        }

        /*if (pieza.getUbicacion().getX() - 1 >= 0) {
            panes[pieza.getUbicacion().getX() - 1][pieza.getUbicacion().getY()].setOnMouseClicked(new MovimientoIzquierdaController(pieza));
            panesAdyacentes.add(panes[pieza.getUbicacion().getX() - 1][pieza.getUbicacion().getY()]);
        }*/

        panesAdyacentes.stream().forEach(pane -> pane.setStyle("-fx-background-color: #79f281"));

        return panesAdyacentes;
    }

    public Pane paneActual(Pieza unidad) {
        panes[unidad.getUbicacion().getX()][unidad.getUbicacion().getY()].setStyle("-fx-background-color: #46b1f2");

        return panes[unidad.getUbicacion().getX()][unidad.getUbicacion().getY()];
    }


}
