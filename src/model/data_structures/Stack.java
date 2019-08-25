package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Stack implements IStack{

	private Viaje primero;
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
		if(darPrimero() == null)
		{
			cambiarPrimero((Viaje) valor);
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
		if(size() != 0)
		{
			actual = primero;
			if(size() == 1)
			{
				cambiarPrimero(null);
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
		if(darPrimero() == null)
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
		if(darPrimero() == null)
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
		falta implementar
	}

	/**
	 * Devuelve el primer elemento de la pila
	 * @return primero
	 */
	public Viaje darPrimero()
	{
		return primero;
	}

	/**
	 * Cambia el primer elemento de la pila
	 * @param valor por el que se cambia
	 */
	public void cambiarPrimero(Viaje cambio)
	{
		primero = cambio;
	}
}
