package edu.fiuba.algoChess;

import lombok.*;

import java.util.*;

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

	public static boolean esBatallon(Soldado soldado1, Soldado soldado2, Soldado soldado3, Tablero tablero){
		RangoSoldado rango1 = new RangoSoldado();
		RangoSoldado rango2 = new RangoSoldado();
		RangoSoldado rango3 = new RangoSoldado();
		Set<Soldado> ctoAuxiliar = null;
		List<Soldado> listaAuxiliar = new java.util.ArrayList<>(Collections.emptyList());

		rango1.actualizaRango(soldado1,tablero);
		rango2.actualizaRango(soldado2,tablero);
		rango3.actualizaRango(soldado3,tablero);

		listaAuxiliar.addAll(rango1.getSoldadosContiguos());
		listaAuxiliar.addAll(rango2.getSoldadosContiguos());
		listaAuxiliar.addAll(rango3.getSoldadosContiguos());

 		ctoAuxiliar = new HashSet<Soldado>(listaAuxiliar);

 		if (ctoAuxiliar.size()>2) {
 			return true;
		}else {
 			return  false;
		}

	}

	public static Batallon batallonAsociadoONull(Soldado soldado1, Tablero tablero){
		soldado1.actualizaRango(tablero);
		ArrayList<Soldado> contiguosA1 = soldado1.getRango().getSoldadosContiguos();

		if(contiguosA1.size() > 1) {
			return new Batallon(soldado1, contiguosA1.get(0),contiguosA1.get(1));
		} else if (contiguosA1.size() == 1) {
			Soldado soldado2 = contiguosA1.get(0);
			soldado2.actualizaRango(tablero);
			ArrayList<Soldado> contiguosA2 = soldado2.getRango().getSoldadosContiguos();
			if(contiguosA2.size() > 1) {
				return new Batallon(contiguosA2.get(0), soldado2,contiguosA2.get(1));
			}
		}
		return null;
	}

	public Boolean equals(Batallon batallon){
		Set<Soldado> itemsBatallonActual = new HashSet<>();
		Set<Soldado>itemsBatallonAComparar = new HashSet<>();

		itemsBatallonActual.add(this.getSoldado1());
		itemsBatallonActual.add(this.getSoldado2());
		itemsBatallonActual.add(this.getSoldado3());

		itemsBatallonAComparar.add(batallon.getSoldado1());
		itemsBatallonAComparar.add(batallon.getSoldado2());
		itemsBatallonAComparar.add(batallon.getSoldado3());

		return itemsBatallonActual.equals(itemsBatallonAComparar);
	}

}
