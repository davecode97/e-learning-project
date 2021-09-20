package com.amdocs.training.controller;

import com.amdocs.training.model.Course;
import com.amdocs.training.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class courseController {
    @Autowired
    private courseRepository courseRepo;

    @GetMapping("/course-form")
    public String showCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courses";
    }

    @PostMapping("/process_course")
    public String processContact(Course course) {
        courseRepo.save(course);
        return "users";
    }
}

