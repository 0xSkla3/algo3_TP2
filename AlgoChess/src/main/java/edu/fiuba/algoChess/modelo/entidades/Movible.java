package edu.fiuba.algoChess.modelo.entidades;

import edu.fiuba.algoChess.modelo.batallones.Batallon;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.excepciones.AccionAgrupableInvalidaException;

public abstract class Movible {

	public void moverseALaDerecha(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	};

	public  void moverseALaIzquierda(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	}

	public  void moverseArriba(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	}

	public  void moverseAbajo(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	}

	public  void mover(Tablero campoDeBatalla, Ubicacion ubicacion){
		throw new AccionAgrupableInvalidaException("No se puede mover una pieza unica para un grupo");
	}

	public Batallon moverBatallonDerecha(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover un grupo para una pieza unica");
	}

	public Batallon moverBatallonIzquierda(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover un grupo para una pieza unica");
	}

	public Batallon moverBatallonArriba(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover un grupo para una pieza unica");
	}

	public Batallon moverBatallonAbajo(Tablero campoDeBatalla){
		throw new AccionAgrupableInvalidaException("No se puede mover un grupo para una pieza unica");
	}

	public Batallon moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3){
		throw new AccionAgrupableInvalidaException("No se puede mover un grupo para una pieza unica");
	}

	public void rollbackMovimiento(Ubicacion ubicacionVieja){
		throw new AccionAgrupableInvalidaException("No se puede hacer rollback del movimiento de una entidad no agrupable");
	}

}
