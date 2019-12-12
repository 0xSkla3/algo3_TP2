package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.controlladores.CrearPiezaHandler;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;
import java.util.Optional;


public class PieceView{

    private double piezaEscala = 1;
    private Tablero tablero;
    private HashMap<String,String> listaImage = new HashMap<>();
    private Juego juego;
    private PantallaPrincipal pantallaPrincipal;


    public PieceView(HashMap<String,String> listaImage, Juego juego, PantallaPrincipal pantallaPrincipal) {
    	this.tablero = juego.getTablero();
    	this.juego = juego;
    	this.pantallaPrincipal = pantallaPrincipal;
    	listaView();
    }

    public void setPieceMap(MapView map, String piece,int x, int y) {
		DropShadow rollOverColor = new DropShadow();
        ImageView pieceImage = getImageViewMin(piece);
		Pieza piezaTarget = piezaTarget(piece,juego,x,y);

		pieceImage.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> pieceImage.setEffect(rollOverColor));
		pieceImage.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> pieceImage.setEffect(null));
        pieceImage.addEventHandler(MouseEvent.MOUSE_PRESSED,
				(event) -> comportamientoAlTocarPieza(pieceImage, map, piece, piezaTarget , x, y));
        map.addViewOnMap(pieceImage, x, y);
        juego.pasarTurno();
    }

 	public void moverPiezaEnMapa(ImageView pieceImage, MapView map, String piece, Pieza piezaAMover){
		MenuPieza menuPieza = new MenuPieza(this.juego,piezaAMover, this.juego.getTablero(),pieceImage,map,
				this, piece, this.pantallaPrincipal.getSegundaEtapa());
		menuPieza.menuPopUp();
		map.addViewOnMap(pieceImage, piezaAMover.getX(), piezaAMover.getY());
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

	public void mostrarDatosPiezaActual(String piece, Pieza pieza, int x, int y){

    	if(pieza.getBando().equals(new BandoJugador1())){
			alerta3seg("Datos Pieza","Pieza: "+
					piece +   "\nUbicacion: x=" + x + " y=" + y +
					"\nBando: "+ juego.getJugador1().getNombre());}
		else{
			alerta3seg("Datos Pieza","Pieza: "+
					piece +   "\nUbicacion: x=" + x + " y=" + y +
					"\nBando: "+ juego.getJugador1().getNombre());
			}
    }

    public void comportamientoAlTocarPieza(ImageView pieceImage, MapView map, String piece, Pieza piezaModelo, int x, int y){
    	if (this.juego.getSegundaEtapa()){
				moverPiezaEnMapa(pieceImage, map, piece, piezaModelo);
		}else{
			mostrarDatosPiezaActual(piece, piezaModelo,  x,  y);
			map.addViewOnMap(pieceImage, x, y);
		}
	}

	public Pieza piezaTarget(String piece, Juego juego, int x, int y) {
		CrearPiezaHandler crearPiezaHandler = new CrearPiezaHandler(piece, juego, x, y);
		BuscarPiezaEnJuegoHandler buscarPiezaEnJuegoHandler = new BuscarPiezaEnJuegoHandler(juego, x, y);

		if (!this.juego.getFinDeJuego()) {
			if (this.juego.getSegundaEtapa()) {
				return buscarPiezaEnJuegoHandler.buscarPiezaEnUbicacion();
			} else {
				return crearPiezaHandler.getPieza();
			}
		}
		return new PiezaNull();
	}
}

