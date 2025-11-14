package com.raystech.Job_Application_Management_System.repository;

import com.raystech.Job_Application_Management_System.entity.Resume;
import com.raystech.Job_Application_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findByCandidate(User candidate);
}
