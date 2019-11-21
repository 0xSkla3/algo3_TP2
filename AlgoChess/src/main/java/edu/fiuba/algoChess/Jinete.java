package edu.fiuba.algoChess;

import static java.lang.Math.abs;
public class Jinete extends Pieza {

	private int ataqueMedio;
	private int ataqueCercano;
	private int ataqueLejano;

	public boolean piezaAliadaCercana;
	public boolean piezaEnemigaCercana;
	private int distanciaAReconocerEnTerreno;


	public Jinete(Ubicacion ubicacion, int costo, int vida) {
		super(ubicacion, costo, vida);
	}

	public Jinete() {

		super(3, 100);
		//this.nombre = TipoPieza.JINETE;
		this.ataqueCercano = 5;
		this.ataqueMedio = 15;
		this.ataqueLejano = 0;
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


	public void ejecutarComportamiento(DistanciaRelativa distancia, Pieza atacado){
		if (distancia==DistanciaRelativa.LEJANO){
			atacado.bajarVida(this.ataqueLejano);
		};
		if ((distancia==DistanciaRelativa.CERCANO)&&(!(this.getPiezaAliadaCercana()))){
			atacado.bajarVida(this.ataqueCercano);
		};
		if ((distancia==DistanciaRelativa.MEDIO)&&((this.getPiezaAliadaCercana())||(!(this.getPiezaEnemigaCercana())))){
			atacado.bajarVida(this.ataqueMedio);
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
			if (!celda.isEmpty() && (celda.getPiezaActual().getJugador() == this.getJugador())){
				piezaAliadaCercana = true;
				continue;
			}
			else if (!celda.isEmpty() && (celda.getPiezaActual().getJugador() != this.getJugador())){
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


//	public void atacar(DistanciaRelativa.LEJANO distancia, Pieza atacado){
//		atacado.bajarVida(this.ataqueLejano);
//	}
//	public void atacar(DistanciaRelativa.CERCANO distancia, Pieza atacado){
//		atacado.bajarVida(this.ataqueCercano);
//	}
//	public void atacar(DistanciaRelativa.MEDIO distancia, Pieza atacado){
//		atacado.bajarVida(this.ataqueLejano);
//	}


	public int getAtaqueMedio(){
		return this.ataqueMedio;
	};

	public int getAtaqueCercano(){
		return this.ataqueCercano;
	};

	public int getAtaqueLejano(){
		return this.ataqueLejano;
	};
}


