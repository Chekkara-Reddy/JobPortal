package com.Careers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Careers.Entity.JobPostEntity;

public interface JobRepository extends JpaRepository<JobPostEntity, Long>{

}
