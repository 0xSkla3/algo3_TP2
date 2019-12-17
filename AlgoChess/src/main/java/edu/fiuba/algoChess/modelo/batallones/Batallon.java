package edu.fiuba.algoChess.modelo.batallones;

import edu.fiuba.algoChess.modelo.entidades.Movible;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeMoverUnBatallonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public abstract class Batallon extends Movible {

	@Setter
	@Getter
	Pieza pieza1;

	@Setter
	@Getter
	Pieza pieza2;

	@Setter
	@Getter
	Pieza pieza3;

	public static Batallon darDeAltaBatallon(Pieza soldado) {
		ArrayList<Pieza> soldadosBatallon;
		soldadosBatallon = BatallonUtil.armarPosibleBatallon(soldado);
		try {
			BatallonUtil batallonUtil = new BatallonUtil();
			batallonUtil.setPieza1(soldadosBatallon.get(0));
			batallonUtil.setPieza2(soldadosBatallon.get(1));
			batallonUtil.setPieza3(soldadosBatallon.get(2));
			return batallonUtil;
		} catch (IndexOutOfBoundsException ex) {
			return new BatallonNull();
		}
	}

	public static Batallon batallonAsociadoONull(Pieza soldado1){
		Batallon batallon = new BatallonNull();
		batallon = darDeAltaBatallon(soldado1);
		return batallon;
	}

	public static boolean esBatallon(Pieza soldado1, Pieza soldado2, Pieza soldado3) {
		ArrayList<Pieza> soldadosBatallon = new ArrayList<>();

		soldadosBatallon = BatallonUtil.armarPosibleBatallon(soldado1);
		return (soldadosBatallon.size()>=2);
	}

	public Batallon moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){

		throw new NoSePuedeMoverUnBatallonNull("No se puede mover un batallon null");
	}

}
