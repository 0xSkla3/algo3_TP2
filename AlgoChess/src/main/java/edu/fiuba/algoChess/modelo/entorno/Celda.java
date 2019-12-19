package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.modelo.excepciones.OperacionInvalidaSobreObjetoNuloException;
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
		this.piezaActual = new PiezaNull();
	}

	public Celda(Bando bando){
		this.piezaActual = new PiezaNull();
		this.sectorDelJugador = bando;
	}

    public void guardarFaseInicial(Pieza piezaAUbicar) {
		this.getSectorDelJugador().pisarSiBandoCorrecto(this, piezaAUbicar, piezaAUbicar.getBando());
    }

	public void guardarFaseJuego(Pieza piezaAUbicar) {
		this.piezaActual.pisar(this, piezaAUbicar);
	}

	public void eliminar() {
		this.piezaActual = new PiezaNull();
	}

    public void ubicar(Pieza piezaAGuardar) {
	    this.piezaActual = piezaAGuardar;
	    piezaAGuardar.setBandoCeldaActual(this.sectorDelJugador);
    }

    public Bando obtenerBandoDePieza(){
		try {
			return piezaActual.getBando();
		} catch (OperacionInvalidaSobreObjetoNuloException ex){
			throw new OperacionInvalidaSobreObjetoNuloException("PiezaNull no tiene bando");
		}
	}

}
