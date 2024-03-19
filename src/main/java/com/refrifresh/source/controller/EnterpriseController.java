package com.refrifresh.source.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.refrifresh.source.entity.Enterprise;
import com.refrifresh.source.service.EnterpriseService;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
	
	private final EnterpriseService serviceEnterprise;
	
	public EnterpriseController(EnterpriseService serviceEnterprise) {
		this.serviceEnterprise = serviceEnterprise;
	}
	
	@GetMapping("/list-enterprise")
	public ResponseEntity<List<Enterprise>> getEnterprise(){
		return new ResponseEntity<>(serviceEnterprise.getEnterprise(), HttpStatus.OK);
	}
	
	@GetMapping("/list-active")
	public ResponseEntity<List<Enterprise>> getActive(){
		return new ResponseEntity<>(serviceEnterprise.getActive(), HttpStatus.OK);
	}
	
	@GetMapping("/list-inactive")
	public ResponseEntity<List<Enterprise>> getInactive(){
		return new ResponseEntity<>(serviceEnterprise.getInactive(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{idEnterprise}")
	public ResponseEntity<Enterprise> findByIdEnterprise(@PathVariable("idEnterprise") int idEnterprise) {
	    if (idEnterprise > 0) {
	        Enterprise e = serviceEnterprise.findByIdEnterprise(idEnterprise);
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
	public ResponseEntity<Enterprise> save(@RequestBody Enterprise enterprise) {
		enterprise.setActEmpresa("Activo");
	    return new ResponseEntity<>(serviceEnterprise.save(enterprise), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Enterprise> update(@PathVariable("id") int id, @RequestBody Enterprise update) {
		try {
			Enterprise exist = serviceEnterprise.findByIdEnterprise(id);
			if(exist!=null){
				exist.setRucEmpresa(update.getRucEmpresa());
				exist.setRzcEmpresa(update.getRzcEmpresa());
				exist.setNcoEmpresa(update.getNcoEmpresa());
				exist.setDirEmpresa(update.getDirEmpresa());
				exist.setDisEmpresa(update.getDisEmpresa());
				Enterprise updateAfter = serviceEnterprise.update(exist);
				return new ResponseEntity<>(updateAfter, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(update, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(update, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete-soft/{id}")
	public ResponseEntity<List<Enterprise>> deleteSoft(@PathVariable int id){
		try {
			Enterprise enterprise = serviceEnterprise.findByIdEnterprise(id);
			if(enterprise!=null){
				enterprise.setActEmpresa("Inactivo");
				serviceEnterprise.update(enterprise);
				List<Enterprise> active = serviceEnterprise.getActive();
				return new ResponseEntity<>(active, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete-hard/{id}")
	public ResponseEntity<List<Enterprise>> deleteHard(@PathVariable int id){
		try {
			Enterprise enterprise = serviceEnterprise.findByIdEnterprise(id);
			if(enterprise!=null){
				serviceEnterprise.delete(enterprise);
				List<Enterprise> active = serviceEnterprise.getActive();
				return new ResponseEntity<>(active, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
