package com.amdocs.training;

import com.amdocs.training.model.Contact;
import com.amdocs.training.repository.contactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ContactResposityTest {

    @Autowired
    private contactRepository repo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateContact() {
        Contact contact = new Contact();
        contact.setNameContact("TestContact");
        contact.setEmailContact("testContact@amdocs.com");
        contact.setPhoneContact(12231212);
        contact.setMessageContact("This is test message from JUnit");

        Contact saveContact = repo.save(contact);

        Contact exitsContact = testEntityManager.find(Contact.class, saveContact.getId());

        assertThat(exitsContact.getEmailContact()).isEqualTo(contact.getEmailContact());
    }

    @Test
    public void testFindContactByEmail() {
        String email = "testContact@amdocs.com";
        Contact contact = repo.findByEmail(email);

        assertThat(contact).isNotNull();
    }
}
