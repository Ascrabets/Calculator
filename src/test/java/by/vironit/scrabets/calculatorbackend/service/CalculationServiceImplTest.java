package by.vironit.scrabets.calculatorbackend.service;

import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;
import by.vironit.scrabets.calculatorbackend.exception.WrongDataException;
import by.vironit.scrabets.calculatorbackend.operation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculationServiceImplTest {

    private List<Calculatable> calculators;

    private CalculationServiceImpl calculationService;

    @BeforeEach
    public void setUp() {
        calculators = List.of(
                new DivCalc(),
                new HighestPrimeCalc(),
                new ModDivCalc(),
                new SumCalc()
        );

        calculationService = new CalculationServiceImpl(calculators);
    }

    @Test
    void whenCalculateWithCorrectData_thenResultIsOk() {
        // given
        double op1 = 20d;
        double op2 = 10d;
        OperationType opType = OperationType.findBy("+");
        double expectedResult = 30d;

        // when
        double actualResult = calculationService.calculate(op1, op2, opType);

        // then
        then(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void whenDivisionByZero_thenThrowException() {
        // given
        double op1 = 20d;
        double op2 = 0;
        OperationType opType = OperationType.findBy("/");

        // when
        WrongDataException thrown = assertThrows(
                WrongDataException.class,
                () -> calculationService.calculate(op1, op2, opType),
                "Division by zero."
        );

        // then
        assertTrue(thrown.getMessage().contains("Division by zero."));
    }

    @Test
    void whenCalculateWithIncorrectOperationType_thenThrowException() {
        // given
        double op1 = 20d;
        double op2 = 0;
        OperationType opType = OperationType.findBy("aaa");
        String errorMessage = "Incorrect input data - " + op1 + " " + opType.getDescription() + " " + op2;

        // when
        WrongDataException thrown = assertThrows(
                WrongDataException.class,
                () -> calculationService.calculate(op1, op2, opType),
                errorMessage
        );

        // then
        assertTrue(thrown.getMessage().contains(errorMessage));
    }
}