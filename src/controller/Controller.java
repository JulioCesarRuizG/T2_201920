package controller;

import java.util.Scanner;

import model.data_structures.Queue;
import model.data_structures.Viaje;
import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 * @throws Exception 
	 */
	public Controller () throws Exception
	{
		view = new MVCView();
		modelo = new MVCModelo("./data/bogota-cadastral-2018-1-All-HourlyAggregate.cvs");
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					System.out.println("--------- \nDar hora inicial para cluster: ");
				    int hora = lector.nextInt();
				    Queue cluster=modelo.clusterMasG(hora);
					System.out.println("Cluster más grande:");
					for(int i=0;i<cluster.size();i++)
					{ Viaje viaje= cluster.deQueue();
					System.out.println("--------- \nElemento: "+i + ", Hora:" + viaje.darHora() +",Zona Origen:"+viaje.darInicioID()+", Zona Destino:"+viaje.darDestinoID()+",Tiempo promedio:"+viaje.darTiempoPromedioEnSegundos()+"\n---------");						
					}break;

				case 2:
					System.out.println("--------- \nDar hora inicial para dar la info de los ultimos viajes: ");
					int hora2=lector.nextInt();
					System.out.println("--------- \nDar la cantidad de viajes para dar la info de los ultimos viajes: ");
					int N=lector.nextInt();
					Queue ultimos=modelo.ultimosViajes(N, hora2);
					for(int i=0;i<ultimos.size();i++)
					{ Viaje viaje= ultimos.deQueue();
					System.out.println("--------- \nElemento: "+i + ", Hora:" + viaje.darHora() +",Zona Origen:"+viaje.darInicioID()+", Zona Destino:"+viaje.darDestinoID()+",Tiempo promedio:"+viaje.darTiempoPromedioEnSegundos()+"\n---------");						
					}
					
				case 3: 
					System.out.println("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					System.out.println("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
