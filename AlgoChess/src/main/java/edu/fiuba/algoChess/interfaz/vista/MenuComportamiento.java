package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.entidades.Curandero;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.controlladores.AtacarPiezaHandler;
import edu.fiuba.algoChess.interfaz.controlladores.CurarPiezaHandler;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

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
			DialogoAlerta.Alerta("Batallon", "Batallon Creado", 2);
			stage.close();
		});

		vbox.getChildren().addAll(atacar, batallonear);

		Scene theScene = new Scene(vbox);
		stage.setScene(theScene);
		stage.show();

	}

	private void generarBatallon(Pieza emisor) {
		emisor.darDeAltaBatallon();
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
			Stage stageUbicar = new Stage();
			VBox vbox = new VBox();

			Label labelx = new Label("Ubicacion x:");
			TextField x = new TextField ();
			HBox hbx = new HBox();
			hbx.getChildren().addAll(labelx, x);
			hbx.setSpacing(10);

			Label labely = new Label("Ubicacion y:");
			TextField y = new TextField ();
			HBox hby = new HBox();
			hby.getChildren().addAll(labely, y);
			hby.setSpacing(10);

			Button submit = new Button("atacar");
			submit.setStyle("-fx-background-color:#F1C40F;");
			submit.setOnAction(new AtacarPiezaHandler(juego, emisor, x, y, stageUbicar, segundaEtapa));
			vbox.getChildren().addAll(hbx,hby,submit);
			Scene sceneUbicar = new Scene(vbox);
			stageUbicar.setScene(sceneUbicar);
			stageUbicar.show();
	}

	public void menuCurar() {
		Stage stageUbicar = new Stage();
		VBox vbox = new VBox();

		Label labelx = new Label("Ubicacion x:");
		TextField x = new TextField ();
		HBox hbx = new HBox();
		hbx.getChildren().addAll(labelx, x);
		hbx.setSpacing(10);

		Label labely = new Label("Ubicacion y:");
		TextField y = new TextField ();
		HBox hby = new HBox();
		hby.getChildren().addAll(labely, y);
		hby.setSpacing(10);

		Button submit = new Button("curar");
		submit.setStyle("-fx-background-color:#F1C40F;");
		submit.setOnAction(new CurarPiezaHandler(juego, emisor, x, y, stageUbicar, segundaEtapa));
		vbox.getChildren().addAll(hbx,hby,submit);
		Scene sceneUbicar = new Scene(vbox);
		stageUbicar.setScene(sceneUbicar);
		stageUbicar.show();
	}
}
