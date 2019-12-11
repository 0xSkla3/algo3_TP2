package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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

    public MapView(Juego juego) {
        this.table = new GridPane();
        width = tileWidth * 15;
        heigth = tileHeigth * 15;
        panes = new Pane[ (int)width][(int)heigth];
        this.table.setHgap(5);
        this.table.setVgap(5);
        this.table.setPrefSize(600, 600);
        this.table.setAlignment(Pos.CENTER);
        this.tablero = juego.getTablero();
        this.contenedorImagenes = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileHeigth);
                v.setMinWidth(this.tileWidth);
                v.setStyle("-fx-border-color: black;-fx-position-shape:true; -fx-background-color: #932330");
                panes[j][i] = v;
                table.add(v , j, i);
            }
			for (int j = 10; j < 20; j++) {
				Pane v = new Pane();
				v.setMinHeight(this.tileHeigth);
				v.setMinWidth(this.tileWidth);
				v.setStyle("-fx-border-color: black;-fx-position-shape:true; -fx-background-color: #ffcc8a");
				panes[j][i] = v;
				table.add(v , j, i);
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

}


