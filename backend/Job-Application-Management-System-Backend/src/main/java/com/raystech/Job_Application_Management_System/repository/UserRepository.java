package com.raystech.Job_Application_Management_System.repository;

import com.raystech.Job_Application_Management_System.entity.Role;
import com.raystech.Job_Application_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    // Admin: view all employers / candidates
    List<User> findByRole(Role role);
}
