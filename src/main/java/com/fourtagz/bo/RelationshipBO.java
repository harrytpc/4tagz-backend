package com.fourtagz.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourtagz.model.Relationship;
import com.fourtagz.repository.RelationshipRepository;

@Service
public class RelationshipBO {
	
	@Autowired
	RelationshipRepository relationshipRepository;
	
	/**
	 * 
	 * insert user
	 * 
	 * @param user
	 * @return
	 */
	public Relationship insert(Relationship relationship){
		relationship = relationshipRepository.save(relationship);
		return relationship;
	}
	
	public List<Relationship> example(){
		List<Relationship> userList = relationshipRepository.example();
		return userList;
	}
	
	public List<Relationship> list(Long userId){
		List<Relationship> userList = relationshipRepository.list(userId);
		return userList;
	}

}
