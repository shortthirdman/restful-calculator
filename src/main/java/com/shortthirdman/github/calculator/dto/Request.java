package com.shortthirdman.github.calculator.dto;

import java.util.List;

public record Request(String operationType, List<Integer> operands) {
}
