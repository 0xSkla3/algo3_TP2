package edu.fiuba.algoChess;

import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
public class BatallonUtil implements Movible, Batallon, Agrupable {

	@Setter
	@Getter
	Pieza pieza1;

	@Setter
	@Getter
	Pieza pieza2;

	@Setter
	@Getter
	Pieza pieza3;

	/*public static boolean esBatallon(Soldado soldado1, Soldado soldado2, Soldado soldado3) {
		Batallon unBatallon = crearBatallon(soldado1, soldado2, soldado3);
		return unBatallon.getPieza1() != null;
	}*/

	@Override
	public void moverseALaDerecha(Tablero campoDeBatalla) {

		Ubicacion ubicacionDerecha1 = getPieza1().ubicacion.getUbicacionDerecha();
		Ubicacion ubicacionDerecha2 = getPieza2().ubicacion.getUbicacionDerecha();
		Ubicacion ubicacionDerecha3 = getPieza3().ubicacion.getUbicacionDerecha();
		this.mover(campoDeBatalla, ubicacionDerecha1, ubicacionDerecha2, ubicacionDerecha3);

	}

	@Override
	public void moverseALaIzquierda(Tablero campoDeBatalla) {
		Ubicacion ubicacionIzquierda1 = getPieza1().ubicacion.getUbicacionIzquierda();
		Ubicacion ubicacionIzquierda2 = getPieza2().ubicacion.getUbicacionIzquierda();
		Ubicacion ubicacionIzquierda3 = getPieza3().ubicacion.getUbicacionIzquierda();
		this.mover(campoDeBatalla, ubicacionIzquierda1, ubicacionIzquierda2, ubicacionIzquierda3);
	}

	@Override
	public void moverseArriba(Tablero campoDeBatalla) {
			Ubicacion ubicacionArriba1 = getPieza1().ubicacion.getUbicacionArriba();
			Ubicacion ubicacionArriba2 = getPieza2().ubicacion.getUbicacionArriba();
			Ubicacion ubicacionArriba3 = getPieza3().ubicacion.getUbicacionArriba();
			this.mover(campoDeBatalla, ubicacionArriba1, ubicacionArriba2, ubicacionArriba3);
	}

	@Override
	public void moverseAbajo(Tablero campoDeBatalla) {
		Ubicacion ubicacionAbajo1 = getPieza1().ubicacion.getUbicacionAbajo();
		Ubicacion ubicacionAbajo2 = getPieza2().ubicacion.getUbicacionAbajo();
		Ubicacion ubicacionAbajo3 = getPieza3().ubicacion.getUbicacionAbajo();
		this.mover(campoDeBatalla, ubicacionAbajo1, ubicacionAbajo2, ubicacionAbajo3);
	}

	@Override
	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion) {
	}

	public void mover(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){
		campoDeBatalla.eliminar(getPieza1().getUbicacion());
		campoDeBatalla.eliminar(getPieza2().getUbicacion());
		campoDeBatalla.eliminar(getPieza3().getUbicacion());

		getPieza1().mover(campoDeBatalla,ubicacion1);
		getPieza2().mover(campoDeBatalla,ubicacion2);
		getPieza3().mover(campoDeBatalla,ubicacion3);

	}

	/*public static boolean esBatallon(Soldado soldado1, Soldado soldado2, Soldado soldado3, Tablero tablero){
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

	} */

	/*public static Batallon batallonAsociadoONull(Pieza soldado1, Tablero tablero){
		soldado1.actualizaRango(tablero);
		ArrayList<Pieza> contiguosA1 = soldado1.getRango().getSoldadosContiguos();

		if(contiguosA1.size() > 1) {
			return new Batallon(soldado1, contiguosA1.get(0),contiguosA1.get(1));
		} else if (contiguosA1.size() == 1) {
			Pieza soldado2 = contiguosA1.get(0);
			soldado2.actualizaRango(tablero);
			ArrayList<Pieza> contiguosA2 = soldado2.getRango().getSoldadosContiguos();
			if(contiguosA2.size() > 1) {
				return new Batallon(contiguosA2.get(0), soldado2,contiguosA2.get(1));
			}
		}
		return null;
	}*/

	public Boolean equals(BatallonUtil batallon){
		Set<Pieza> itemsBatallonActual = new HashSet<>();
		Set<Pieza>itemsBatallonAComparar = new HashSet<>();

		itemsBatallonActual.add(this.getPieza1());
		itemsBatallonActual.add(this.getPieza2());
		itemsBatallonActual.add(this.getPieza3());

		itemsBatallonAComparar.add(batallon.getPieza1());
		itemsBatallonAComparar.add(batallon.getPieza2());
		itemsBatallonAComparar.add(batallon.getPieza3());

		return itemsBatallonActual.equals(itemsBatallonAComparar);
	}

	@Override
	public BatallonUtil agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3) {

		return null;
	}

	@Override
	public Collection<Pieza> desagrupar(Agrupable grupo) {
		return null;
	}

	@Override
	public void actualizaRango(Pieza piezaCentral, Tablero tablero) {

	}

	@Override
	public void actualizaPiezasEnRango(Pieza piezaCentral) {

	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		return null;
	}

	@Override
	public Batallon crearBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3) {
		return new BatallonUtil(pieza1, pieza2, pieza3);
	}


}
