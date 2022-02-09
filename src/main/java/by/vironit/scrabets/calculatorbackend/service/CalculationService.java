package by.vironit.scrabets.calculatorbackend.service;

import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;

public interface CalculationService {

    Double calculate(final Double op1, final Double op2, final OperationType opType);
}