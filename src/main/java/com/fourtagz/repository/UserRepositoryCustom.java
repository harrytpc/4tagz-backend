package com.fourtagz.repository;

import java.util.List;

import com.fourtagz.model.User;

public interface UserRepositoryCustom {

	public List<User> example();

	public List<User> findByEmail(String email);
}
