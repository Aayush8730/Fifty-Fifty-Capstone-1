package com.example.demo.service;

import com.example.demo.model.Approval;
import com.example.demo.repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;

    @Autowired
    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    // Retrieve all approvals
    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    // Retrieve an approval by ID
    public Optional<Approval> getApprovalById(Long id) {
        return approvalRepository.findById(id);
    }

    // Create or update an approval
    public Approval saveApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    // Delete an approval by ID
    public void deleteApprovalById(Long id) {
        approvalRepository.deleteById(id);
    }
}
