package com.raystech.Job_Application_Management_System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "File path is required")
    @Column(nullable = false)
    private String filePath;

    @NotBlank(message = "Resume name is required")
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime uploadDate;

    // Relationship: Many Resumes → One Candidate
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private User candidate;

    // === Constructors ===
    public Resume() {
        this.uploadDate = LocalDateTime.now();
    }

    public Resume(String filePath, String name, User candidate) {
        this();
        this.filePath = filePath;
        this.name = name;
        this.candidate = candidate;
    }

    // === Getters & Setters ===
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getCandidate() {
        return candidate;
    }

    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }

    // === equals(), hashCode(), toString() ===
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume resume)) return false;
        return Objects.equals(id, resume.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uploadDate=" + uploadDate +
                ", candidateId=" + (candidate != null ? candidate.getId() : null) +
                '}';
    }
}
