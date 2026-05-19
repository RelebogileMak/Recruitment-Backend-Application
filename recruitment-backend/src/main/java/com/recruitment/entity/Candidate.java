package com.recruitment.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String cvFilePath;
    private String interviewNotes;
    private Integer interviewScore;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public enum Status {
        NEW, SCREENING, INTERVIEW, OFFERED, HIRED, REJECTED
    }
}