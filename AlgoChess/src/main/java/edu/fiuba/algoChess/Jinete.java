package edu.fiuba.algoChess;

import static java.lang.Math.abs;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
public class Jinete extends Pieza {


	private Comportamiento ataqueMedio = new ComportamientoMedio(15);
	private Comportamiento ataqueCercano = new AtaqueCercanoJinete(5);
	// = new ComportamientoCercano(5);

	private int danioCercano = 5; //PROPONGO QUE S ELIMINEN ESTAS LINEAS (LIO)
	private int danioMedio = 15;	//Y ESTA LINEA TAMBIEN (LIO)
	//private DistanciaRelativa calculadorDistancia = new DistanciaRelativa();

	//public ProximidadPieza aliado;//@@@@@@@@@@@
	//public ProximidadPieza enemigo;//@@@@@@@@@

	public boolean piezaAliadaCercana;
	public boolean piezaEnemigaCercana;
	private int distanciaAReconocerEnTerreno;


	public Jinete(Ubicacion ubicacion, int costo, int vida, Bando bando) {
		super(costo, vida, ubicacion, bando);
	}

	public Jinete() {

		super(3, 100);


		this.piezaEnemigaCercana = false;
		this.piezaAliadaCercana = false;
		this.distanciaAReconocerEnTerreno = 2;
	}

	public Jinete(Ubicacion ubicacion,Bando bando){

		super(3, 100,ubicacion,bando);
//		this.ataqueCercano = new AtaqueCercanoJinete(danioCercano);
//		this.ataqueMedio = new AtaqueMedioJinete(danioMedio);
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

	//DISPATCH

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		if(this.getPiezaAliadaCercana()){
			this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
		}
		else{
			this.bando.atacar(pieza, this.ataqueCercano, pieza.getBando());
		}
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		this.bando.atacar(pieza, this.ataqueMedio, pieza.getBando());
	};
	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
		};


	public void atacar(Pieza atacado){
		DistanciaRelativa distanciaEntrePiezas = this.calculadorDistancia.getDistanciaRelativa(this,atacado);
		distanciaEntrePiezas.ejecutarComportamientoPorDistancia(this, atacado);
	}
///@@@@@@@@@ PROBANDO ALGO DE CURACION
//	public void aplicarCuracionAPieza (Curandero curandero){
//		this.bando.curar(this,curandero.getCuracion(), this.bando);
//	}

///@@@@@
	public void reconocerTerreno(Tablero campoDeBatalla) {

		int coordenadaX = this.ubicacion.getCoordenadaX();
		int coordenadaY = this.ubicacion.getCoordenadaY();

		for (int i = coordenadaX - distanciaAReconocerEnTerreno; i <= coordenadaX + distanciaAReconocerEnTerreno; i++) {
			if (i < 1 || i > 20) {
				continue;
			}
			for (int j = coordenadaY - distanciaAReconocerEnTerreno; j <= coordenadaX + distanciaAReconocerEnTerreno; j++) {
				if (j < 1 || j > 20) {
					continue;
				}
				Ubicacion ubicacion = new Ubicacion(i, j);
				if (ubicacion.equals(this.getUbicacion())) {
					continue;
				}
				Celda celda = campoDeBatalla.getCelda(ubicacion);
				if (!celda.isEmpty() && (celda.getPiezaActual().getBando().equals(this.bando))) {
					piezaAliadaCercana = true;
					continue;
				} else if (!celda.isEmpty() && !(celda.getPiezaActual().getBando().equals(this.bando))) {
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
	};

	public int getDanioMedio(){
		return this.danioMedio;
	};

	public int getDanioCercano(){
		return this.danioCercano;
	};

	public Comportamiento getAtaqueMedio(){
		return this.ataqueMedio;
	};

	public Comportamiento getAtaqueCercano(){
		return this.ataqueCercano;
	};

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


//		DistanciaRelativaPosta distancia = this.getDistanciaRelativaPosta().getDistanciaRelativa(this, atacado);
//		this.seleccionarAtaque(distancia, atacado);
//		this.getAtaqueCercano().ejecutarComportamiento(this,atacado);
//		this.getAtaqueMedio().ejecutarComportamiento(this,atacado);
//	}
//	public void atacarPosta(Cercana distancia, Pieza atacado){
//		this.getAtaqueCercano().ejecutarComportamiento(this,atacado, );
//	};
//
//	public void atacarPosta(Media distancia, Pieza atacado){
//		this.getAtaqueMedio().ejecutarComportamiento(this,atacado);
//	}


//	public void atacar(DistanciaRelativa distancia, Pieza atacado){
//
//		//this.ataqueCercano.atacar(atacado); ESTOY LABURANDO ESTO AHORA@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//		//ACA VA LO MISMO QU EN LA LINEA ANTERIOR PERO CON LOS NOMBRE QUE ME GUSTAN A MI
//		//this.comportamientoCercano.ejecutarComportamiento(this, atacado);
//		//if (distancia==DistanciaRelativa.LEJANO){
//		//	atacado.recibirAtaque(this.ataque);
//		//};
//		if ((distancia==DistanciaRelativa.CERCANO)&&(!(this.getPiezaAliadaCercana()))){
//			atacado.recibirAtaque(this.ataqueCercano);
//		};
//		if ((distancia==DistanciaRelativa.MEDIO)&&((this.getPiezaAliadaCercana())||(!(this.getPiezaEnemigaCercana())))){
//			atacado.recibirAtaque(this.ataqueMedio);
//		}
//			}

	//COMENTARIO: EL JINETE DEBERIA CORRER EL METODO RECONOCERTERRENO CADA VEZ QUE SE MUEVE PARA ACTUALIZAR LOS VALORES DE SUS ATRIBUTOS
	//PIEZAALIADACERCA Y PIEZAENEMIGACERCANA. DE OTRO MODO, LOS VALORES QUEDARIAN SETEADOS HACIENDO REFERENCIA A LA POSICION ANTERIOR
	//LO CUAL PUEDE DEJAR DE SER VALIDO EN LA NUEVA POSICION
	//@Override


}


