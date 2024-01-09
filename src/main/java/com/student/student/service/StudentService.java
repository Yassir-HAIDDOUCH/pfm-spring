package com.student.student.service;

import com.student.student.model.Student;
import com.student.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.student.exception.StudentNotFoundException;

import java.util.List;


@Service
public class StudentService {
    private final StudentRepository StudentRepository;

    @Autowired
    public StudentService(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    public List<Student> getAllStudents() {
        return StudentRepository.findAll();
        
    }

    public Student getStudentById(Long id) {
        return StudentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student saveStudent(Student Student) {
        return StudentRepository.save(Student);
    }

    public void deleteStudent(Long id) {
        if (!StudentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        StudentRepository.deleteById(id);
    }
}