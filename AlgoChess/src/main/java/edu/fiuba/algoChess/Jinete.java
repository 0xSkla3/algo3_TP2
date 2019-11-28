package edu.fiuba.algoChess;

import java.util.ArrayList;

import static java.lang.Math.abs;
public class Jinete extends Pieza {

	private AtaqueMedio ataqueMedio;
	private AtaqueCercano ataqueCercano;
	private int danioCercano = 5;
	private int danioMedio = 15;

	public boolean piezaAliadaCercana;
	public boolean piezaEnemigaCercana;
	private int distanciaAReconocerEnTerreno;


	public Jinete(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo, vida, ubicacion, bando);
	}

	public Jinete() {

		super(3, 100);
		this.ataqueCercano = new AtaqueCercano(danioCercano);
		this.ataqueMedio = new AtaqueMedio(danioMedio);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;

	}

	public Jinete(Ubicacion ubicacion,Bando bando){

		super(3, 100,ubicacion,bando);
		this.ataqueCercano = new AtaqueCercano(danioCercano);
		this.ataqueMedio = new AtaqueMedio(danioMedio);
		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;


	}


	public Jinete(Ubicacion ubicacion) {
		super(ubicacion);
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
		campoDeBatalla.ubicarEnCelda(this, ubicacion);
		campoDeBatalla.eliminar(this.ubicacion);
		this.ubicacion = ubicacion;
	}

	@Override
	public void actualizaRango(Tablero tablero) {

	}

	@Override
	public Rango getRango() {
		return null;
	}

	@Override
	public void unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		//throw new IllegalStateException("Un jinete no se puede unir a un batallon de Soldado");
	}

	@Override
	public void aniadirPiezaAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
	}

	@Override
	public void aniadirSoldadoAlStack(ArrayList<Pieza> stack) {

	}

	@Override
	public void aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {

	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		return null;
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return false;
	}


	public void atacar(DistanciaRelativa distancia, Pieza atacado){
		//if (distancia==DistanciaRelativa.LEJANO){
		//	atacado.recibirAtaque(this.ataque);
		//};
		if ((distancia==DistanciaRelativa.CERCANO)&&(!(this.getPiezaAliadaCercana()))){
			atacado.recibirAtaque(this.ataqueCercano);
		};
		if ((distancia==DistanciaRelativa.MEDIO)&&((this.getPiezaAliadaCercana())||(!(this.getPiezaEnemigaCercana())))){
			atacado.recibirAtaque(this.ataqueMedio);
		}
			}

			//COMENTARIO: EL JINETE DEBERIA CORRER EL METODO RECONOCERTERRENO CADA VEZ QUE SE MUEVE PARA ACTUALIZAR LOS VALORES DE SUS ATRIBUTOS
			//PIEZAALIADACERCA Y PIEZAENEMIGACERCANA. DE OTRO MODO, LOS VALORES QUEDARIAN SETEADOS HACIENDO REFERENCIA A LA POSICION ANTERIOR
			//LO CUAL PUEDE DEJAR DE SER VALIDO EN LA NUEVA POSICION
	//@Override
	public void reconocerTerreno(Tablero campoDeBatalla){

	int coordenadaX = this.ubicacion.getCoordenadaX();
	int coordenadaY = this.ubicacion.getCoordenadaY();

	for (int i = coordenadaX-distanciaAReconocerEnTerreno; i <= coordenadaX+distanciaAReconocerEnTerreno; i++) {
		if (i<1 || i>20){
			continue;
		}
		for (int j = coordenadaY-distanciaAReconocerEnTerreno; j <= coordenadaX+distanciaAReconocerEnTerreno; j++) {
			if (j<1 || j>20){
				continue;
			}
			Ubicacion ubicacion = new Ubicacion(i,j);
			if (ubicacion.equals(this.getUbicacion()) ){
				continue;
			}
			Celda celda = campoDeBatalla.getCelda(ubicacion);
			if (!celda.isEmpty() && (celda.getPiezaActual().getBando().equals(this.bando) )){
				piezaAliadaCercana = true;
				continue;
			}
			else if (!celda.isEmpty() && !(celda.getPiezaActual().getBando().equals(this.bando))){
				piezaEnemigaCercana = true;
				continue;
			}
		}
	}
}

	public boolean getPiezaAliadaCercana(){
			return this.piezaAliadaCercana;
	}

	public boolean getPiezaEnemigaCercana(){
		return this.piezaEnemigaCercana;
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
		atacado.recibirAtaque(this.ataqueLejano);
	}
	public void atacar(Cercano posicion, Pieza atacado){
		atacado.recibirAtaque(this.ataqueCercano);
	}
	public void atacar(Medio posicion, Pieza atacado){
		atacado.recibirAtaque(this.ataqueLejano);
	}
*/


	//public int getAtaqueCercano() {
	//	return this.ataqueCercano;
	//}


//	public void atacar(DistanciaRelativa.LEJANO distancia, Pieza atacado){
//		atacado.recibirAtaque(this.ataqueLejano);
//	}
//	public void atacar(DistanciaRelativa.CERCANO distancia, Pieza atacado){
//		atacado.recibirAtaque(this.ataqueCercano);
//	}
//	public void atacar(DistanciaRelativa.MEDIO distancia, Pieza atacado){
//		atacado.recibirAtaque(this.ataqueLejano);
//	}


	public int getDanioMedio(){
		return this.danioMedio;
	};

	public int getDanioCercano(){
		return this.danioCercano;
	};

	public Ataque getAtaqueMedio(){
		return this.ataqueMedio;
	};

	public Ataque getAtaqueCercano(){
		return this.ataqueCercano;
	};

}


