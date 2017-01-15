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

import com.fourtagz.bo.ProfileBO;
import com.fourtagz.model.Profile;

@RestController
@RequestMapping("profiles")
public class ProfileRest {
	
	@Autowired
	private ProfileBO profileBO;	
	
	//Inserir Perfil de usuário
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Profile> create(@RequestBody Profile profile) {		
		
		profile.setId(UUID.randomUUID().toString());
		Profile p = profileBO.insert(profile);
		return new ResponseEntity<Profile>(p, HttpStatus.CREATED);
	}
	
	//Recupera dados do perfil
	@RequestMapping(value = "/{profileId}", method = RequestMethod.GET)
	public ResponseEntity<Profile> getUserProfile(@PathVariable("profileId") String profileId){
		
		
		Profile profile = profileBO.getDadosById(profileId);
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}
	
	//Atualiza dados do perfil
	@RequestMapping(value = "/{profileId}", method = RequestMethod.PUT)
	public ResponseEntity<Profile> updateProfile(@PathVariable("profileId") String profileId, @RequestBody Profile profile){
		
		Profile p = profileBO.update(profile);		
		return new ResponseEntity<Profile>(p, HttpStatus.OK);				
	}
	
	//Remove perfil
	@RequestMapping(value = "/{profileId}", method = RequestMethod.DELETE)
	public ResponseEntity<Profile> delete(@PathVariable("profileId") String profileId){
		
		Profile profile = profileBO.getDadosById(profileId);
		
		 if (profile == null) {
	            System.out.println("Unable to delete. Profile with id " + profileId + " not found");
	            return new ResponseEntity<Profile>(HttpStatus.OK);
	        }
		 
		profileBO.deleteById(profileId);
		return new ResponseEntity<Profile>(HttpStatus.NO_CONTENT);
	}
	

}
