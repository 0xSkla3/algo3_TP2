package edu.fiuba.algoChess;

//import org.jetbrains.annotations.NotNull;

public class Jinete extends Pieza {

	private int ataqueLejano;
	private int ataqueCercano;

	public Jinete(Ubicacion ubicacion, int costo, int vida) {
		super(ubicacion, costo, vida);
	}

	public Jinete() {

		super(3, 100);
		//this.nombre = TipoPieza.JINETE;
		this.ataqueCercano = 5;
		this.ataqueLejano = 15;

	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCelda(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}

/*	public Posicion getPosicionRelativa(Pieza pieza){
		Ubicacion atacado = pieza.getUbicacion();
		Ubicacion ubicacionAtacante = this.getUbicacion();
	}//no veo como resolver esto

	public void ejecutarComportamiento(Pieza atacado) {

		Posicion posicion = getPosicionRelativa(atacado);
		this.atacar(posicion);
		Cercano posicion1 = getPosicionRelativa(atacado);
	}*/



/*	public void atacar(Lejano posicion, Pieza atacado){
		atacado.bajarVida(this.ataqueLejano);
	}
	public void atacar(Cercano posicion, Pieza atacado){
		atacado.bajarVida(this.ataqueCercano);
	}
	public void atacar(Medio posicion, Pieza atacado){
		atacado.bajarVida(this.ataqueLejano);
	}
*/




	//public int getAtaqueCercano() {
	//	return this.ataqueCercano;
	//}

	//public Posicion getPosicionRelativa(Pieza unaPieza){

	//}

	//public void atacarSegun(Posicion posicion){

	//	if (posicion==Lejano){

	//	}
	//}

	//public int getAtaqueLejano() {
	//	return this.ataqueLejano;
	//}

	//public void atacarCercano(Pieza atacado) {
	//	atacado.bajarVida(this.ataqueCercano);
	//}

	//;

	//public void atacarLejano(Pieza atacado) {

	//	atacado.bajarVida(this.ataqueLejano);
	//}

	;
}