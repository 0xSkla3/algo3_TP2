package edu.fiuba.algoChess.entidades;

import edu.fiuba.algoChess.interfaz.vista.SoldadoView;

import java.util.ArrayList;
import java.util.Observer;

public abstract class Observable {

	@SuppressWarnings("deprecation")
	private ArrayList<Observer> observadores;

	public Observable() { observadores = new ArrayList<Observer>(); }

	@SuppressWarnings("deprecation")
	public void aniadirObservador(Observer observador) { observadores.add(observador); }

	//@SuppressWarnings("deprecation")
	//public void actualizarVistaObservable() { observadores.stream().forEach(Observer::change); }
}