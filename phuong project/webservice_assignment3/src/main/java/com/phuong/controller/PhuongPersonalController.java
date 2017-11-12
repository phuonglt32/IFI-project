package com.phuong.controller;

import java.util.List;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.phuong.entities.PhuongPersonal;
import com.phuong.entities.PhuongPersonalProjectRole;
import com.phuong.entities.PhuongProjectRole;
import com.phuong.service.PersonalProjectRoleImpl;
import com.phuong.service.PhuongPersonalService;


@RestController
@RequestMapping("/api") 
@CrossOrigin(origins = { "*" })

public class PhuongPersonalController {

	public static final Logger log = LoggerFactory.getLogger(PhuongPersonalController.class);
	@Autowired
	PhuongPersonalService phuongservice;
	
	@Autowired
	PersonalProjectRoleImpl personprojectservecive;
	
	@RequestMapping(value = "/person/", method = RequestMethod.GET)
    public ResponseEntity<List<PhuongPersonal>> listAll() {
        List<PhuongPersonal> list = phuongservice.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PhuongPersonal>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public List<PhuongPersonalProjectRole> listprojectbyperson(@PathVariable("id") int id) {
		List<PhuongPersonalProjectRole> list = personprojectservecive.findprojectbyperson(id);
        return list;
    }
	
	@RequestMapping(value = "/personbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> personById(@PathVariable("id") int id) {
		PhuongPersonal phuong =  phuongservice.findOne(id);
		
		if(phuong == null) {
			log.error("Error roi");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}else {
			log.info("OK nhe");
			return new ResponseEntity<PhuongPersonal>(phuong,HttpStatus.OK);
		}
    }
	
	@RequestMapping(value = "/person/", method = RequestMethod.POST)
    public PhuongPersonal createTransactionData(@RequestBody PhuongPersonal phuongperson, UriComponentsBuilder ucBuilder) {
		
		
		return phuongservice.save(phuongperson);
        
    }
	
	 // ------------------- Update a CardCenters ------------------------------------------------
	 
    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public PhuongPersonal updateUser(@PathVariable("id") int id, @RequestBody PhuongPersonal phuongperson) {
        
    	//PhuongPersonal phuong = phuongservice.findOne(id);
 
     	return phuongservice.save(phuongperson);
        
    }
 
    // ------------------- Delete a CardCenters-----------------------------------------
 
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
       
    	PhuongPersonal phuong = phuongservice.findOne(id);
        
    	phuongservice.deleteById(id);
        return new ResponseEntity<PhuongPersonal>(HttpStatus.NO_CONTENT);
    }
    
    // ------------------- Delete All CardCenters-----------------------------
 
    @RequestMapping(value = "/person/", method = RequestMethod.DELETE)
    public ResponseEntity<PhuongPersonal> deleteAll() {
 
    	phuongservice.deleteAll();
        return new ResponseEntity<PhuongPersonal>(HttpStatus.NO_CONTENT);
    }
}
