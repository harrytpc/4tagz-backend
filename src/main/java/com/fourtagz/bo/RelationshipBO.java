package com.fourtagz.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourtagz.model.Relationship;
import com.fourtagz.repository.RelationshipRepository;

public class RelationshipBO {
	
	@Autowired
	private RelationshipRepository relationshipRepository;

}
