package com.Careers.Service;

import com.Careers.Entity.JobPostEntity;

public interface JobService {

	JobPostEntity saveJob(JobPostEntity job);
	JobPostEntity findJob(long id);
}
