package by.vironit.scrabets.calculatorbackend.operation;

import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;

/**
 * To add new calc operation, do the following:
 * 1. Add required operation type to {@link by.vironit.scrabets.calculatorbackend.enumeration.OperationType}.
 * 2. Implement {@link Calculatable#calculate(double, double)} and {@link Calculatable#operationType()}
 */
public interface Calculatable {

    double calculate(double operand1, double operand2);

    OperationType operationType();
}
