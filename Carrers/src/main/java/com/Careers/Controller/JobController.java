package com.Careers.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Careers.Entity.JobPostEntity;
import com.Careers.Service.JobService;

@RestController
public class JobController {
	
	private JobService jobService;

	
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	@PostMapping("add/job")
	public ResponseEntity<JobPostEntity> saveJob(@RequestBody JobPostEntity job)
	{
		return new ResponseEntity<JobPostEntity>(jobService.saveJob(job),HttpStatus.CREATED);
	}
	
	@GetMapping("find/job/{id}")
	public JobPostEntity findJob(@PathVariable long id)
	{
		return jobService.findJob(id);
	}

	@PutMapping("/updateJob/{id}")
	public ResponseEntity<JobPostEntity> updateJob(@PathVariable long id,@RequestBody JobPostEntity job)
	{
		JobPostEntity oldJob= jobService.findJob(id);
		oldJob.setCompanyName(job.getCompanyName());
		oldJob.setDesignation(job.getDesignation());
		oldJob.setLast_date(job.getLast_date());
		oldJob.setLocation(job.getLocation());
		oldJob.setSalary(job.getSalary());
		oldJob.setSkillsrequired(job.getSkillsrequired());
		return new ResponseEntity<JobPostEntity>(jobService.saveJob(oldJob),HttpStatus.OK);
	}
	
}
