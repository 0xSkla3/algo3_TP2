package edu.fiuba.algoChess;


//import fiuba.algo3.AlgoChess.entidades.Soldado;
import edu.fiuba.algoChess.interfaz.vista.Inicio;
import edu.fiuba.algoChess.interfaz.vista.PantallaPrincipal;
import edu.fiuba.algoChess.interfaz.vista.MapView;
import edu.fiuba.algoChess.interfaz.vista.PieceView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*import main.java.com.fiuba.algo3.controller.MainKeyboardController;
import main.java.com.fiuba.algo3.modelo.Player;
import main.java.com.fiuba.algo3.modelo.Position;
import main.java.com.fiuba.algo3.modelo.Map;*/
public class AlgoChessApp extends Application {


    private PieceView player;
    private MapView mapView;
/*
  public static void main(String[] args) {
      launch(args);
  }

  public void start(Stage theStage) {
	  //inicio
	  //ingresar datos jugador

      PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();//jugador1 y jugador2
      

      //jugar
  }

}
*/


    // public static class AlgoCraftApp extends Application {
    private Inicio inicio;
    //private static Juego juego;
   // private static final int ANCHO = 564;
   // private static final int ALTO = 564;

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoChess");
        inicio = new Inicio(stage);
        Scene scene = new Scene(inicio, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}