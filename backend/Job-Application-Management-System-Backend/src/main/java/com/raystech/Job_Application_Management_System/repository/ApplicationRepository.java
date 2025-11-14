package com.raystech.Job_Application_Management_System.repository;

import com.raystech.Job_Application_Management_System.entity.Application;
import com.raystech.Job_Application_Management_System.entity.ApplicationStatus;
import com.raystech.Job_Application_Management_System.entity.Job;
import com.raystech.Job_Application_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // Candidate: my applications
    List<Application> findByCandidate(User candidate);
    // Employer: applicants for a job (only APPROVED)
    List<Application> findByJob(Job job);
    // Admin: all pending / approved
    List<Application> findByJobAndStatus(Job job, Application status);
    // Admin: all applications for a job
    List<Application> findByStatus(ApplicationStatus status);

}
