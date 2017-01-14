package com.fourtagz.repository;

import org.springframework.data.repository.CrudRepository;

import com.fourtagz.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long>, ProfileRepositoryCustom{

}
