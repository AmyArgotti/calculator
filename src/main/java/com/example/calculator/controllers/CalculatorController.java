package com.example.calculator.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.calculator.models.User;
import com.example.calculator.services.CalculatorService;
import com.example.calculator.models.CalculationHistory;
import com.example.calculator.services.UsersService;

import java.util.List;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/calculator")
    public String showCalculator(Model model) {
        model.addAttribute("calculation", new CalculationHistory());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(CalculationHistory calculation, @AuthenticationPrincipal User user) {
        double result = calculatorService.calculate(calculation.getLineEntered());
        calculation.setCalculationResult(result);
        calculation.setUser(user);
        usersService.saveCalculation(calculation);
        return "redirect:/calculator";
    }

    @GetMapping("/history")
    public String showHistory(Model model, @AuthenticationPrincipal User user) {
        List<CalculationHistory> history = usersService.getCalculationHistory(user);
        model.addAttribute("history", history);
        return "history";
    }
}