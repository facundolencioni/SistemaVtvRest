/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sist_Vtv.Controladores;

import Sist_Vtv.Domain.Duenio;
import Sist_Vtv.Domain.Vtv;
import Sist_Vtv.Servicio.DuenioService;
import Sist_Vtv.Servicio.VtvService;
import Sist_Vtv.dao.EstadosVtvDao;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author facu_
 */
@RestController
@Slf4j
public class ControladorInicio {
    @Autowired
    private VtvService vtvSimp;
    @Autowired
    private DuenioService duenioSimp;
    @Autowired
    private EstadosVtvDao estadoSimp;
    
    @GetMapping("/")
    public List<Vtv> Inicio(){
    vtvSimp.listarVtv();
   
    return vtvSimp.listarVtv();
    }
    @GetMapping("/buscar")
    public Duenio inicio(@RequestBody Duenio duenio) {
    	return duenioSimp.encontrarDuenio(duenio);
    }
    
    
    @GetMapping("/aptas")
    public List<Vtv> aptas(Model model) {
    	List<Vtv> returnVtv = null;
    	LocalDate a= LocalDate.now();
    	a.minusMonths(3);
    	
    	var estadoVtv= estadoSimp.findById((long) 1).orElse(null);
    	for (Vtv vtv : vtvSimp.VtvEstados(estadoVtv)) {
    		if(vtv.getFechaIni().isAfter(a)) {
    		returnVtv.add(vtv);
		}
    	}
    return returnVtv;
    }
    @GetMapping("/noAptas")
    public List<Vtv> noAptas(Model model) {
    	List<Vtv> returnVtv = null;
    	LocalDate a= LocalDate.now();
    	a.minusMonths(3);
    	
    	var estadoVtv= estadoSimp.findById((long) 2).orElse(null);
    	for (Vtv vtv : vtvSimp.VtvEstados(estadoVtv)) {
    		if(vtv.getFechaIni().isAfter(a)) {
    		returnVtv.add(vtv);
		}
    	}
    return returnVtv;
    }
    
    @GetMapping("/condicionales")
    public List<Vtv> condicional(Model model) {
    	List<Vtv> returnVtv = null;
    	LocalDate a= LocalDate.now();
    	a.minusMonths(3);
    	
    	var estadoVtv= estadoSimp.findById((long) 3).orElse(null);
    	for (Vtv vtv : vtvSimp.VtvEstados(estadoVtv)) {
    		if(vtv.getFechaIni().isAfter(a)) {
    		returnVtv.add(vtv);
		}
    	}
    return returnVtv;
    }



}

