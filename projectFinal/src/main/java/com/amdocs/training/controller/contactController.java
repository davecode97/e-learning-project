package com.amdocs.training.controller;

import com.amdocs.training.model.Contact;
import com.amdocs.training.repository.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class contactController {
    @Autowired
    private contactRepository contactRepo;

    @GetMapping("/contact-form")
    public String showContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contacts";
    }

    @PostMapping("/process_contact")
    public String processContact(Contact contact) {
        contactRepo.save(contact);
        return "users";
    }

}
