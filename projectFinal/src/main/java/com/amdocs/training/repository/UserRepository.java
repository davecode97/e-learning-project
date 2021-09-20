package com.amdocs.training.repository;

import com.amdocs.training.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.Email = ?1")
    User findByEmail(String email); // Investigate
}
