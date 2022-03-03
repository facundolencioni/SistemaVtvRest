
package Sist_Vtv.Controladores;

import Sist_Vtv.Domain.Inspector;
import Sist_Vtv.Servicio.InspetorServiceImp;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/inspector")
public class ControladorInspector {
 
	@Autowired
	private InspetorServiceImp inspectorSimp;

  
  	@GetMapping("/")
  	public List<Inspector> inicio(){    
      return inspectorSimp.listarInspector();
  	}
    @PostMapping("/guardar")
    public boolean guardar(@RequestBody Inspector inspectorForm){
    	inspectorSimp.guardar(inspectorForm);
        return true;
    }
    
    @PostMapping("/eliminar/{idInspector}")
    public boolean eliminar(@PathVariable long idInspector){
      if(inspectorSimp.encontrarInspector(idInspector)== null) {
    	  throw new RuntimeException("Inspector id not found -"+ idInspector);
      }
      	Inspector a= inspectorSimp.encontrarInspector(idInspector);
      	inspectorSimp.eliminar(a);
        return true;
    }
    @GetMapping("/info/{idInspector}")
    public Inspector info(@PathVariable long idInspector) {
    	return inspectorSimp.encontrarInspector(idInspector);
    }
    
    @PutMapping("/editar")
    public boolean editarInspector(@RequestBody Inspector inspectorForm) {
    	if(inspectorSimp.encontrarInspector(inspectorForm.getIdInspector())!= null) {
    		inspectorSimp.guardar(inspectorForm);
    		return true;
    	}    	return false;
    }
}