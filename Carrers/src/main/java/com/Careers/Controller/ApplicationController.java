package com.Careers.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Careers.Entity.ApplicationEntity;
import com.Careers.Entity.UserEntity;
import com.Careers.Repository.UserRepository;
import com.Careers.Service.ApplicationService;
import com.Careers.Service.UserService;

@RestController
public class ApplicationController {
	
	public ApplicationService applicationService;
	public UserRepository userRepository;
    public UserService userService;
	
	

	public ApplicationController(ApplicationService applicationService, UserRepository userRepository,
			UserService userService) {
		super();
		this.applicationService = applicationService;
		this.userRepository = userRepository;
		this.userService = userService;
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
		applicationService.saveApplication(application);	
		UserEntity user= userRepository.findById(application.getUserId()).orElse(null);
		application.setCreatedBy(user.getFirstName()+" "+user.getSecondName());
		application.setCreatedDateTime(userService.presentTime());
		applicationService.saveApplication(application);
		application.setResume(null);
		return new ResponseEntity<ApplicationEntity>(application,HttpStatus.CREATED);
	}
	
	@GetMapping("/downloadResume/{id}")
	public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable long id) throws Exception
	
	{
	   ApplicationEntity application =applicationService.findApplication(id);
	
	   
	   return ResponseEntity.ok()
			   .contentType(MediaType.parseMediaType(application.getResumeType()))
			   .header(HttpHeaders.CONTENT_DISPOSITION, "image; filename=\""+application .getUsername()+ "\"")
			   .body(new ByteArrayResource(application.getResume()));
	}
	@GetMapping("/find/application/{id}")
	public ApplicationEntity findApplication(@PathVariable long id) throws Exception
	{
		ApplicationEntity application = applicationService.findApplication(id);
		return application;
	}
	@GetMapping("/find/application")
	public List<ApplicationEntity> findAllApplications() throws Exception
	{
		return applicationService.findAllApplications();
	}
	@PutMapping("/update/job/{id}")
	public ResponseEntity<ApplicationEntity> editApplication(@PathVariable long id, @RequestBody ApplicationEntity application)
	{
		application.setModifiedDateTime(userService.presentTime());
		return new ResponseEntity<ApplicationEntity>(applicationService.editApplication(id, application),HttpStatus.OK);
	}
	@DeleteMapping("/delete/application/{id}")
	public String removeApplication(@PathVariable long id) throws Exception
	{
		ApplicationEntity application = applicationService.findApplication(id);
		 return applicationService.removeApplication(application);

	}

}
