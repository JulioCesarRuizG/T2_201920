package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Stack implements IStack{

	private Collection<Viaje> pila;
	
	/**
	 * Crea una nueva pila
	 */
	public Stack()
	{
		Collection<Viaje> pPila = new ArrayList<Viaje>();
		pila = pPila;
	}
	
	/**
	 * Agrega un valor a la pila
	 * @param valor a agregar a la pila
	 */
	public void push(Object valor) {
		Viaje viaje = (Viaje) valor;
		pila.add(viaje);
	}

	/**
	 * Elimina el último valor de la pila
	 * @return valor eliminado, null en caso contrario
	 */
	public Object pop() {
		Viaje ultimo = null;
		if(!pila.isEmpty())
		{
			while(pila.iterator().hasNext())
			{
				ultimo = pila.iterator().next();
			}
			pila.remove(ultimo);
		}
		return ultimo;
	}

	/**
	 * Comprueba que la pila esté vacía
	 * @return true si está vacío, false en caso contrario
	 */
	public boolean isEmpty() {
		return pila.isEmpty();
	}

	/**
	 * Devuelve el tamaño de la pila
	 * @return tamaño de la pila
	 */
	public int size() {
		return pila.size();
	}
	
	/**
	 * Convierte la pila de objetos en un iterator
	 * @return pila de objetos iterable
	 */
	public Iterator iterator() {
		return pila.iterator();
	}

}
