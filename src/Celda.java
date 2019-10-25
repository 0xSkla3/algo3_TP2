public class Celda {

	private boolean estaVacia;
	private Ficha fichaActual;

	public Celda() {
		this.estaVacia = false;
	}

	public void setVacia(boolean estado) {
		this.estaVacia = estado;
	}

	public boolean estaVacia() {
		return this.estaVacia;
	}

	//Replica el estado de la celda actual a la nueva celda y restaura los valores de la celda actual
	public void moverA(Celda nuevaCelda) {
		nuevaCelda.estaVacia = this.estaVacia;
		this.estaVacia = false;
	}

}