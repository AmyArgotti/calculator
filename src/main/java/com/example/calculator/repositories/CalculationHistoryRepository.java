package com.example.calculator.repositories;



import com.example.calculator.models.CalculationHistory;
import com.example.calculator.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculationHistoryRepository extends JpaRepository<CalculationHistory, Long> {
    List<CalculationHistory> findByUser(User user);
}
