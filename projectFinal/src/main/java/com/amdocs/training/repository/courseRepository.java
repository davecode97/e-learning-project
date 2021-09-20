package com.amdocs.training.repository;

import com.amdocs.training.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface courseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE c.Name = ?1")
    Course findCourseBy(String name);
}
