package edu.fiuba.algoChess.interfaz.vista;


import edu.fiuba.algoChess.modelo.juego.Jugador;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lombok.Setter;

public class VistaJugador {
	private VBox jugadorBox;
 	private Jugador jugador;
	private Text nombre;
	private Text info;

	@Setter
	private boolean mostrarCreditos = true;

	public VistaJugador(Jugador jugador) {

		this.jugador = jugador;
		this.jugadorBox = new VBox();
	 	jugadorBox.setStyle("-fx-spacing:15;-fx-alignment:center");
	}
	
	public void instanciarVista(HBox hbox) {
		this.jugadorBox.setId("player");
		this.nombre = new Text();
		this.nombre.setStyle("-fx-font-size:50px");
		this.jugadorBox.getChildren().add(this.nombre);
		this.info = new Text();
		this.info.setStyle("-fx-font-size:30px");
		this.jugadorBox.getChildren().add(this.info);
		hbox.getChildren().add(jugadorBox);
		this.actualizarVista();
	}

	public void actualizarVista() {
	// FIXME: sacar esto si se garantiza que no se llama antes de viewPlayer()
	 if(this.nombre == null)
	 return;
	 this.nombre.setText(this.jugador.getNombre());
	 if(this.mostrarCreditos)
	 	this.info.setText("Créditos: " + this.jugador.getCreditos());
	 else
	 	this.info.setText("Puntaje: " + this.jugador.getPuntaje());
	 }
}
