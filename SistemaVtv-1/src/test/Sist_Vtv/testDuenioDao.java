package Sist_Vtv;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import Sist_Vtv.Domain.Duenio;
import Sist_Vtv.Servicio.DuenioService;

public class testDuenioDao {
	
	@Autowired
	private DuenioService duenioSimp= Mockito.mock(DuenioService.class);
	
	@BeforeEach
	public void setup1() {
		Duenio duenioTest= new Duenio();
		duenioTest.setNombre("Diego Perez");
		duenioTest.setTelefono("2614565659");
		duenioTest.setDniDuenio("40105905");
		duenioTest.setDireccion("Mendoza");
		
		Duenio duenioTest2= new Duenio();
		duenioTest2.setNombre("Carlos Perez");
		duenioTest2.setTelefono("2634616005");
		duenioTest2.setDniDuenio("40105989");
		duenioTest2.setDireccion("Mendoza");
		
		List<Duenio> lista= new ArrayList<Duenio>();
		lista.add(duenioTest);
		lista.add(duenioTest2);
		
		when(duenioSimp.encontrarDuenioDni("40105905")).thenReturn(duenioTest);
		when(duenioSimp.listarDuenio()).thenReturn(lista);
		
	}
	
	@Test
	public void testBuscarDni() {
		Duenio duenioPrueba= duenioSimp.encontrarDuenioDni("40105905");
		assertEquals("Diego Perez", duenioPrueba.getNombre());
		assertEquals("Mendoza", duenioPrueba.getDireccion());
		assertEquals("40105905", duenioPrueba.getDniDuenio());
		
		
		
	}
	@Test
	public void testListar() {
		List<Duenio> listaTest= duenioSimp.listarDuenio();
		assertEquals(2, listaTest.size());
		assertEquals("Carlos Perez", listaTest.get(1).getNombre());
		
	}
	
	
}
