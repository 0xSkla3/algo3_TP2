package edu.fiuba.algoChess.interfaz.vista;


import java.util.HashMap;

//import fiuba.algo3.AlgoChess.entidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import main.java.com.fiuba.algo3.modelo.Observer;
//import main.java.com.fiuba.algo3.modelo.Player;
//import fiuba.algo3.AlgoChess.vista.MapView;

public class PieceView{
    private double piezaEscala = 1;
    //private Tablero tablero;
    private HashMap<String,String> listaImage;

    private int lastXPosition;

    public PieceView() {
    	listaView();
    }
    
    public void setPieceMap(MapView map,String piece,int x, int y) {
		DropShadow rollOverColor = new DropShadow();


    	//guarda en el tablero
    	
        ImageView pieceImage = getImageViewMin(piece);

		pieceImage.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> pieceImage.setEffect(rollOverColor));
		pieceImage.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> pieceImage.setEffect(null));


        pieceImage.addEventHandler(MouseEvent.MOUSE_PRESSED,
				(event)-> menuMovimiento(pieceImage, map ,x,y));
        //crear pieza funcional

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

    public void moverArriba(ImageView imagenPieza, MapView map, int x, int y ){

    	DropShadow rollOverColor = new DropShadow();

    	imagenPieza.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> imagenPieza.setEffect(rollOverColor));
		imagenPieza.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> imagenPieza.setEffect(null));

		map.addViewOnMap(imagenPieza, x, y-1);

	}

	public void moverAbajo(ImageView imagenPieza, MapView map, int x, int y ){

		DropShadow rollOverColor = new DropShadow();

		imagenPieza.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> imagenPieza.setEffect(rollOverColor));
		imagenPieza.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> imagenPieza.setEffect(null));

		map.addViewOnMap(imagenPieza, x, y+1);

	}

	public void moverIzquierda(ImageView imagenPieza, MapView map, int x, int y ){

		DropShadow rollOverColor = new DropShadow();

		imagenPieza.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> imagenPieza.setEffect(rollOverColor));
		imagenPieza.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> imagenPieza.setEffect(null));

		map.addViewOnMap(imagenPieza, x-1, y);

	}

	public void moverDerecha(ImageView imagenPieza, MapView map, int x, int y ){

		DropShadow rollOverColor = new DropShadow();

		imagenPieza.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> imagenPieza.setEffect(rollOverColor));
		imagenPieza.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> imagenPieza.setEffect(null));

		map.addViewOnMap(imagenPieza, x+1, y);

	}

	public void menuMovimiento(ImageView imagenPieza ,MapView map, int x, int y){

	Stage stage = new Stage();
	VBox vbox = new VBox();

	Button arriba = new Button("Mover arriba");
	arriba.setStyle("-fx-background-color:#F1C40F;");
	arriba.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			moverArriba(imagenPieza, map, x, y );
			//cambioTurno(head,namePiece);
			stage.close();
		}
	});

	Button abajo = new Button("Mover abajo");
	abajo.setStyle("-fx-background-color:#F1C40F;");
	abajo.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			moverAbajo(imagenPieza, map, x, y );
			//cambioTurno(head,namePiece);
			stage.close();
		}
	});

	Button izquierda = new Button("Mover izquierda");
	izquierda.setStyle("-fx-background-color:#F1C40F;");
	izquierda.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			moverIzquierda(imagenPieza, map, x, y);
			//cambioTurno(head,namePiece);
			stage.close();
		}
	});

	Button derecha = new Button("Mover derecha");
	derecha.setStyle("-fx-background-color:#F1C40F;");
	derecha.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			moverDerecha(imagenPieza, map, x, y);
			//cambioTurno(head,namePiece);
			stage.close();
		}
	});

	vbox.getChildren().addAll(arriba,abajo,izquierda,derecha);

	Scene theScene = new Scene(vbox);
	stage.setScene(theScene);
	stage.show();

    }

}
