/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sist_Vtv.Controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sist_Vtv.Domain.Duenio;
import Sist_Vtv.Domain.Vehiculo;
import Sist_Vtv.Servicio.DuenioService;
import Sist_Vtv.Servicio.DuenioServiceImp;
import Sist_Vtv.Servicio.VehiculoService;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author facu_
 */

@RestController
@Slf4j
@RequestMapping("/duenio")
public class ControladorDuenio {
	@Autowired
	private DuenioService duenioSimp;
	@Autowired
	private VehiculoService vehiculoSimp;
	
	@GetMapping("/")
	public List<Duenio> inicioDuenio() {
		 
		return duenioSimp.listarDuenio();
	}

	 @PostMapping("/guardar")
    public boolean guardar(@RequestBody Duenio duenioForm){
		 if (duenioSimp.encontrarDuenio(duenioForm)== null) {
			 duenioSimp.guardar(duenioForm);
			 return true;
		 }else {
			 return false;
		 }
    }
	 
	 @PostMapping("/vehiculo/{dniduenio}")
	 public String alta(@PathVariable int dniduenio, @RequestBody @ Valid Vehiculo vehiculoForm,Errors error) {
		 if(error.hasErrors()) {
			 return "hubo un error en la carga de datos";
		 }
		 String duenio= String.valueOf(dniduenio);
		 var a= duenioSimp.encontrarDuenioDni(duenio);
		
		 if(vehiculoSimp.encontrarVehiculo(vehiculoForm)== null) {
			 vehiculoForm.setDuenio(a);
			 a.setVehiculos(vehiculoForm);
			 vehiculoSimp.guardar(vehiculoForm);
			 return "el vehiculo fue guardado";
		 }
		 return "el vehiculo no fue guardado por que ya existe";
	 }
	 
	 @DeleteMapping("/vehiculo/baja")
	 public boolean eliminarVehiculo(@RequestBody Vehiculo vehiculo) {
		 var a= vehiculoSimp.encontrarVehiculo(vehiculo);
		 vehiculoSimp.eliminar(a);
		 return true;
	 }
	 @GetMapping("/info/{dniDuenio}")
		public Duenio duenioInfo( Duenio duenio) {
		return duenioSimp.encontrarDuenio(duenio);
		}
	 
	 @PutMapping("/editar/")
	 public boolean editarDuenio(@RequestBody Duenio duenio) {
		 duenioSimp.guardar(duenio);
		 return true;
	 }
}
