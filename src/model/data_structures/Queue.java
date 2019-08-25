package model.data_structures;

import java.util.Iterator;

public class Queue implements IQueue{

	private Viaje primero;
	
	/**
	 * Crea una nueva cola
	 */
	public Queue(Viaje pPrimero)
	{
		primero = pPrimero;
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
	 * Agrega un objeto T a la cola
	 * @param valor a agregar
	 */
	public void enQueue(Object valor) 
	{
		if(darPrimero() == null)
		{
			primero = (Viaje) valor;
		}
		else
		{
			Viaje actual = primero; 
			while(actual.darSiguiente() != null)
			{
				actual = actual.darSiguiente();
			}
			actual.cambiarSiguiente((Viaje)valor);
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
		else
		{
			Viaje eliminado = primero;
			primero = primero.darSiguiente();
			return eliminado;	
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
		falta implementar
	}

}
