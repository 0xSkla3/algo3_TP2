package edu.fiuba.algoChess.interfaz.vista;

import java.util.HashMap;

import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.controlladores.CrearPiezaHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class PieceView{

    private double piezaEscala = 1;
    private Tablero tablero;
    private HashMap<String,String> listaImage = new HashMap<>();
    private Juego juego;


    public PieceView(HashMap<String,String> listaImage, Juego juego) {
    	this.tablero = juego.getTablero();
    	this.juego = juego;
    	listaView();
    }

    public void setPieceMap(MapView map,String piece,int x, int y) {
		DropShadow rollOverColor = new DropShadow();
        ImageView pieceImage = getImageViewMin(piece);
		CrearPiezaHandler crearPiezaHandler = new CrearPiezaHandler(piece,juego,x,y,"jugador1");
		MenuMovimiento menuMovimiento = new MenuMovimiento(crearPiezaHandler.getPieza(),tablero,pieceImage, map);

		pieceImage.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> pieceImage.setEffect(rollOverColor));
		pieceImage.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> pieceImage.setEffect(null));
        pieceImage.addEventHandler(MouseEvent.MOUSE_PRESSED,
				(event)-> menuMovimiento.menuPopUp());

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

    private HashMap<String, String> listaView() {
    	this.listaImage.put("Soldado", "imagenes/soldado.jpeg");
    	this.listaImage.put("Jinete", "imagenes/jinete.jpeg");
    	this.listaImage.put("Curandero", "imagenes/curandero.jpeg");
    	this.listaImage.put("Catapulta", "imagenes/catapulta.jpeg");
    	return listaImage;
   }

    public String searchImage(String piece) {
    		return this.listaImage.get(piece);
    }

}
