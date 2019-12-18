package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.interfaz.vista.DialogoAlerta;
import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.UbicacionEnSectorInvalidoException;
import edu.fiuba.algoChess.modelo.excepciones.CeldaYaOcupadaException;
import edu.fiuba.algoChess.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CrearPiezaHandler implements EventHandler<ActionEvent> {
	Juego juego;
	String nombrePieza;
	TextField x;
	TextField y;
	HBox head;
	Stage stageUbicar;
	PantallaPrincipal pantallaPrincipal;

	@Override
	public void handle(ActionEvent actionEvent) {
		int x = Integer.parseInt((this.x.getText()));
		int y = Integer.parseInt((this.y.getText()));
		Ubicacion ubicacion = new Ubicacion(x, y);
		try {
			juego.crearPieza(nombrePieza, ubicacion);
			pantallaPrincipal.cambioTurno(head);
			stageUbicar.close();
		} catch(UbicacionEnSectorInvalidoException exc){
			DialogoAlerta.Alerta("Sector rival", "No se puede ubicar la pieza en el sector rival", 2);
		} catch(CeldaYaOcupadaException ex){
			DialogoAlerta.Alerta( "Celda ocupada", "No se puede ubicar la pieza en una celda ocupada", 2);
		}
	}
}
