package Sist_Vtv;

import static org.junit.Assert.assertFalse;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sist_Vtv.Domain.Duenio;
import Sist_Vtv.dao.DuenioDao;


@DataJpaTest
@RunWith(SpringRunner.class)
public class JpaTest {

	@Autowired
	DuenioDao dueniodao;
	
	
	@Test
	void findByAll() {
		List<Duenio> duenios= dueniodao.findAll();
		assertFalse(duenios.isEmpty());
	}
}
