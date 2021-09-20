package com.amdocs.training.repository;

import com.amdocs.training.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface contactRepository extends JpaRepository<Contact, Long> {
    @Query("SELECT c FROM Contact c WHERE c.EmailContact = ?1")
    Contact findByEmail(String email);
}
