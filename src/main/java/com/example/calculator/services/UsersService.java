package com.example.calculator.services;


import com.example.calculator.models.User;
import com.example.calculator.models.CalculationHistory;

import java.util.List;


public interface UsersService {
    void saveUser(User user);

    User findByUsername(String username);

    void saveCalculation(CalculationHistory calculation);

    List<CalculationHistory> getCalculationHistory(User user);
}
