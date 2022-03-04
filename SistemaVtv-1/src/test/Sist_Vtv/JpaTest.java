package Sist_Vtv;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Sist_Vtv.Domain.Duenio;
import Sist_Vtv.dao.DuenioDao;

public class JpaTest {

	@Autowired
	DuenioDao dueniodao= mock(DuenioDao.class);
	
	
	@Test
	void findByAll() {
		List<Duenio> duenios= dueniodao.findAll();
		assertFalse(duenios.isEmpty());
	}
}
