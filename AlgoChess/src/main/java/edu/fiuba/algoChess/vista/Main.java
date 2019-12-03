package edu.fiuba.algoChess;


import java.io.FileNotFoundException;

//import fiuba.algo3.AlgoChess.entidades.Soldado;
import edu.fiuba.algoChess.vista.InitialPhaseView;
import edu.fiuba.algoChess.vista.MapView;
import edu.fiuba.algoChess.vista.PieceView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.css.*;
/*import main.java.com.fiuba.algo3.controller.MainKeyboardController;
import main.java.com.fiuba.algo3.modelo.Player;
import main.java.com.fiuba.algo3.modelo.Position;
import main.java.com.fiuba.algo3.modelo.Map;*/
public class Main extends Application {


  private PieceView player;
  private MapView mapView;

  public static void main(String[] args) {
      launch(args);
  }

  public void start(Stage theStage) {
	  //inicio
	  //ingresar datos jugador

      InitialPhaseView initialPhase = new InitialPhaseView();//jugador1 y jugador2
      

      //jugar
  }

}

