package com.fourtagz.repository;

import java.util.List;

import com.fourtagz.model.Profile;
import com.fourtagz.model.Relationship;

public interface RelationshipRepositoryCustom {

	public List<Relationship> list(String idUsuario);
	
}
