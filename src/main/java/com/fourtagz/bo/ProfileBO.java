package com.fourtagz.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourtagz.model.Profile;
import com.fourtagz.repository.ProfileRepository;

@Service
public class ProfileBO {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public List<Profile> getById(Long userId){
		List<Profile> profileList = profileRepository.example();
		return profileList;
	}

}
