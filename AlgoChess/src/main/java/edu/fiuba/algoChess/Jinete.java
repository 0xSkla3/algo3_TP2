package edu.fiuba.algoChess;

//import org.jetbrains.annotations.NotNull;

public class Jinete extends Ficha {

	private int ataqueLejano;
	private int ataqueCercano;

	public Jinete(Ubicacion ubicacion, int costo, int vida) {
		super(ubicacion, costo, vida);
	}

	public Jinete() {

		super(3, 100);
		//this.nombre = TipoFicha.JINETE;
		this.ataqueCercano = 5;
		this.ataqueLejano = 15;

	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCelda(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}

	public Posicion getPosicionRelativa(Ficha ficha){
		Ubicacion atacado = ficha.getUbicacion();
		Ubicacion ubicacionAtacante = this.getUbicacion();
	}//no veo como resolver esto

	public void ejecutarComportamiento(Ficha atacado) {

		Posicion posicion = getPosicionRelativa(atacado);
		this.atacar(posicion);
		Cercano posicion1 = getPosicionRelativa(atacado);
	}



	public void atacar(Lejano posicion, Ficha atacado){
		atacado.bajarVida(this.ataqueLejano);
	}
	public void atacar(Cercano posicion, Ficha atacado){
		atacado.bajarVida(this.ataqueCercano);
	}
	public void atacar(Medio posicion, Ficha atacado){
		atacado.bajarVida(this.ataqueLejano);
	}





	//public int getAtaqueCercano() {
	//	return this.ataqueCercano;
	//}

	//public Posicion getPosicionRelativa(Ficha unaFicha){

	//}

	//public void atacarSegun(Posicion posicion){

	//	if (posicion==Lejano){

	//	}
	//}

	//public int getAtaqueLejano() {
	//	return this.ataqueLejano;
	//}

	//public void atacarCercano(Ficha atacado) {
	//	atacado.bajarVida(this.ataqueCercano);
	//}

	//;

	//public void atacarLejano(Ficha atacado) {

	//	atacado.bajarVida(this.ataqueLejano);
	//}

	;
}