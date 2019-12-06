package edu.fiuba.algoChess.interfaz.vista;


import java.util.HashMap;

//import fiuba.algo3.AlgoChess.entidades.Unidad;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class PieceView{

    private double piezaEscala = 1;
    private Tablero tablero;
    private HashMap<String,String> listaImage = new HashMap<>();
    private int lastXPosition;
    //private Pieza piezaActual = new Soldado(new Ubicacion(1,1), new BandoJugador1(), tablero);

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
       // system.out.println(piece);
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
    	this.listaImage.put("Soldado", "imagenes/soldado.jpeg"); //aca se remplaza el nombre de la pieza con Soldado.geteclass() para linkear
    	this.listaImage.put("Jinete", "imagenes/jinete.jpeg");
    	this.listaImage.put("Curandero", "imagenes/curandero.jpeg");
    	this.listaImage.put("Catapulta", "imagenes/catapulta.jpeg");
   }

    public String searchImage(String piece) {
    		return this.listaImage.get(piece);
    }

}
