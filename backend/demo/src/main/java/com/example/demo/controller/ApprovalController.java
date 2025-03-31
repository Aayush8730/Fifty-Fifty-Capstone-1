package com.example.demo.controller;

import com.example.demo.model.Approval;
import com.example.demo.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;

    @Autowired
    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    // Get all approvals
    @GetMapping
    public ResponseEntity<List<Approval>> getAllApprovals() {
        List<Approval> approvals = approvalService.getAllApprovals();
        return ResponseEntity.ok(approvals);
    }

    // Get approval by ID
    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable Long id) {
        Optional<Approval> approval = approvalService.getApprovalById(id);
        return approval.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new approval
    @PostMapping
    public ResponseEntity<Approval> createApproval(@RequestBody Approval approval) {
        Approval savedApproval = approvalService.saveApproval(approval);
        return ResponseEntity.ok(savedApproval);
    }

    // Update an approval
    @PutMapping("/{id}")
    public ResponseEntity<Approval> updateApproval(@PathVariable Long id, @RequestBody Approval approval) {
        Optional<Approval> existingApproval = approvalService.getApprovalById(id);
        if (existingApproval.isPresent()) {
            approval.setApprovalId(id);
            Approval updatedApproval = approvalService.saveApproval(approval);
            return ResponseEntity.ok(updatedApproval);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an approval
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApproval(@PathVariable Long id) {
        Optional<Approval> existingApproval = approvalService.getApprovalById(id);
        if (existingApproval.isPresent()) {
            approvalService.deleteApprovalById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
