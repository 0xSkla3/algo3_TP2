package edu.fiuba.algoChess.modelo.batallones;

import edu.fiuba.algoChess.modelo.entidades.Movible;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.AccionAgrupableInvalidaException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

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
			BatallonUtil batallonUtil = new BatallonUtil(soldadosBatallon.get(0),soldadosBatallon.get(1),soldadosBatallon.get(2));
			soldadosBatallon.get(0).setBatallonActual(batallonUtil);
			soldadosBatallon.get(1).setBatallonActual(batallonUtil);
			soldadosBatallon.get(2).setBatallonActual(batallonUtil);
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

	public Batallon moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){
		throw new AccionAgrupableInvalidaException("No se puede mover un batallon null");
	}

}
