package testLectores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lectores.LectorCsv;

public class TestLectorCsv {

	private List<List<String>> registro;
	private List<String> camposTest = Arrays.asList("id,first_name,last_name,email,gender,ip_address".split(","));

	@Test
	public void testCargarCsv() {
		LectorCsv lectorTest = new LectorCsv();
		lectorTest.cargarCsv("../AccesoADatos0Windows/reto0/MOCK_DATA.csv");
		assertEquals(lectorTest.getRegistro().get(0), camposTest);
	}

	@Test(expected = ArithmeticException.class)
	public void testCargarCsvException() {
		LectorCsv lectorTest = new LectorCsv();
		lectorTest.cargarCsv(".");
	}
	
	@Test
	public void testLeerCsv() {
		LectorCsv lectorTest = new LectorCsv();
		lectorTest.cargarCsv("../AccesoADatos0Windows/reto0/MOCK_DATA.csv");
		assertTrue(lectorTest.leerCsv());
	}
	
	@Test
	public void testLeerPosicion() {
		LectorCsv lectorTest = new LectorCsv();
		lectorTest.cargarCsv("../AccesoADatos0Windows/reto0/MOCK_DATA.csv");
	}
	
	
}
