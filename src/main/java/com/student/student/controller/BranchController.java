package com.student.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.student.student.exception.StudentNotFoundException;
import com.student.student.model.Branch;
import com.student.student.service.BranchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping("/api/branchs")
public class BranchController {

    @Autowired
    private BranchService branchService;

  
    @GetMapping
    public List<Branch> getAllBranches() {
        return branchService.getAllBranchs();
    }

    @GetMapping("/{id}")
    public Branch getBranchById(@PathVariable Long id) {
            return branchService.getBranchById(id);   
    }

    @PostMapping
    public Branch createBranch(@RequestBody Branch branch) {
        return branchService.saveBranch(branch);
         
    }

  

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
    }

     @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException ex) {
        return ex.getMessage();
    }
}
