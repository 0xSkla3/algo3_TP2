package edu.fiuba.algoChess;

public class Celda {

	private Pieza piezaActual;
	private Bando sectorDelJugador;

	public Celda(){
		this.piezaActual = new PiezaNull(null);
	}

	public Celda(Bando bando){
		this.piezaActual = new PiezaNull(null);
		this.sectorDelJugador = bando;
	}



	public Pieza getPiezaActual(){return this.piezaActual;}


	public void setSectorDelJugador(Bando bandoJugador){
		this.sectorDelJugador = bandoJugador;
	}

	public Bando getSectorDelJugador(){ return this.sectorDelJugador;}

    public void guardar(Pieza piezaAUbicar) {
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



	public void eliminar() {
		this.piezaActual = new PiezaNull(null);
	}

    public void ubicar(Pieza piezaAGuardar) {
	    this.piezaActual = piezaAGuardar;
    }



}
