package com.shortthirdman.github.calculator.controller;

import com.shortthirdman.github.calculator.dto.Request;
import com.shortthirdman.github.calculator.dto.Response;
import com.shortthirdman.github.calculator.service.CalculationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    private final CalculationService calculationService;

    public CalculateController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculate")
    public Response calculate(@RequestBody Request request) {
        return calculationService.calculate(request);
    }
}
