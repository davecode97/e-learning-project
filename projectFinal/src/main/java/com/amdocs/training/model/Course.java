package com.amdocs.training.model;

import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true)
    private String Name;

    @Column(nullable = false, unique = false, length = 50)
    private String Description;

    @Column(nullable = false, unique = false)
    private String Resources;

    @Column(nullable = false, unique = false, length = 50)
    private long Fees;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getResources() {
        return Resources;
    }

    public void setResources(String resources) {
        Resources = resources;
    }

    public long getFees() {
        return Fees;
    }

    public void setFees(long fees) {
        Fees = fees;
    }
}
