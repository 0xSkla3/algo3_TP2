package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.Modelo.entidades.Pieza;
import edu.fiuba.algoChess.Modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.Modelo.entorno.Tablero;
import edu.fiuba.algoChess.Modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.Modelo.excepciones.*;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.vista.DialogoAlerta;
import edu.fiuba.algoChess.interfaz.vista.SegundaEtapa;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;

import javax.swing.*;
import javax.tools.Diagnostic;
import java.util.Optional;


@AllArgsConstructor
public class CurarPiezaHandler implements EventHandler<ActionEvent> {
	Juego juego;
	Pieza emisor;
	TextField tFX;
	TextField tFY;
	Stage stage;
	SegundaEtapa segundaEtapa;

	@Override
	public void handle(ActionEvent actionEvent) {
		int x = Integer.parseInt((tFX.getText()));
		int y = Integer.parseInt((tFY.getText()));
		try {
			Pieza receptor = juego.getTablero().getCelda(new Ubicacion(x,y)).getPiezaActual();
			if(receptor.getClass() != PiezaNull.class) {
				emisor.curar(receptor);
				stage.close();
				segundaEtapa.cambioTurno();
				DialogoAlerta.Alerta("Curacion", "Curacion efectuada, vida restante del aliado: " + receptor.getVida().getValorActual(), 2);
			}
		} catch(NoSePuedeCurarUnaUnidadEnemigaException exc){
			DialogoAlerta.Alerta("Curacion a un Enemigo", "No se puede curar a un enemigo", 2);
		} catch(NoSePuedeObtenerUnaPiezaDeCeldaaNull ex){
			DialogoAlerta.Alerta("Curacion a vacio", "No se puede curar a una celda vacia", 2);
		} catch(NoSePuedeCurarUnaCatapultaException ex){
			DialogoAlerta.Alerta("Curacion a catapulta", "No se puede curar a una catapulta", 2);
		}catch (FueraDeRangoParaEjecutarComportamientoException ex) {
			DialogoAlerta.Alerta("Muy lejos", "No se puede curar a una pieza tan lejana", 2);
		}
	}
}