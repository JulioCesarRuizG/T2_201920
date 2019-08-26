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
	private Viaje ultimo;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	// por alguna razón, no carga correctamente el excel que se nos entrega. Pero, si utilizamos uno con el mismo orden y tipo de datos pero que solo tiene mil lineas,funciona correctamente
	public MVCModelo(String pRuta) throws Exception
	{   cola= new Queue(null);
	    pila= new Stack(null);
		CSVReader reader = null;
		int c=0;
		try {
			reader= new CSVReader(new FileReader(pRuta));
			
			for(String[] nextLine : reader) {
				int  inicioID=Integer.parseInt(nextLine[0]);
				int destinoID=Integer.parseInt(nextLine[1]);
				int hora=Integer.parseInt(nextLine[2]);
				double tiempoPromedioEnSegundos=Double.parseDouble(nextLine[3]);
				double desviacionEstandar=Double.parseDouble(nextLine[4]);
				double tiempoPromedioGEnSegundos=Double.parseDouble(nextLine[5]);
				double desviacionEstandarG=Double.parseDouble(nextLine[6]);
				
				Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG,null);
				ultimo = i;
				
				pila.push(i);
				
                c++;
                System.out.println(c);
			}
			for(String[] nextLine : reader) {
				c=0;
				int  inicioID=Integer.parseInt(nextLine[0]);
				int destinoID=Integer.parseInt(nextLine[1]);
				int hora=Integer.parseInt(nextLine[2]);
				double tiempoPromedioEnSegundos=Double.parseDouble(nextLine[3]);
				double desviacionEstandar=Double.parseDouble(nextLine[4]);
				double tiempoPromedioGEnSegundos=Double.parseDouble(nextLine[5]);
				double desviacionEstandarG=Double.parseDouble(nextLine[6]);
				
				Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG,null);
				ultimo = i;
				
				cola.enQueue(i);
                
                c++;
                System.out.println(c);
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if (reader != null) {
				try {
					reader.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		System.out.print("-------- /nID zona de inicio:"+ultimo.darInicioID()+"-------- /nID Destino:"+ultimo.darDestinoID()+"-------- /nHora del dia:"+ultimo.darHora()+"-------- /nTiempo Promedio:"+ultimo.darTiempoPromedioEnSegundos());
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public Queue clusterMasG(int inicio)
	{   ArrayList<Viaje> base=new ArrayList<Viaje>();
		Queue cluster= new Queue(null);
		Viaje primero=null;
		while(primero.darHora()!=inicio){
			primero=cola.deQueue();
		}
	     cluster.enQueue(primero);
	     base.add(primero);
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
	    				  for(int i=0;i<base.size();i++)
	    					  cluster.enQueue(base.get(i));
	    			  }
	    				  
	     }
		return cluster;
	}
	public Queue ultimosViajes(int N,int Hora){
		Queue base = new Queue(null);
		while(base.size()<N){
			Viaje agregar = pila.pop();
			if(agregar.darHora()==Hora){
				base.enQueue(agregar);
			}
		}
		 Queue ultimos= new Queue(null);
	  
		return ultimos;
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



}
