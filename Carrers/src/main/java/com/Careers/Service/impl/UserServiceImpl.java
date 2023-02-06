package com.Careers.Service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Careers.Entity.UserEntity;
import com.Careers.Repository.UserRepository;
import com.Careers.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
    UserRepository userRepository;
    UserServiceImpl umpl;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}

	@Override
	public String presentTime() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		
		return sdf.format(timestamp);
	}

	@Override
	public List<UserEntity> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<UserEntity> hidePassword(List<UserEntity> users) {
		// TODO Auto-generated method stub
		for(UserEntity user:users)
		{
			user.setPassword("**********");
		}
		return users;
	}

	@Override
	public UserEntity updateUser(UserEntity user,long id) {
		// TODO Auto-generated method stub
		UserEntity olduser= userRepository.findById(id).orElse(null);
		
		if(olduser != null)
		{
			olduser.setDate_of_birth(user.getDate_of_birth());
			olduser.setEmail(user.getEmail());
			olduser.setFirstName(user.getFirstName());
			olduser.setGender(user.getGender());
			olduser.setMobileNo(user.getMobileNo());
			olduser.setModifiedBy(user.getFirstName()+" "+user.getSecondName());
			olduser.setModifiedDateTime(presentTime());
		//	olduser.setProfile();
			olduser.setRole_id(user.getId());
			olduser.setSecondName(user.getSecondName());
			olduser.setUserName(user.getUserName());
			olduser.setAddress(user.getAddress());
			olduser.setRole_id(user.getRole_id());
			return userRepository.save(olduser);
		}
		else
			return null;
	}

	@Override
	public String deleteUser(long id) {
		// TODO Auto-generated method stub
		UserEntity user=userRepository.findById(id).orElse(null);
		userRepository.delete(user);
		return "Deleted succesfully";
	}

	@Override
	public String deleteAllUsers() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
		return "All records are deleted";
	}

	@Override
	public UserEntity findUser(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	
    
}
