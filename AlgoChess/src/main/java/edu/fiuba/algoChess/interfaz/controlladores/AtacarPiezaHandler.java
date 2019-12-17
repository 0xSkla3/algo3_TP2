package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.interfaz.vista.DialogoAlerta;
import edu.fiuba.algoChess.interfaz.vista.SegundaEtapa;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.*;
import edu.fiuba.algoChess.modelo.juego.Juego;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AtacarPiezaHandler implements EventHandler<ActionEvent> {
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
			Pieza receptor = juego.getTablero().getCelda(new Ubicacion(x, y)).getPiezaActual();
			if (receptor.getClass() != PiezaNull.class) {
				juego.atacar(emisor, receptor);
				stage.close();
				segundaEtapa.cambioTurno();
				if(receptor.getVida().stateEstaVivo())
					DialogoAlerta.Alerta("Ataque", "Ataque efectuado, vida restante del oponente: " + receptor.getVida().getValorActual(), 2);
				else
					DialogoAlerta.Alerta("Ataque", "Ataque efectuado, oponente muerto", 2);
			}
		} catch (NoSePuedeAtacarUnAliadoException exc) {
			DialogoAlerta.Alerta("Ataque a un Aliado", "No se puede atacar a un aliado", 2);
		} catch (NoSePuedeObtenerUnaPiezaDeCeldaaNull ex) {
			DialogoAlerta.Alerta("Ataque a vacio", "No se puede atacar a una celda vacia", 2);
		} catch (FueraDeRangoParaEjecutarComportamientoException ex) {
			DialogoAlerta.Alerta("Fuera de rango", "Pieza fuera de rango para el ataque", 2);
		}
	}
}
