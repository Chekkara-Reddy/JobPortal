package com.Careers.Service.impl;

import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Careers.Entity.ApplicationEntity;
import com.Careers.Repository.ApplicationRepository;
import com.Careers.Service.ApplicationService;
import com.Careers.Service.UserService;
@Service
public class ApplicationServiceImpl implements ApplicationService{

	ApplicationRepository applicationrepository;
	UserService userService;
	
	public ApplicationServiceImpl(ApplicationRepository applicationrepository, UserService userService) {
		super();
		this.applicationrepository = applicationrepository;
		this.userService = userService;
	}

	@Override
	public ApplicationEntity saveApplication(ApplicationEntity application) {
		// TODO Auto-generated method stub
		return applicationrepository.save(application);
	}

	@Override
	public ApplicationEntity findApplication(long id) {
		// TODO Auto-generated method stub
		ApplicationEntity application=applicationrepository.findById(id).orElse(null);
		return application;
	
	}

	@Override
	public List<ApplicationEntity> findAllApplications() {
		// TODO Auto-generated method stub
		return applicationrepository.findAll();	}

	@Override
	public ApplicationEntity editApplication(long id, ApplicationEntity application) {
		// TODO Auto-generated method stub
		ApplicationEntity oldApplication=applicationrepository.findById(id).orElse(null);
		
		oldApplication.setAdd(application.getAdd());
		oldApplication.setDate(application.getDate());
		oldApplication.setDeclaration(application.getDeclaration());
		oldApplication.setHobbies(application.getHobbies());
		oldApplication.setMobile(application.getMobile());
		oldApplication.setUsername(application.getUsername());
		oldApplication.setModifiedBy(application.getUsername());
		oldApplication.setModifiedDateTime(userService.presentTime());
		//oldApplication.setPersonalDetails(application.getPersonalDetails());
		oldApplication.setPlace(application.getPlace());
		oldApplication.setSkills(application.getSkills());
		oldApplication.setModifiedBy(application.getUsername());
		return applicationrepository.save(oldApplication);
	}

	@Override
	public String removeApplication(ApplicationEntity application) {
		// TODO Auto-generated method stub
		applicationrepository.delete(application);
		return "Application deleted ";
	}

	
}
