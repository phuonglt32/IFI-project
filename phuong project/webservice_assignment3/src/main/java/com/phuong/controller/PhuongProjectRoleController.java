package com.phuong.controller;

import java.util.List;

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

import com.phuong.entities.PhuongProjectRole;
import com.phuong.service.PhuongProjectRoleService;

@RestController
@RequestMapping("/api") 
@CrossOrigin(origins = { "http://localhost:4200" })
public class PhuongProjectRoleController {

	@Autowired
	PhuongProjectRoleService phuongprojectrole;
	
	
	@RequestMapping(value = "/projectrole/", method = RequestMethod.GET)
    public ResponseEntity<List<PhuongProjectRole>> listAll() {
        List<PhuongProjectRole> list = phuongprojectrole.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<PhuongProjectRole>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/projectrole/", method = RequestMethod.POST)
    public ResponseEntity<?> createTransactionData(@RequestBody PhuongProjectRole phuongperson, UriComponentsBuilder ucBuilder) {
		
		phuongprojectrole.save(phuongperson);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/projectrole/{id}").buildAndExpand(phuongperson.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	
	 // ------------------- Update a CardCenters ------------------------------------------------
	 
    @RequestMapping(value = "/projectrole/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody PhuongProjectRole phuongperson) {
        
    	PhuongProjectRole phuong = phuongprojectrole.findOne(id);
 
    	phuongprojectrole.save(phuong);
        return new ResponseEntity<PhuongProjectRole>(phuong, HttpStatus.OK);
    }
 
    // ------------------- Delete a CardCenters-----------------------------------------
 
    @RequestMapping(value = "/projectrole/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
       
    	PhuongProjectRole phuong = phuongprojectrole.findOne(id);
        
    	phuongprojectrole.deleteById(id);
        return new ResponseEntity<PhuongProjectRole>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All CardCenters-----------------------------
 
    @RequestMapping(value = "/projectrole/", method = RequestMethod.DELETE)
    public ResponseEntity<PhuongProjectRole> deleteAll() {
 
    	phuongprojectrole.deleteAll();
        return new ResponseEntity<PhuongProjectRole>(HttpStatus.NO_CONTENT);
    }
}
