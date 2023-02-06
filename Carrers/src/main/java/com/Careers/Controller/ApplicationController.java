package com.Careers.Controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Careers.Entity.ApplicationEntity;
import com.Careers.Service.ApplicationService;

@RestController
public class ApplicationController {
	
	public ApplicationService applicationService;

	public ApplicationController(ApplicationService applicationService) {
		super();
		this.applicationService = applicationService;
	}
	@PostMapping(value={"/apply/job"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<ApplicationEntity> newApplication(@RequestPart("apply") ApplicationEntity application,@RequestPart("resume") MultipartFile file)
	{
		
		try {
			application.setResume(file.getBytes());
			application.setResumeType(file.getContentType());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<ApplicationEntity>(applicationService.saveApplication(application),HttpStatus.CREATED);
	}

}
