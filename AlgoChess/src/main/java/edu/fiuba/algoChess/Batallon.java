package edu.fiuba.algoChess;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class Batallon implements Movible{

	@Setter
	@Getter

	Soldado soldado1;

	@Setter
	@Getter
	Soldado soldado2;

	@Setter
	@Getter
	Soldado soldado3;


	@Override
	public void moverseALaDerecha(Tablero campoDeBatalla) {

		Ubicacion ubicacionDerecha1 = getSoldado1().ubicacion.getUbicacionDerecha();
		Ubicacion ubicacionDerecha2 = getSoldado2().ubicacion.getUbicacionDerecha();
		Ubicacion ubicacionDerecha3 = getSoldado3().ubicacion.getUbicacionDerecha();
		this.mover(campoDeBatalla, ubicacionDerecha1, ubicacionDerecha2, ubicacionDerecha3);

	}

	@Override
	public void moverseALaIzquierda(Tablero campoDeBatalla) {
		Ubicacion ubicacionIzquierda1 = getSoldado1().ubicacion.getUbicacionIzquierda();
		Ubicacion ubicacionIzquierda2 = getSoldado2().ubicacion.getUbicacionIzquierda();
		Ubicacion ubicacionIzquierda3 = getSoldado3().ubicacion.getUbicacionIzquierda();
		this.mover(campoDeBatalla, ubicacionIzquierda1, ubicacionIzquierda2, ubicacionIzquierda3);
	}

	@Override
	public void moverseArriba(Tablero campoDeBatalla) {
			Ubicacion ubicacionArriba1 = getSoldado1().ubicacion.getUbicacionArriba();
			Ubicacion ubicacionArriba2 = getSoldado2().ubicacion.getUbicacionArriba();
			Ubicacion ubicacionArriba3 = getSoldado3().ubicacion.getUbicacionArriba();
			this.mover(campoDeBatalla, ubicacionArriba1, ubicacionArriba2, ubicacionArriba3);
	}

	@Override
	public void moverseAbajo(Tablero campoDeBatalla) {
		Ubicacion ubicacionAbajo1 = getSoldado1().ubicacion.getUbicacionAbajo();
		Ubicacion ubicacionAbajo2 = getSoldado2().ubicacion.getUbicacionAbajo();
		Ubicacion ubicacionAbajo3 = getSoldado3().ubicacion.getUbicacionAbajo();
		this.mover(campoDeBatalla, ubicacionAbajo1, ubicacionAbajo2, ubicacionAbajo3);
	}

	@Override
	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){
		campoDeBatalla.eliminar(getSoldado1().getUbicacion());
		campoDeBatalla.eliminar(getSoldado2().getUbicacion());
		campoDeBatalla.eliminar(getSoldado3().getUbicacion());

		getSoldado1().mover(campoDeBatalla,ubicacion1);
		getSoldado2().mover(campoDeBatalla,ubicacion2);
		getSoldado3().mover(campoDeBatalla,ubicacion3);

	}


}
