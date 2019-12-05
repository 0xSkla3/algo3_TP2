package edu.fiuba.algoChess.interfaz.vista;


import java.util.HashMap;

//import fiuba.algo3.AlgoChess.entidades.Unidad;
import edu.fiuba.algoChess.bandos.BandoJugador1;
import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.entidades.Soldado;
import edu.fiuba.algoChess.entorno.Tablero;
import edu.fiuba.algoChess.entorno.Ubicacion;
import edu.fiuba.algoChess.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieceView{

    private double piezaEscala = 1;
    private Tablero tablero;
    private HashMap<String,String> listaImage;

    private int lastXPosition;
    //private Pieza piezaActual = new Soldado(new Ubicacion(1,1), new BandoJugador1(), tablero);
    private Juego juego = new Juego();

    public PieceView() {
    	listaView();
    }

    public void setPieceMap(MapView map,String piece,int x, int y) {
		DropShadow rollOverColor = new DropShadow();

        ImageView pieceImage = getImageViewMin(piece);

		pieceImage.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> pieceImage.setEffect(rollOverColor));
		pieceImage.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> pieceImage.setEffect(null));
        pieceImage.addEventHandler(MouseEvent.MOUSE_PRESSED,
				(event)-> MenuMovimiento.menuPopUp(pieceImage, map, x, y));

        map.addViewOnMap(pieceImage, x, y);
    }

    public ImageView getImageViewMin(String piece) {
    	ImageView pieceImage = new ImageView(new Image(searchImage(piece)));
        pieceImage.setScaleX(piezaEscala);
        pieceImage.setScaleY(piezaEscala);
        pieceImage.setFitHeight(28);
        pieceImage.setFitWidth(28);

        return pieceImage;
    }

    public ImageView getImageViewMax(String piece) {
    	ImageView pieceImage = new ImageView(new Image(searchImage(piece),90,100,false,false));
        return pieceImage;
    }

    private void listaView() {
    	this.listaImage = new HashMap<String,String>();
    	this.listaImage.put("soldado", "imagenes/soldado.jpg"); //aca se remplaza el nombre de la pieza con Soldado.geteclass() para linkear
    	this.listaImage.put("jinete", "imagenes/jinete.jpg");
    	this.listaImage.put("curandero", "imagenes/curandero.jpg");
    	this.listaImage.put("catapulta", "imagenes/catapulta.jpg");
   }

    public String searchImage(String piece) {
    		return this.listaImage.get(piece);
    }

}
