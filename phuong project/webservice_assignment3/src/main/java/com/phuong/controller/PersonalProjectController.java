package com.phuong.controller;

import java.util.List;

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
import com.phuong.entities.PhuongPersonalProjectRoleId;
import com.phuong.service.PersonalProjectRoleImpl;
import com.phuong.service.PhuongPersonalService;

@RestController
@RequestMapping("/api") 
@CrossOrigin(origins = { "*" })
public class PersonalProjectController {
	@Autowired
	PersonalProjectRoleImpl personprojectservecive;
	
	
	@RequestMapping(value = "/personproject/", method = RequestMethod.GET)
    public ResponseEntity<List<PhuongPersonalProjectRole>> listAll() {
        List<PhuongPersonalProjectRole> list = personprojectservecive.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PhuongPersonalProjectRole>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/personproject/", method = RequestMethod.POST)
    public PhuongPersonalProjectRole createTransactionData(@RequestBody PhuongPersonalProjectRole phuongperson, UriComponentsBuilder ucBuilder) {
		
		return personprojectservecive.save(phuongperson);
    }
	
	
	@RequestMapping(value = "/personproject/del/", method = RequestMethod.POST)
    public ResponseEntity<?> deleteUser(@RequestBody PhuongPersonalProjectRole id) {
       
    	//PhuongPersonalProjectRole phuong = personprojectservecive.findOne(id);
        
    	personprojectservecive.deleteById(id);
        return new ResponseEntity<PhuongPersonalProjectRole>(HttpStatus.NO_CONTENT);
    }
	
	
}
