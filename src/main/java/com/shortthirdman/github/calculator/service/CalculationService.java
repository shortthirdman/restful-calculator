package com.shortthirdman.github.calculator.service;

import com.shortthirdman.github.calculator.dto.Request;
import com.shortthirdman.github.calculator.dto.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationService {

    public Response calculate(Request request) {
        return switch (request.operationType()) {
            case "+" -> new Response(sum(request.operands()));
            case "*" -> new Response(multiply(request.operands()));
            default -> throw new IllegalArgumentException("Invalid operation: " + request.operationType());
        };
    }

    private int sum(List<Integer> operands) {
        if (operands == null || operands.isEmpty()) {
            return 0;
        }
        return operands.stream().mapToInt(i -> i).sum();
    }

    private int multiply(List<Integer> operands) {
        if (operands == null || operands.isEmpty()) {
            return 0;
        }
        int result = 1;
        for (Integer operand : operands) {
            result *= operand;
        }
        return result;
    }
}
