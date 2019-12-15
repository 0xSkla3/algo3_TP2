package edu.fiuba.algoChess.modelo.entorno;

import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeUbicarPiezaEnSectoRival;
import edu.fiuba.algoChess.modelo.excepciones.NoSePuedeUbicarPorqueEstaOcupadoException;
import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entidades.PiezaNull;
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

    public void guardarFaseInicial(Pieza piezaAUbicar) {
        if (!this.sectorDelJugador.equals(piezaAUbicar.getBando())  ) {
            throw new NoSePuedeUbicarPiezaEnSectoRival("No se puede ubicar pieza en sector rival");
        } else {
			try {
				this.piezaActual.pisar(this, piezaAUbicar);
			} catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
				throw new NoSePuedeUbicarPorqueEstaOcupadoException("no se puede ubicar pieza por estar el casillero ocupado");
			}
		}
    }

	public void guardarFaseJuego(Pieza piezaAUbicar) {
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
	    piezaAGuardar.setBandoCeldaActual(this.sectorDelJugador);
    }

    public boolean piezaBandoAliado(Bando bando){
		return this.piezaActual.bandoAliado(bando);
	}

	public boolean piezaBandoEnemigo(Bando bando){
		return this.piezaActual.bandoEnemigo(bando);
	}

}
