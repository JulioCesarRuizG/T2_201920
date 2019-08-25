package model.data_structures;

public class Viaje {

	private int inicioID;
	private int destinoID;
	private int hora;
	private double tiempoPromedioEnSegundos;
	private double desviacionEstandar;
	private double tiempoPromedioGEnSegundos;
	private double desviacionEstandarG;
	private Viaje siguiente;

	public Viaje(int pInicioID, int pDestinoID, int pHora, double pTiempoPromedioEnSegundos, double pDesviacionEstandar, double pTiempoPromedioGEnSegundos, double pDesviacionEstandarG, Viaje pSiguiente)
	{
		inicioID = pInicioID;
		destinoID = pDestinoID;
		hora = pHora;
		tiempoPromedioEnSegundos = pTiempoPromedioEnSegundos;
		desviacionEstandar = pDesviacionEstandar;
		tiempoPromedioGEnSegundos = pTiempoPromedioGEnSegundos;
		desviacionEstandarG = pDesviacionEstandarG;
		siguiente = pSiguiente;
	}
	public int darInicioID()
	{
		return inicioID;
	}
	public int darDestinoID()
	{
		return destinoID;
	}
	public int darHora()
	{
		return hora;
	}
	public double darTiempoPromedioEnSegundos()
	{
		return tiempoPromedioEnSegundos;
	}
	public double darDesviacionEstandar()
	{
		return desviacionEstandar;
	}
	public double darTiempoPromedioGEnSegundos()
	{
		return tiempoPromedioGEnSegundos;
	}
	public double darDesviacionEstandarG()
	{
		return desviacionEstandarG;
	}
	public Viaje darSiguiente()
	{
		return siguiente;
	}
	public void cambiarSiguiente(Viaje pViaje)
	{
		siguiente = pViaje;
	}
}
