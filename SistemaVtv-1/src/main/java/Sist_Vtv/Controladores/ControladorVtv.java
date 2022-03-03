/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sist_Vtv.Controladores;

import Sist_Vtv.Domain.Control;
import Sist_Vtv.Domain.TipoControl;
import Sist_Vtv.Domain.Vtv;
import Sist_Vtv.Servicio.InspectorService;
import Sist_Vtv.Servicio.VehiculoService;
import Sist_Vtv.Servicio.VtvService;
import Sist_Vtv.dao.ControlDao;
import Sist_Vtv.dao.EstadosControlDao;
import Sist_Vtv.dao.EstadosVtvDao;
import Sist_Vtv.dao.TipoControlDao;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vtv")
public class ControladorVtv {
    @Autowired
    private VtvService vtvSimp;
    @Autowired
    private TipoControlDao tipoControlDao;
    @Autowired
    private ControlDao controlSimp;
    @Autowired
    private VehiculoService vehiculoSimp;
    @Autowired
    private EstadosVtvDao estadoSimp;
    
    @PostMapping("/crearVtv")
    public boolean crearVtv(@RequestBody Vtv vtv){
    	List<TipoControl>controles= tipoControlDao.findAll();
    	
    	for (TipoControl r : controles) {
    		Control control= new Control(r,vtv);	
    		vtv.setControles(control);}
    	LocalDate a= LocalDate.now();
     	vtv.setFechaIni(a);
    	if (vtv.getInspector()!= null & vtv.getVehiculo()!= null) {
    	vtvSimp.guardar(vtv);
    	return true;
    	}
		return false;
    }
    
    @PostMapping("/finalizarVtv")
    public boolean finalizarVtv(@RequestBody Vtv vtvform) {
    	LocalDate a= LocalDate.now();
     	vtvform.setFechaIni(a);
    	var controles= vtvform.getControles();
    	long idestadoVtv= 1 ;
    	for(int i=0 ; i < controles.size(); i++ ) {
    		if(idestadoVtv==1 && controles.get(i).getEstadoControl().getIdEstadoControl()==3) idestadoVtv=3; //condicional
    		if(controles.get(i).getEstadoControl().getIdEstadoControl()==2) idestadoVtv=2; //no aprobado
    	}
    	if(idestadoVtv==1) {
    		LocalDate fecha= vtvform.getFechaIni();
    		vtvform.setFechaVen(fecha.plusYears(1));
    	}
    	vtvSimp.guardar(vtvform);
    	vtvform.getVehiculo().setVtv(vtvform);
    	vehiculoSimp.guardar(vtvform.getVehiculo());
    	return true;
    }
}
