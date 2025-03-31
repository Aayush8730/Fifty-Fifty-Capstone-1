package com.example.demo.repository;

import com.example.demo.model.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {
}
