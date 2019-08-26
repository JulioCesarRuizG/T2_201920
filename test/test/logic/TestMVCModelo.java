package test.logic;

import static org.junit.Assert.*;
import model.logic.MVCModelo;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {
	
	private MVCModelo modelo;
	
	@Before
	public void setUp1() throws Exception {
		modelo= new MVCModelo("C:/Users/Windows/Desktop/Datos/T2/prueba mil.csv");
	}

	
	@Test
	public void testMVCModelo() {
		try {
			setUp1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("F");
		}
	}


}
