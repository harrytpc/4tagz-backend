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
	
	public Profile insert(Profile profile){
		profile = profileRepository.save(profile);
		return profile;
	}
	
	public Profile getDadosById(Long profileId){
		Profile profile = profileRepository.findOne(profileId);
		return profile;
	}
	
	public Profile update(Profile profile){
		profile = update(profile);		
		return profile;
	}

}
