package com.student.student.exception;

import com.student.student.model.Branch;

public class BranchNotFoundException extends RuntimeException {
    public BranchNotFoundException(Long id) {
        super("Branch not found with id: " + id);
    }
    public BranchNotFoundException() {
        super("Branchs not found ");
    }
    public BranchNotFoundException(Branch Branch ) {
        super("We can't add : "+ Branch);
    }
}

