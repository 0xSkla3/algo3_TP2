package edu.fiuba.algoChess.interfaz.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuMovimiento {

	public static void menuPopUp(ImageView imagenPieza , MapView map, int x, int y){

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

	public static void moverArriba(ImageView imagenPieza, MapView map, int x, int y){
		sombrearPiezaAlPasarMouse(imagenPieza);
		map.addViewOnMap(imagenPieza, x, y-1);

	}

	public static void moverAbajo(ImageView imagenPieza, MapView map, int x, int y){
		sombrearPiezaAlPasarMouse(imagenPieza);
		map.addViewOnMap(imagenPieza, x, y+1);

	}

	public static void moverIzquierda(ImageView imagenPieza, MapView map, int x, int y){
		sombrearPiezaAlPasarMouse(imagenPieza);
		map.addViewOnMap(imagenPieza, x-1, y);

	}

	public static void moverDerecha(ImageView imagenPieza, MapView map, int x, int y){

		sombrearPiezaAlPasarMouse(imagenPieza);
		map.addViewOnMap(imagenPieza, x+1, y);

	}

	public static void sombrearPiezaAlPasarMouse(ImageView imagenPieza){
		DropShadow rollOverColor = new DropShadow();
		imagenPieza.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> imagenPieza.setEffect(rollOverColor));
		imagenPieza.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> imagenPieza.setEffect(null));
	}
}
