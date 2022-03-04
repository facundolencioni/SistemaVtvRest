package Sist_Vtv.Controladores;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import Sist_Vtv.Domain.Duenio;
import Sist_Vtv.Servicio.DuenioService;

@Configuration
@WebMvcTest(controllers = ControladorDuenio.class)
public class ControladorDuenioTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private DuenioService duenioSimp= mock(DuenioService.class);
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
		
		when(duenioSimp.listarDuenio()).thenReturn(lista);
		
	}
	@Test
	void inicioDuenioTest() throws Exception {
		
		mvc.perform( MockMvcRequestBuilders.get("/duenio/"))
					.andExpect(status().isOk());
					

	}
}
