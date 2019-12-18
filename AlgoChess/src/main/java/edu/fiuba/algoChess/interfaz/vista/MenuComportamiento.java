package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.batallones.BatallonUtil;
import edu.fiuba.algoChess.modelo.entidades.Curandero;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.modelo.excepciones.*;
import edu.fiuba.algoChess.modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuComportamiento {
	Juego juego;
	Pieza emisor;
	SegundaEtapa segundaEtapa;

	public void menuComportamientoSoldado(){
		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button atacar = new Button("Atacar");
		atacar.setStyle("-fx-background-color:#F1C40F;");
		atacar.setOnAction(e -> {
			menuAtacar();
			stage.close();
		});

		Button batallonear = new Button("Generar Batallon");
		batallonear.setStyle("-fx-background-color:#F1C40F;");
		batallonear.setOnAction(e -> {
			generarBatallon(emisor);
			ReproductorSonidos.reproducir("agrupate");
			DialogoAlerta.Alerta("Batallon", "Batallon Creado", 2);
			stage.close();
		});

		vbox.getChildren().addAll(atacar, batallonear);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	private void generarBatallon(Pieza emisor) {
		BatallonUtil.darDeAltaBatallon(emisor);
		segundaEtapa.cambioTurno();
	}

	public void menuComportamientoJinete(){
	Stage stage = new Stage();
	VBox vbox = new VBox();

	Button atacar = new Button("Atacar");
		atacar.setStyle("-fx-background-color:#F1C40F;");
		atacar.setOnAction(e -> { menuAtacar();
		stage.close();
	});

	vbox.getChildren().addAll(atacar);

	Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();
	}

	public void menuComportamientoCatapulta(){
		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button atacar = new Button("Atacar");
		atacar.setStyle("-fx-background-color:#F1C40F;");
		atacar.setOnAction(e -> { menuAtacar();
			stage.close();
		});

		vbox.getChildren().addAll(atacar);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	public void menuComportamientoCurandero(){

		Stage stage = new Stage();
		VBox vbox = new VBox();

		Button curar = new Button("Curar");
		curar.setStyle("-fx-background-color:#F1C40F;");
		curar.setOnAction(e -> {
			menuCurar();
			stage.close();
		});

		vbox.getChildren().addAll(curar);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	public void menuAtacar() {
		DialogoAlerta.Alerta("Ataque", "Seleccione pieza a atacar", 1);
		this.segundaEtapa.getMapView().registrarControlador(ubicacion -> {
			this.segundaEtapa.getMapView().registrarControlador(null);

			try {
				Pieza receptor = juego.getTablero().getCelda(ubicacion).getPiezaActual();
				if (receptor.getClass() != PiezaNull.class) {
					juego.atacar(emisor, receptor);
					segundaEtapa.cambioTurno();
					if (receptor.getVida().stateEstaVivo()) {
						ReproductorSonidos.reproducir("sword");
						DialogoAlerta.Alerta("Ataque", "Ataque efectuado, vida restante del oponente: " + receptor.getVida().getValorActual(), 2);
					} else {
						ReproductorSonidos.reproducir("die");
						DialogoAlerta.Alerta("Ataque", "Ataque efectuado, oponente muerto", 2);
					}
				}
			} catch (InteraccionInvalidaException exc) {
				DialogoAlerta.Alerta("Ataque a un Aliado", "No se puede atacar a un aliado", 2);
			} catch (OperacionInvalidaSobreObjetoNuloException ex) {
				DialogoAlerta.Alerta("Ataque a vacio", "No se puede atacar a una celda vacia", 2);
			} catch (FueraDeRangoException ex) {
				DialogoAlerta.Alerta("Fuera de rango", "Pieza fuera de rango para el ataque", 2);
			}
		});
	}

	public void menuCurar() {
		DialogoAlerta.Alerta("Ataque", "Seleccione pieza a curar", 1);
		this.segundaEtapa.getMapView().registrarControlador(ubicacion -> {
			this.segundaEtapa.getMapView().registrarControlador(null);

			try {
				Pieza receptor = juego.getTablero().getCelda(ubicacion).getPiezaActual();
				if (receptor.getClass() != PiezaNull.class) {
					((Curandero)emisor).curar(receptor);
					ReproductorSonidos.reproducir("spell");
					segundaEtapa.cambioTurno();
					DialogoAlerta.Alerta("Curacion", "Curacion efectuada, vida restante del aliado: " + receptor.getVida().getValorActual(), 2);
				}
			} catch (InteraccionInvalidaException exc) {
				DialogoAlerta.Alerta("Curacion a un Enemigo", "No se puede curar ni a un enemigo ni a una catapulta", 2);
			} catch (OperacionInvalidaSobreObjetoNuloException ex) {
				DialogoAlerta.Alerta("Curacion a vacio", "No se puede curar a una celda vacia", 2);
			} catch (FueraDeRangoException ex) {
				DialogoAlerta.Alerta("Muy lejos", "No se puede curar a una pieza tan lejana", 2);
			}
		});
	}
}
