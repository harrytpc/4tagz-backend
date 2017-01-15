package com.fourtagz.repository;

import org.springframework.data.repository.CrudRepository;

import com.fourtagz.model.Relationship;

public interface RelationshipRepository extends CrudRepository<Relationship, String>, 
	RelationshipRepositoryCustom{

}
