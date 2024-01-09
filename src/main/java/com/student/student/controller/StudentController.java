package com.student.student.controller;

import com.student.student.model.Student;
import com.student.student.exception.StudentNotFoundException;
import com.student.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService StudentService;

    @Autowired
    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return StudentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return StudentService.getStudentById(id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student Student) {
        return StudentService.saveStudent(Student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        StudentService.deleteStudent(id);
    }

    // Exception handler for StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException ex) {
        return ex.getMessage();
    }
}