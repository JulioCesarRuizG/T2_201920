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
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					System.out.println("--------- \nDar hora inicial para cluster: ");
				    int hora = lector.nextInt();
				    Queue cluster=modelo.clusterMasG(hora);
					System.out.println("Cluster m�s grande:");
					for(int i=0;i<cluster.size();i++)
					{ Viaje viaje= cluster.deQueue();
					System.out.println("--------- \nElemento: "+i + ", Hora:" + viaje.darHora() +"\n---------");						
					}break;

				case 2:
					System.out.println("--------- \nDar cadena (simple) a ingresar: ");
					dato = lector.next();
					modelo.agregar(dato);
					System.out.println("Dato agregado");
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 3:
					System.out.println("--------- \nDar cadena (simple) a buscar: ");
					dato = lector.next();
					respuesta = modelo.buscar(dato);
					if ( respuesta != null)
					{
						System.out.println("Dato encontrado: "+ respuesta);
					}
					else
					{
						System.out.println("Dato NO encontrado");
					}
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 4:
					System.out.println("--------- \nDar cadena (simple) a eliminar: ");
					dato = lector.next();
					respuesta = modelo.eliminar(dato);
					if ( respuesta != null)
					{
						System.out.println("Dato eliminado "+ respuesta);
					}
					else
					{
						System.out.println("Dato NO eliminado");							
					}
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 5: 
					System.out.println("--------- \nContenido del Arreglo: ");
					view.printModelo(modelo);
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;	
					
				case 6: 
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
