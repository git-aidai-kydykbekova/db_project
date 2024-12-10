package org.example.dp_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class CategoryControllerHTML {

    @GetMapping("/categories")
    public String categories() {
        return "category.html";
    }

    @GetMapping("/courses")
    public String courses() {
        return "courses.html";
    }

    @GetMapping("/instructors")
    public String instructors() {
        return "instructor.html";
    }

    @GetMapping("/students")
    public String students() {
        return "student.html";
    }

    @GetMapping("/feedback")
    public String feedback() {
        return "feedback.html";
    }

}
