package com.fourtagz.repository;

import java.util.List;

import com.fourtagz.model.Profile;
import com.fourtagz.model.Relationship;

public interface RelationshipRepositoryCustom {

	public List<Relationship> example();
	public List<Relationship> list(Long idUsuario);
	
}
