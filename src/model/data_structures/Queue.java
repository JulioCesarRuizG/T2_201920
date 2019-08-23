package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue implements IQueue{

	private Viaje primero;
	private ArrayList<Viaje> cola;
	
	public Queue()
	{
		ArrayList<Viaje> pCola = new ArrayList<Viaje>();
		cola = pCola;
	}
	public void enQueue(Object valor) 
	{
		Viaje viaje = (Viaje) valor;
		cola.add(viaje);
	}

	public Viaje deQueue() {
		Viaje viajeeliminar =cola.get(0);
		cola.remove(0);
		return viajeeliminar;
	}

	public boolean isEmpty() {
		if(cola.isEmpty())
		{
			return true;
		}
		else return false;
		
	}

	public int size() {
		return cola.size();
	}
	
	public Iterator iterator() {
		
		return null;
	}

}
