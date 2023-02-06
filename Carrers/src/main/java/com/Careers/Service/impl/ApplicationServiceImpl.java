package com.Careers.Service.impl;

import org.springframework.stereotype.Service;

import com.Careers.Entity.ApplicationEntity;
import com.Careers.Repository.ApplicationRepository;
import com.Careers.Service.ApplicationService;
@Service
public class ApplicationServiceImpl implements ApplicationService{

	ApplicationRepository applicationrepository;
	
	public ApplicationServiceImpl(ApplicationRepository applicationrepository) {
		super();
		this.applicationrepository = applicationrepository;
	}

	@Override
	public ApplicationEntity saveApplication(ApplicationEntity application) {
		// TODO Auto-generated method stub
		return applicationrepository.save(application);
	}

	
}
