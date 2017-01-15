package com.fourtagz.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fourtagz.bo.RelationshipBO;
import com.fourtagz.model.Relationship;

@RestController
@RequestMapping("relationships")
public class RelationshipRest {
	
	@Autowired
	private RelationshipBO relationshipBO;
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Relationship> get(@RequestBody String id) {		
		Relationship r = relationshipBO.findById(id);
		return new ResponseEntity<Relationship>(r, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * Create a new relationship
	 * 
	 * @param user object
	 * @return user object with ID 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Relationship> create(@RequestBody Relationship relationship) {
		relationship.setId(UUID.randomUUID().toString());
		Relationship r = relationshipBO.insert(relationship);
		return new ResponseEntity<Relationship>(r, HttpStatus.CREATED);
	}
	
	
	/***
	 * deletes the relationship
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Relationship> delete(@PathVariable("id") String id) {
				
        Relationship relationship = relationshipBO.findById(id);
        
        if (relationship == null) {
            System.out.println("Unable to delete. Relationship with id " + id + " not found");
            return new ResponseEntity<Relationship>(HttpStatus.OK);
        }
 
        relationshipBO.deleteById(id);        
        return new ResponseEntity<Relationship>(HttpStatus.NO_CONTENT);
        
	}	
}
