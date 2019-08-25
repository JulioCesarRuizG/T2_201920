package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Stack implements IStack{

	private Viaje primero;
	private Stack pila;
	/**
	 * Crea una nueva pila
	 */
	public Stack(Viaje pPrimero)
	{
		primero = pPrimero;
	}

	/**
	 * Agrega un valor a la pila
	 * @param valor a agregar a la pila
	 */
	public void push(Object valor) {
		if(pila.darPrimero() == null)
		{
			pila.cambiarPrimero((Viaje) valor);
		}
		else
		{
			Viaje actual = primero;
			while(actual.darSiguiente() != null)
			{
				actual=actual.darSiguiente();
			}
			Viaje agregar = (Viaje) valor;
			actual.cambiarSiguiente(agregar);
		}
	}

	/**
	 * Elimina el último valor de la pila
	 * @return valor eliminado, null en caso contrario
	 */
	public Object pop() {
		Viaje actual = null;
		if(pila.size() != 0)
		{
			actual = primero;
			if(pila.size() == 1)
			{
				pila.cambiarPrimero(null);
				return primero;
			}
			else
			{
				Viaje eliminado = null;
				while(actual.darSiguiente().darSiguiente() != null)
				{
					actual = actual.darSiguiente();
					eliminado = actual.darSiguiente().darSiguiente();
				}
				actual.cambiarSiguiente(null);
				return eliminado;
			}
		}
		return null;
	}

	/**
	 * Comprueba que la pila esté vacía
	 * @return true si está vacío, false en caso contrario
	 */
	public boolean isEmpty() {
		if(pila.darPrimero() == null)
		{
			return true;
		}
		else return false;
	}

	/**
	 * Devuelve el tamaño de la pila
	 * @return tamaño de la pila
	 */
	public int size(){
		int tamano = 1;
		Viaje actual = primero;
		if(pila.darPrimero() == null)
		{
			return 0;
		}
		while(actual.darSiguiente() != null)
		{
			actual = actual.darSiguiente();
			tamano++;
		}
		return tamano;
	}

	/**
	 * Convierte la pila de objetos en un iterator
	 * @return pila de objetos iterable
	 */
	public Iterator iterator() {
		return pila.iterator();
	}

	public Viaje darPrimero()
	{
		return primero;
	}

	public void cambiarPrimero(Viaje cambio)
	{
		primero = cambio;
	}
}
