package com.Careers.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Careers.Entity.UserEntity;
import com.Careers.Service.UserService;
public interface UserRepository extends JpaRepository<UserEntity,Long>{
	
   

}
