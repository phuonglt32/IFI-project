package com.phuong.controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.phuong.service.PersonalProjectRoleImpl;
import com.phuong.service.PhuongPersonalService;
import com.phuong.service.StorageServiceImpl;


@RestController
@RequestMapping("/api") 
@CrossOrigin(origins = { "*" })

public class PhuongPersonalController {

	public static final Logger log = LoggerFactory.getLogger(PhuongPersonalController.class);
	@Autowired
	PhuongPersonalService phuongservice;
	
	@Autowired
	PersonalProjectRoleImpl personprojectservecive;
	
	@Autowired
	StorageServiceImpl storeservice;
	
	@RequestMapping(value = "/person/", method = RequestMethod.GET)
    public ResponseEntity<List<PhuongPersonal>> listAll() {
        List<PhuongPersonal> list = phuongservice.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PhuongPersonal>>(list, HttpStatus.OK);
    }
	
	//-----------------------find project role by person id------------------
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public List<PhuongPersonalProjectRole> listprojectbyperson(@PathVariable("id") int id) {
		List<PhuongPersonalProjectRole> list = personprojectservecive.findprojectbyperson(id);
        return list;
    }
	
	
	//---------------------find person by id-----------------------
	@RequestMapping(value = "/person/personbyid/{id}", method = RequestMethod.GET)
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
    	storeservice.deleteWithname(phuong.getImage());
    	storeservice.deleteWithnameResouce(phuong.getImage());
        
    	phuongservice.deleteById(id);
        return new ResponseEntity<PhuongPersonal>(HttpStatus.NO_CONTENT);
    }
    
    // ------------------- Delete All CardCenters-----------------------------
 
    @RequestMapping(value = "/person/", method = RequestMethod.DELETE)
    public ResponseEntity<PhuongPersonal> deleteAll() {
    	
    	phuongservice.deleteAll();
        return new ResponseEntity<PhuongPersonal>(HttpStatus.NO_CONTENT);
    }
    
    //-----------------------delete by ids----------------------------
    @RequestMapping(value = "/person/del/",method = RequestMethod.POST)
    public ResponseEntity<?> deletebyids(@RequestBody String list){
    	list = list.replace("[", "").replace("]", "");
    	String[] list1 = list.split(",");
    	
    	for(String w:list1) {
    		personprojectservecive.deletebypersonid(Integer.parseInt(w));
    		phuongservice.deleteById(Integer.parseInt(w));
    	}
    	return new ResponseEntity<PhuongPersonal>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/person/personbyname/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> personByName(@PathVariable("name") String name) {
		List<PhuongPersonal> phuong =  phuongservice.findByName(name);
		
		if(phuong == null) {
			log.error("Error roi");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}else {
			log.info("OK nhe");
			return new ResponseEntity<List<PhuongPersonal>>(phuong,HttpStatus.OK);
		}
    }
}
