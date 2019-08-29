package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Queue implements IQueue{

	private Viaje primero;
	private Viaje ultimo;
	
	/**
	 * Crea una nueva cola
	 */
	public Queue(Viaje pPrimero)
	{
		primero = pPrimero;
		ultimo = pPrimero;
	}
	
	/**
	 * Devuelve el primer viaje de la cola
	 * @return primer viaje
	 */
	public Viaje darPrimero()
	{
		return primero;
	}
	
	/**
	 * Devuelve el ultimo viaje de la cola
	 * @return ultimo viaje
	 */
	public Viaje darUltimo()
	{
		return ultimo;
	}

	/**
	 * Agrega un objeto T a la cola
	 * @param valor a agregar
	 */
	public void enQueue(Object valor) 
	{
		if(darPrimero() == null)
		{
			primero = (Viaje) valor;
			ultimo =  (Viaje) valor;
		}
		else
		{
			ultimo.cambiarSiguiente((Viaje) valor);
			ultimo = ultimo.darSiguiente();
		}
	}

	/**
	 * Elimina un objeto de la cola
	 * @return Sí lo elimina retorna el objeto, null en caso contrario
	 */
	public Viaje deQueue() {

		if(darPrimero() == null)
		{
			return null;
		}
		else if(primero.darSiguiente() == null)
		{
			Viaje eliminar = primero;
			primero = null;
			ultimo = null;
			return eliminar;
		}
		else
		{
			Viaje eliminar = primero;
			primero = primero.darSiguiente();
			return eliminar;
		}
	}

	/**
	 * Comprueba que la cola esté vacía
	 * @return True si está vacía, false en caso contrario
	 */
	public boolean isEmpty() {
		if(darPrimero() == null)
		{
			return true;
		}
		else return false;
	}

	/**
	 * Devuelve el tamaño de la cola
	 * @return tamaño de la cola
	 */
	public int size() {
		if(darPrimero() == null)
		{
			return 0;
		}
		else
		{
			int cantidad = 1;
			Viaje actual = primero;
			while(actual.darSiguiente() != null)
			{
				actual = actual.darSiguiente();
				cantidad ++;
			}
			return cantidad;
		}
	}

	/**
	 * Convierte la cola de objetos en un iterator
	 * @return cola de objetos iterables
	 */
	public Iterator iterator() {
		Viaje actual =  primero;
		Collection lista = new ArrayList<Viaje>();
		while(actual.darSiguiente() != null)
		{
			lista.add(actual);
			actual = actual.darSiguiente();
		}
		return lista.iterator();
	}

}
