package edu.fiuba.algoChess.interfaz.vista;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.scene.Node;
//import main.java.com.fiuba.algo3.modelo.Map;

public class MapView extends Group {

    public double width;
    public double heigth;
    private double tileWidth = 30;
    private double tileHeigth = 30;

    private GridPane table;

    private Pane[][] panes;

    public MapView(){
        table = new GridPane();
        width = tileWidth * 20;//map.getWidth();
        heigth = tileHeigth * 20;//map.getHeigth();
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
        /*
        Background bi = new Background(new BackgroundImage(new Image("https://www.dzoom.org.es/wp-content/uploads/2016/11/Revelar-byn-Ligthroom-1-810x540.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.width, this.heigth, false, false, false, false)));
        table.setBackground(bi);*/
        table.setStyle("-fx-padding: 20;");
        this.addView(table);
    }

    public void addViewOnMap(Node view, int x, int y) {

        panes[x-1][y-1].getChildren().add(0, view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    
}
