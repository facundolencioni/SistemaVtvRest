package Sist_Vtv;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Sist_Vtv.Domain.Duenio;
import Sist_Vtv.Domain.Vehiculo;

@SpringBootTest
public class testDuenio {

	@Test
	void testgetandSetVehiculos() {
		Duenio duenioTest= new Duenio();
		
		duenioTest.setVehiculos(DatosPruebas.vehiculo1);
		duenioTest.setVehiculos(DatosPruebas.vehiculo2);
		
		ArrayList<Vehiculo> esperado = new ArrayList<Vehiculo>();
		esperado.add(DatosPruebas.vehiculo1);
		esperado.add(DatosPruebas.vehiculo2);
		
		assertEquals(DatosPruebas.vehiculo1, duenioTest.getVehiculos().get(0));
		
	}
}
