package edu.fiuba.algoChess.interfaz.vista;


import edu.fiuba.algoChess.entorno.Tablero;
import edu.fiuba.algoChess.interfaz.controlladores.CrearPiezaHandler;
import edu.fiuba.algoChess.juego.Juego;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;

public class PieceView{

    private double piezaEscala = 1;
    private Tablero tablero;
    private HashMap<String,String> listaImage;

    private int lastXPosition;
    private Juego juego = new Juego();

    public PieceView(HashMap<String,String> listaImage, Juego juego) {
    	this.tablero = juego.getTablero();
    	this.juego = juego;
    	this.listaImage = listaImage;
    	listaView();
    }

	public PieceView() {
		listaView();
	}

    public void setPieceMap(MapView map,String piece,int x, int y) {
		DropShadow rollOverColor = new DropShadow();
        ImageView pieceImage = getImageViewMin(piece);
        //UbicarEnMapa ubicarEnMapa = new UbicarEnMapa();
		CrearPiezaHandler crearPiezaHandler = new CrearPiezaHandler(piece,juego,x,y,"bando1");
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

    private void listaView() {
    	this.listaImage = new HashMap<String,String>();
    	this.listaImage.put("soldado", "imagenes/soldado.jpeg"); //aca se remplaza el nombre de la pieza con Soldado.geteclass() para linkear
    	this.listaImage.put("jinete", "imagenes/jinete.jpeg");
    	this.listaImage.put("curandero", "imagenes/curandero.jpeg");
    	this.listaImage.put("catapulta", "imagenes/catapulta.jpeg");
   }

    public String searchImage(String piece) {
    		return this.listaImage.get(piece);
    }

}
