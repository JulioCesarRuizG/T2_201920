package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.data_structures.Viaje;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	private Queue cola;
	private Stack pila;

	private boolean valor=true;
	private Viaje agregar;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	// por alguna razón, no carga correctamente el excel que se nos entrega. Pero, si utilizamos uno con el mismo orden y tipo de datos pero que solo tiene mil lineas,funciona correctamente
	public MVCModelo(String pRuta) throws Exception
	{   cola= new Queue(null);
	pila= new Stack(null);
	CSVReader reader = null;
	CSVReader reader2 = null;
	
	try {
		reader= new CSVReader(new FileReader(pRuta));
		reader2= new CSVReader(new FileReader(pRuta));
		int c =0;

		for(String[] nextLine : reader) {


			int  inicioID=Integer.parseInt(nextLine[0]);
			int destinoID=Integer.parseInt(nextLine[1]);
			int hora=Integer.parseInt(nextLine[2]);
			double tiempoPromedioEnSegundos=Double.parseDouble(nextLine[3]);
			double desviacionEstandar=Double.parseDouble(nextLine[4]);
			double tiempoPromedioGEnSegundos=Double.parseDouble(nextLine[5]);
			double desviacionEstandarG=Double.parseDouble(nextLine[6]);

			Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG,null);
			agregar = i;

			cola.enQueue(i);
			c++;
		}




		for(String[] nextLine : reader2) {
			int  inicioID=Integer.parseInt(nextLine[0]);
			int destinoID=Integer.parseInt(nextLine[1]);
			int hora=Integer.parseInt(nextLine[2]);
			double tiempoPromedioEnSegundos=Double.parseDouble(nextLine[3]);
			double desviacionEstandar=Double.parseDouble(nextLine[4]);
			double tiempoPromedioGEnSegundos=Double.parseDouble(nextLine[5]);
			double desviacionEstandarG=Double.parseDouble(nextLine[6]);

			Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG,null);
			agregar = i;

			pila.push(i);


		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} finally{
		if (reader != null) {
			try {
				reader.close();
				reader2.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	System.out.print("-------- /nID zona de inicio:"+agregar.darInicioID()+"-------- /nID Destino:"+agregar.darDestinoID()+"-------- /nHora del dia:"+agregar.darHora()+"-------- /nTiempo Promedio:"+agregar.darTiempoPromedioEnSegundos());
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public Queue clusterMasG(int inicio)
	{   ArrayList<Viaje> base=new ArrayList<Viaje>();
	Queue cluster= new Queue(null);
	Viaje primero = null;
	while(cola.darPrimero().darHora()!=inicio){
		primero=cola.deQueue();
	}
	base.add(primero);
	cluster.enQueue(primero);

	while(cola.size()!=0){
		Viaje clus=base.get(base.size()-1);
		Viaje col= cola.deQueue();

		if(col.darHora()>=clus.darHora()){
			base.add(col);
		} else {
			base.clear();
			base.add(col);
		}
		if(base.size()>cluster.size()){
			while(cluster.size() != 0)
			{
				cluster.deQueue();
			}
			for(int i=0;i<base.size();i++)
				cluster.enQueue(base.get(i));
		}

	}
	return cluster;
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Viaje dato)
	{	
		cola.enQueue(valor);
		pila.push(valor);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Queue ultimosViajes(int N,int Hora){
		Queue ultimos = new Queue(null);
		while(ultimos.size()<N){
			Viaje agregar = pila.pop();
			if(agregar.darHora()==Hora){
				ultimos.enQueue(agregar);
			}
		}
		return ultimos;
	}

	/**
	 * Devuelve la cola en la que se han agregado elementos de un archivo
	 * @return cola
	 */
	public Queue darCola()
	{
		return cola;
	}

	/**
	 * Devuelve la cola en la que se han agregado elementos de un archivo
	 * @return pila
	 */
	public Stack darPila()
	{
		return pila;
	}

	
	public Queue numeroGrandeConsecutivo(int hora)
	{
		Queue nuevaCola = new Queue(null);
		Viaje buscar = cola.darPrimero();
		Queue mayor = new Queue(null);
		while(buscar.darHora() != hora && buscar.darSiguiente() != null)
		{
			buscar = buscar.darSiguiente();
		}
		nuevaCola.enQueue(buscar);
		while(buscar != null)
		{
			if(nuevaCola.size()==0 || buscar.darHora() >= nuevaCola.darUltimo().darHora())
			{
				nuevaCola.enQueue(buscar);
			}
			
			else
			{
				if(nuevaCola.size() > mayor.size())
				{
					while(nuevaCola.darPrimero() != null)
					{
						mayor.enQueue(nuevaCola.darPrimero());
						nuevaCola.deQueue();
					}
				}
				else
				{
					while(nuevaCola.darPrimero() != null)
					{
						nuevaCola.deQueue();
					}
				}
			}

			if(buscar.darSiguiente() != null)
			{
				buscar = buscar.darSiguiente();
			}
			else return mayor;
			
		}
		return mayor;
	}


}