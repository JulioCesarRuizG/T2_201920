package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Queue implements IQueue{

	private Collection<Viaje> cola;

	/**
	 * Crea una nueva cola
	 */
	public Queue()
	{
		Collection<Viaje> pCola = new ArrayList<Viaje>();
		cola = pCola;
	}

	/**
	 * Agrega un objeto T a la cola
	 * @param valor a agregar
	 */
	public void enQueue(Object valor) 
	{
		Viaje viaje = (Viaje) valor;
		cola.add(viaje);
	}

	/**
	 * Elimina un objeto de la cola
	 * @param valor buscado para eliminar
	 * @return Sí lo elimina retorna el objeto, null en caso contrario
	 */
	public Viaje deQueue() {

		Viaje primero = null;
		if(!cola.isEmpty())
		{
			primero = cola.iterator().next();
			cola.remove(primero);
		}
		return primero;
	}

	/**
	 * Comprueba que la cola esté vacía
	 * @return True si está vacía, false en caso contrario
	 */
	public boolean isEmpty() {
		return cola.isEmpty();
	}

	/**
	 * Devuelve el tamaño de la cola
	 * @return tamaño de la cola
	 */
	public int size() {
		return cola.size();
	}

	/**
	 * Convierte la cola de objetos en un iterator
	 * @return cola de objetos iterables
	 */
	public Iterator iterator() {
		return cola.iterator();
	}

}
