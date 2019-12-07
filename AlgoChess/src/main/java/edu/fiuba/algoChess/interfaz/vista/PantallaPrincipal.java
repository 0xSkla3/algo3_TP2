package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;

public class PantallaPrincipal {
	private Stage stage;
	private PieceView pieceView;
	private MapView mapView;
	private PlayerView player1;
	private PlayerView player2;
	private PlayerView turn;
	private HashMap<String,String> listaImage;
	private Juego juego;
	
	public PantallaPrincipal(String jugador1, String jugador2, Stage stage) {
		this.stage = stage;
		//this.stage = new Stage();
		this.juego = new Juego();
		this.pieceView = new PieceView( listaImage, juego);
		this.mapView = new MapView();//tamanio del tablero

		this.player1 =  new PlayerView(jugador1);
		this.player2 =  new PlayerView(jugador2);

		initialPhase();
	}
	
	public void initialPhase(){//player1 and player2

		this.stage.setTitle("AlgoChess");
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		
		vbox.getChildren().add(head()); 
	    
		player1.viewPlayer(hbox);
	    hbox.getChildren().add(mapView);
	    player2.viewPlayer(hbox);
	    
	    vbox.getChildren().add(hbox); 
	    
	    Scene theScene = new Scene(vbox);
	    theScene.getStylesheets().add("css/estilo.css");
	    this.stage.setScene(theScene);
	    this.stage.show();
	   // stage.setFullScreen(true);
	}
	
	public HBox head() {
		HBox head = new HBox();
	    head.setId("head");
	    
	    Image imgSoldado = new Image("imagenes/soldado.jpeg",80,80,false,false);
	    ImageView soldado = new ImageView(imgSoldado);
	    menuPiece(soldado,"soldado",head);
	    
	    Image imgJinete = new Image("imagenes/jinete.jpeg",80,80,false,false);
	    ImageView jinete = new ImageView(imgJinete);
	    menuPiece(jinete,"jinete",head);
	    
	    Image imgCatapulta = new Image("imagenes/catapulta.jpeg",80,80,false,false);
	    ImageView catapulta = new ImageView(imgCatapulta);
	    menuPiece(catapulta,"catapulta",head);
	    
	    Image imgCurandero = new Image("imagenes/curandero.jpeg",80,80,false,false);
	    ImageView curandero= new ImageView(imgCurandero);
	    menuPiece(curandero,"curandero",head);
	    
	    head.getChildren().addAll(soldado,jinete,catapulta,curandero);
	    turnOf(head,player1);
	    return head;
	}
	
	public void menuPiece(ImageView piece,String namePiece,HBox head) {
	
		piece.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			
            @Override
            public void handle(MouseEvent event) {
            	Stage stage = new Stage();
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
            	
            	Button submit = new Button("ubicar");
            	submit.setStyle("-fx-background-color:#F1C40F;");
            	submit.setOnAction(new EventHandler<ActionEvent>() {
            	    @Override 
            	    public void handle(ActionEvent e) {
            	    	pieceView.setPieceMap(mapView,namePiece, Integer.parseInt(x.getText()),Integer.parseInt(y.getText()));
            	    	cambioTurno(head,namePiece);
            	    	stage.close();
            	    }
            	});
            	
            	vbox.getChildren().addAll(hbx,hby,submit);
            	Scene theScene = new Scene(vbox);
        	    stage.setScene(theScene);
        	    stage.show();
            }
        });	
	}
	
	public void cambioTurno(HBox head, String namePiece) {
		head.getChildren().remove(4);
		
		this.turn.setPiece(pieceView.getImageViewMax(namePiece));
		if(this.turn == player1) {
			turnOf(head,player2);
		}
		else {
			turnOf(head,player1);
		}
		
	}
	
	public void turnOf(HBox head,PlayerView player){
		this.turn = player;
		Button button = new Button("TURNO DE: "+player.getName());
		button.setStyle("-fx-background-color:#F7CF32");
		head.getChildren().add(button);
	}

}

