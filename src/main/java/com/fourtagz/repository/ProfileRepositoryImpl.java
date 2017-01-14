package com.fourtagz.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fourtagz.model.Profile;

public class ProfileRepositoryImpl implements ProfileRepositoryCustom{

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Profile> example() {
		Map<String, Object> params = new HashMap<>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT u FROM Profile u");
		sb.append(" where 1=1");
		
		
		Query query = em.createQuery(sb.toString());
		for(Map.Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
	    return (List<Profile>) query.getResultList();
	}
	
}
