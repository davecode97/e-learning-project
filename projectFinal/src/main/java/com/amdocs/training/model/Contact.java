package com.amdocs.training.model;

import javax.persistence.*;

@Entity
@Table(name="contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String NameContact;

    @Column(nullable = false, unique = false)
    private String EmailContact;

    @Column(nullable = false, length = 45)
    private long PhoneContact;

    @Column(nullable = false, unique = false)
    private String MessageContact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameContact() {
        return NameContact;
    }

    public void setNameContact(String nameContact) {
        NameContact = nameContact;
    }

    public String getEmailContact() {
        return EmailContact;
    }

    public void setEmailContact(String emailContact) {
        EmailContact = emailContact;
    }

    public long getPhoneContact() {
        return PhoneContact;
    }

    public void setPhoneContact(long phoneContact) {
        PhoneContact = phoneContact;
    }

    public String getMessageContact() {
        return MessageContact;
    }

    public void setMessageContact(String messageContact) {
        MessageContact = messageContact;
    }
}
