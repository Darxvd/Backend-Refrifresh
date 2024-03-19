package com.refrifresh.source.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.refrifresh.source.entity.InfTecnic;
import com.refrifresh.source.service.InfTecnicService;

@RestController
@RequestMapping("/infortec")
public class InfTecnicController {
	
    private final InfTecnicService serviceInf;
    public InfTecnicController(InfTecnicService serviceInf) {
        this.serviceInf = serviceInf;
    }
	
	@GetMapping("/list-informtecnic")
	public ResponseEntity<List<InfTecnic>> getInfTecnic(){
		return new ResponseEntity<>(serviceInf.getInform(), HttpStatus.OK);
	}
	
	@GetMapping("/list-active")
	public ResponseEntity<List<InfTecnic>> getActive(){
		return new ResponseEntity<>(serviceInf.getActive(), HttpStatus.OK);
	}
	
	@GetMapping("/list-inactive")
	public ResponseEntity<List<InfTecnic>> getInactive(){
		return new ResponseEntity<>(serviceInf.getInactive(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{idInfTecnic}")
	public ResponseEntity<InfTecnic> findByIdInfTecnic(@PathVariable("id") int id) {
	    if (id > 0) {
	        InfTecnic e = serviceInf.findByIdInfo(id);
	        if (e != null) {
	            return new ResponseEntity<>(e, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } else {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@PostMapping("/save")
	public ResponseEntity<InfTecnic> save(@RequestBody InfTecnic informe) {
		informe.setActMaquina("Activo");
	    return new ResponseEntity<>(serviceInf.save(informe), HttpStatus.CREATED);
	}

	
}
