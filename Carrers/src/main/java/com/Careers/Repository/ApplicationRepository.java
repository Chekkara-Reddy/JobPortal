package com.Careers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Careers.Entity.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

}
