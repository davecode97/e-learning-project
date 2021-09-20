package com.amdocs.training.repository;

import com.amdocs.training.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface feedbackRepository extends JpaRepository<Feedback, Long> {
    @Query("SELECT f FROM Feedback f WHERE f.Email = ?1")
    Feedback findFeedbackBy(String email);
}
