package com.Careers.Service;

import java.util.List;


import com.Careers.Entity.ApplicationEntity;

public interface ApplicationService {

	
	ApplicationEntity saveApplication(ApplicationEntity application);
	ApplicationEntity findApplication(long id);
	List<ApplicationEntity> findAllApplications();
	ApplicationEntity editApplication(long id,ApplicationEntity application);
	String removeApplication(ApplicationEntity application);
}

