package edu.fiuba.algoChess.entorno;

import edu.fiuba.algoChess.bandos.Bando;
import edu.fiuba.algoChess.entidades.Pieza;
import edu.fiuba.algoChess.entidades.PiezaNull;
import edu.fiuba.algoChess.excepciones.NoSePuedeUbicarPiezaEnSectoRival;
import edu.fiuba.algoChess.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Celda {

	@Getter
	@Setter
	protected Pieza piezaActual;

	@Setter
	@Getter
	protected Bando sectorDelJugador;

	public Celda(){
		this.piezaActual = new PiezaNull(null);
	}

	public Celda(Bando bando){
		this.piezaActual = new PiezaNull(null);
		this.sectorDelJugador = bando;
	}

    public void guardarComienzo(Pieza piezaAUbicar) {
        if (!this.sectorDelJugador.equals(piezaAUbicar.getBando())  ) { //ESTA LINEA SOLO VALE EN LA PRIMERA ETAPA DEL JUEGO!!! AGREGAR OTRA CONDICION AL IF!!!
            throw new NoSePuedeUbicarPiezaEnSectoRival("No se puede ubicar pieza en sector rival");
        } else {
			try {
				this.piezaActual.pisar(this, piezaAUbicar);
			} catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
				throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
			}
		}
    }

	public void guardarEnJuego(Pieza piezaAUbicar) {
		try {
			this.piezaActual.pisar(this, piezaAUbicar);
		} catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
			throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
		}
	}

	public void eliminar() {
		this.piezaActual = new PiezaNull(null);
	}

    public void ubicar(Pieza piezaAGuardar) {
	    this.piezaActual = piezaAGuardar;
    }

}
