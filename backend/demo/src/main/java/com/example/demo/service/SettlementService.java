package com.example.demo.service;

import com.example.demo.model.Settlement;
import com.example.demo.repository.SettlementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettlementService {

    private final SettlementRepository settlementRepository;

    public SettlementService(SettlementRepository settlementRepository) {
        this.settlementRepository = settlementRepository;
    }

    public Settlement createSettlement(Settlement settlement) {
        return settlementRepository.save(settlement);
    }

    public List<Settlement> getAllSettlements() {
        return settlementRepository.findAll();
    }

    public Settlement getSettlementById(Long id) {
        return settlementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Settlement not found with id " + id));
    }

    public void deleteSettlement(Long id) {
        settlementRepository.deleteById(id);
    }
}
