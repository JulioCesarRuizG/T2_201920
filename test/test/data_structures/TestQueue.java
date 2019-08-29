package test.data_structures;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import model.data_structures.Queue;
import model.data_structures.Viaje;

public class TestQueue {
	
	/**
	 * Viajes usados en las pruebas
	 */
	private Viaje quinto = new Viaje(100, 101, 102, 103, 104, 105, 106, null);
	private Viaje cuarto = new Viaje(22,23,24,25,26,27,28, null);
	private Viaje tercero = new Viaje(15,16,17,18,19,20,21, cuarto);
	private Viaje segundo = new Viaje(8,9,10,11,12,13,14, tercero);
	private Viaje primero = new Viaje(1,2,3,4,5,6,7, segundo);
	
	private Queue cola;
	
	/**
	 * Escenario de pruebas 1
	 */
	@Before
	public void setupEscenario1()
	{
		try
		{
			cola = new Queue(primero);
		}
		catch (Exception e) {
			fail("Se ha producido un error en la creaci�n de la cola");
		}
	}
	
	/**
	 * Test del m�todo enQueue
	 */
	@Test
	public void TestEnQueue()
	{
		setupEscenario1();
		try
		{
			cola.enQueue(quinto);
			assertEquals("El viaje no fue agregado correctamente", quinto, cola.darPrimero().darSiguiente().darSiguiente().darSiguiente().darSiguiente());
		}
		catch (Exception e) {
			fail("Error al agregar el viaje");
		}
	}
	
	/**
	 * Test del m�todo deQueue
	 */
	@Test
	public void TestDeQueue()
	{
		setupEscenario1();
		try
		{
			Viaje eliminado = cola.deQueue();
			assertEquals("No es el viaje esperado", eliminado, primero);
		}
		catch (Exception e) {
			fail("Error al sacar el viaje correctamente");
		}
	}
	
	/**
	 * Test del m�todo isEmpty
	 */
	@Test
	public void TestIsEmpty()
	{
		setupEscenario1();
		try
		{
			assertEquals("El valor esperado no es el adecuado", cola.isEmpty(), false);
		}
		catch (Exception e) {
			fail("Error al usar el m�todo isEmpty");
		}
	}
	
	/**
	 * Test del m�todo size
	 */
	@Test
	public void TestSize()
	{
		setupEscenario1();
		try
		{
			assertEquals("El valor esperado no es el adecuado", cola.size(), 4);
		}
		catch (Exception e) {
			fail("Error al pedir el tama�o de la cola");
		}
	}
	
	/**
	 * Test de el m�todo iterator
	 */
	@Test
	public void TestIterator()
	{ 
		setupEscenario1();
		try
		{
			Iterator iterador = cola.iterator();
			Viaje viaje = (Viaje)iterador.next();
			assertEquals("No es el viaje esperado", viaje, primero);
		}
		catch (Exception e) {
			fail("No se pudo convertir la cola a un iterador");
		}
	}
}
