package Sist_Vtv;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Sist_Vtv.Domain.Duenio;

@SpringBootTest
class SistemaVtv1ApplicationTests {
	
	
	@Test
	void testGetandSetDuenio() {
		Duenio duenioTest= new Duenio();
		duenioTest.setNombre("Franco");
		String esperado= "Franco";
		String real= duenioTest.getNombre();
		
		assertEquals(esperado, real);
		}
	
}
