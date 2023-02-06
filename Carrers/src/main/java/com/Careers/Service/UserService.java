package com.Careers.Service;

import java.sql.Timestamp;
import java.util.List;


import com.Careers.Entity.UserEntity;

public interface UserService {
	

	UserEntity saveUser(UserEntity user);
	//byte[] uploadImage(MultipartFile file);
	String presentTime();
	UserEntity findUser(long id);
    List<UserEntity> findAllUsers();
   
    List<UserEntity> hidePassword(List<UserEntity> users);
    UserEntity updateUser(UserEntity user,long id);
    String deleteUser(long id);
    String deleteAllUsers();
}
