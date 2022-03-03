package Sist_Vtv;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Sist_Vtv.Domain.Control;
import Sist_Vtv.Domain.EstadoControl;

@SpringBootTest
public class testVtv {

	@Test
	void testvtvResultado() {
		Control control1= new Control();
		Control control2= new Control();
		EstadoControl esta1= new EstadoControl(1L,"Aprobado",null);
		EstadoControl esta2= new EstadoControl(2L,"No aprobado",null);
		EstadoControl esta3= new EstadoControl(3L,"Condicional",null);
		
		control1.setEstadoControl(esta3);
		control2.setEstadoControl(esta1);
		ArrayList<Control> controlesBd = new ArrayList<Control>();
		controlesBd.add(control1);
		controlesBd.add(control2);
	
    	long idestadoVtv= 1 ;
    	for(int i=0 ; i < controlesBd.size(); i++ ) {
    		if(idestadoVtv==1 && controlesBd.get(i).getEstadoControl().getIdEstadoControl()==3) idestadoVtv=3; //condicional
    		if(controlesBd.get(i).getEstadoControl().getIdEstadoControl()==2) idestadoVtv=2; //no aprobado
    	}
    	long esperado= 2;
    	
    	assertEquals(esperado, idestadoVtv);
			
	}
	
}
