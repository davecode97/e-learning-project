package com.amdocs.training.controller;

import com.amdocs.training.model.Feedback;
import com.amdocs.training.repository.feedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class feedbackController {
    @Autowired
    private feedbackRepository feedbackRepo;

    @GetMapping("/feedback-form")
    public String showFeedback(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback";
    }

    @PostMapping("/process_feedback")
    public String processFeedback(Feedback feedback) {
        feedbackRepo.save(feedback);
        return "users";
    }
}
