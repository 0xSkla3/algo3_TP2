package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class SoldadoView implements Observer {
	private VistaTablero mapView;
	private Pieza pieza;
	private ImageView unitImage;
	private double vidaUnidad;
	private SaludView barraSalud;

	public SoldadoView(VistaTablero mapView, Pieza pieza) {
		this.mapView = mapView;
		this.pieza = this.pieza;
		vidaUnidad = pieza.getVida().getValorActual();

		unitImage = new ImageView();
		unitImage.setScaleX(2);
		unitImage.setScaleY(2);
		unitImage.setFitHeight(32);
		unitImage.setFitWidth(32);

		barraSalud = new SaludView(vidaUnidad);
		unitImage.setImage(getImage());
		//unitImage.setOnMouseClicked(new SoldadoController(this.pieza, this.mapView));
	}

	public Image getImage() {
		// Extraigo el sprite que me interesa del spritesheet usando la clase BufferedImage
		try {
			BufferedImage bf = ImageIO.read(new File("src/main/resources/imagenes/soldado.jpeg"));
			BufferedImage subimage = bf.getSubimage(4 * 48, 0, 48, 48);
			Image image = SwingFXUtils.toFXImage(subimage, null) ;
			return image;
		} catch(IOException e) {
			System.out.println("Error cargando imagen");
		}

		return new Image("soldado.jpeg");
	}

	public void change() {
		double vidaActual = pieza.getVida().getValorActual();

		if(vidaActual != vidaUnidad) {
			vidaUnidad = vidaActual;
			barraSalud.actualizarBarra(vidaUnidad);
		}
		mapView.addViewOnMap(unitImage, pieza.getUbicacion().getX(), pieza.getUbicacion().getY());
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}

