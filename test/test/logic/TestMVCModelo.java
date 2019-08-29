package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Queue;
import model.data_structures.Viaje;
import model.logic.MVCModelo;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {

	private MVCModelo modelo;

	/**
	 * Escenario 1
	 * @throws Exception
	 */
	@Before
	public void setUp1() throws Exception {
		//./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv
		try
		{
			modelo= new MVCModelo("./data/pruebas-diez.csv");
		}
		catch (Exception e) {
			fail("Error al cargar el archivo" +'"'+"pruebas-diez"+'"');
		}
	}
	
	/**
	 * Escenario 2
	 */
	@Before
	public void setUp2()
	{
		try
		{
			modelo= new MVCModelo("./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv");
		}
		catch (Exception e) {
			fail("Error al cargar el archivo" +'"'+"bogota-cadastral-2018-1-All-HourlyAggregate"+'"');
		}
	}

	/**
	 * Comprueba el correcto funcionamiento de ClusterMasG
	 * @throws Exception 
	 */
	@Test
	public void testClusterMasG() throws Exception
	{
		setUp2();
		try
		{
			Queue cola = modelo.numeroGrandeConsecutivo(20);

			Viaje prueba1 = new Viaje(4,9,3,901.89,198.16,878.76,1.26, null);
			Viaje prueba2 = new Viaje(5,6,9,2757.13,467.44,2716.74,1.19, null);
			Viaje prueba3 = new Viaje(6,4,22,1111.97,656.62,1029.94,1.41, null);
			
			assertEquals("No es el valor esperado 1",prueba1.darHora(),cola.deQueue().darHora());
			assertEquals("No es el valor esperado 2",prueba2.darHora(),cola.deQueue().darHora());
			assertEquals("No es el valor esperado 3",prueba3.darHora(),cola.deQueue().darHora());
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Error al calcular los valores seguidos ascendentes de hora");
		}
	}

	/**
	 * Comprueba el tamaño correcto del modelo
	 */
	@Test
	public void testDarTamano() {
		setUp2();
		try
		{
			assertEquals("El valor no es el esperado: cola",1048575, modelo.darCola().size() );
			assertEquals("No es el valor esperado: pila", 1048575, modelo.darPila().size());
		}
		catch (Exception e) {
			fail("Error al calcular el tamaño");
		}
	}

	/**
	 * Comprueba el agregado correcto al modelo
	 */
	@Test
	public void testAgregar() {
		try
		{
			Viaje valor = new Viaje(1,1,1,1,1,1,1,null);
			modelo.darCola().enQueue(valor);
			modelo.darPila().push(valor);
			assertEquals("No se ha agregado correctamente: cola", valor, modelo.darCola().darUltimo());
			assertEquals("No se ha agregado correctamente: pila", valor, modelo.darPila().darPrimero());
		}
		catch (Exception e) {
			fail("Error al intentar agregar");
		}

	}
	
	/**
	 * Prueba del método últimos viajes
	 */
	@Test
	public void testUltimosViaje()
	{
		
	}

}
