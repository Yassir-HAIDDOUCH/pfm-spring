package com.student.student.exception;

import com.student.student.model.Student;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student not found with id: " + id);
    }
    public StudentNotFoundException() {
        super("Students not found ");
    }
    public StudentNotFoundException(Student student ) {
        super("We can't add : "+ student);
    }
}

