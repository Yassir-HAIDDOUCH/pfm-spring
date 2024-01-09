package com.student.student.service;

import com.student.student.model.Branch;
import com.student.student.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.student.exception.BranchNotFoundException;

import java.util.List;


@Service
public class BranchService {
    private final BranchRepository BranchRepository;

    @Autowired
    public BranchService(BranchRepository BranchRepository) {
        this.BranchRepository = BranchRepository;
    }

    public List<Branch> getAllBranchs() {
        return BranchRepository.findAll();
    }

    public Branch getBranchById(Long id) {
        return BranchRepository.findById(id)
                .orElseThrow(() -> new BranchNotFoundException(id));
    }

    public Branch saveBranch(Branch branch) {
        return BranchRepository.save(branch);
    }

    
    public void deleteBranch(Long id) {
        if (!BranchRepository.existsById(id)) {
            throw new BranchNotFoundException(id);
        }
        BranchRepository.deleteById(id);
    }
}