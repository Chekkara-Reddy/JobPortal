package com.Careers.Service.impl;

import org.springframework.stereotype.Service;

import com.Careers.Entity.JobPostEntity;
import com.Careers.Repository.JobRepository;
import com.Careers.Service.JobService;

@Service
public class JobServiceImpl implements JobService{

	
	JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public JobPostEntity saveJob(JobPostEntity job) {
		// TODO Auto-generated method stub
		
		
		return jobRepository.save(job);
		
		
	}

	@Override
	public JobPostEntity findJob(long id) {
		// TODO Auto-generated method stub
		return jobRepository.findById(id).orElse(null);
	}

}
