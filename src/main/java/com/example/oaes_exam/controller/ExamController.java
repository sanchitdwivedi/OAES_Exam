package com.example.oaes_exam.controller;

import com.example.oaes_exam.entity.Student;
import com.example.oaes_exam.service.ExamService;
import com.example.oaes_exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String startExam() throws Exception {
        examService.notifySubscribers();
        return "Starting exam of all subscribed students...";
    }

    @GetMapping("/subscribe/{userID}")
    public String subscribe(@PathVariable long userID) throws Exception {
        Student s = (Student) userService.getUserById(userID);
        System.out.println(s);
        examService.subscribe(s);
        return "Successfully subscribed to the exam";
    }
}
