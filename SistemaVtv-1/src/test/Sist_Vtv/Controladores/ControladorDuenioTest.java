package Sist_Vtv.Controladores;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import Sist_Vtv.DatosPruebas;
import Sist_Vtv.Servicio.DuenioService;


@WebMvcTest(controllers = ControladorDuenio.class)
@RunWith(SpringRunner.class)
public class ControladorDuenioTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private DuenioService duenioService;
	
	@Test
	void inicioDuenioTest() throws Exception {
		when(duenioService.listarDuenio()).thenReturn(DatosPruebas.duenios);
		
		
		mvc.perform( MockMvcRequestBuilders.get("/duenio"))
					.andExpect(status().isOk());
					

	}
}
