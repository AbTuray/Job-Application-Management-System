package com.raystech.Job_Application_Management_System.repository;

import com.raystech.Job_Application_Management_System.entity.Job;
import com.raystech.Job_Application_Management_System.entity.JobStatus;
import com.raystech.Job_Application_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByEmployer(User employer);
    List<Job> findByStatus(JobStatus status);
    List<Job> findByEmployerAndStatus(User employer, JobStatus status);
}
