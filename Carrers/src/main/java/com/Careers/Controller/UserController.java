package com.Careers.Controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Careers.Entity.UserEntity;
import com.Careers.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping(value={"/user/add"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<UserEntity> saveUser(@RequestPart("user") UserEntity user,@RequestPart("profile") MultipartFile file)
	{

		byte[] picBytes=null;
	    try {
		 picBytes=file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	    user.setProfile(picBytes);
	    user.setPicType(file.getContentType());
	    user.setCreatedBy(user.getFirstName()+" "+user.getSecondName());
	   
	    user.setCreatedDateTime(userService.presentTime());
		return new ResponseEntity<UserEntity>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/showAll")
	public List<UserEntity> getAllUsers()
	{
		List<UserEntity> users=userService.findAllUsers();
		
		return userService.hidePassword(users);
	}
	@GetMapping("/search/{id}")
	public UserEntity findUser(@PathVariable("id") long id)
	{
		return userService.findUser(id);
	}
	@GetMapping("/download/{id}")
	public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable long id) throws Exception
	
	{
	   UserEntity user =userService.findUser(id);
	 
	   return ResponseEntity.ok()
			   .contentType(MediaType.parseMediaType(user.getPicType()))
			   .header(HttpHeaders.CONTENT_DISPOSITION, "image; filaename=\""+ user.getFirstName()+ "\"")
			   .body(new ByteArrayResource(user.getProfile()));
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable("id") long id,@RequestPart("user") UserEntity user)
	{
		return new ResponseEntity<UserEntity>(userService.updateUser(user, id),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id)
	{
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted Successfully",HttpStatus.OK);
	}
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteUser()
	{
		userService.deleteAllUsers();
		return new ResponseEntity<String>(" All Users Deleted Successfully",HttpStatus.OK);
	}

}