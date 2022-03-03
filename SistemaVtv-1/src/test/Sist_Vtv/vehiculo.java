package Sist_Vtv;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Sist_Vtv.Domain.Vehiculo;

@SpringBootTest
public class vehiculo {

	@Test
	void setAndGetDuenio() {
		Vehiculo vehiculoTest = DatosPruebas.vehiculo1;
		vehiculoTest.setDuenio(DatosPruebas.duenio1);
		assertEquals(DatosPruebas.duenio2, vehiculoTest.getDuenio());
	}
	
}
