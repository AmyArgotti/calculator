package com.example.calculator.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.calculator.models.CalculationHistory;
import com.example.calculator.models.User;
import com.example.calculator.repositories.CalculationHistoryRepository;
import com.example.calculator.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CalculationHistoryRepository calculationHistoryRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByLogin(username);
    }

    @Override
    public void saveCalculation(CalculationHistory calculation) {
        calculationHistoryRepository.save(calculation);
    }

    @Override
    public List<CalculationHistory> getCalculationHistory(User user) {
        return calculationHistoryRepository.findByUser(user);
    }
}