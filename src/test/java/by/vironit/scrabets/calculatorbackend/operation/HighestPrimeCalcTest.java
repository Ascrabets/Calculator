package by.vironit.scrabets.calculatorbackend.operation;

import by.vironit.scrabets.calculatorbackend.exception.WrongDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HighestPrimeCalcTest {

    private HighestPrimeCalc highestPrimeCalc;

    @BeforeEach
    public void setUp() {
        highestPrimeCalc = new HighestPrimeCalc();
    }

    @Test
    void whenCalculateWithCorrectOperands_thenResultIsOk() {
        // given
        double op1 = 2d;
        double op2 = 10d;
        double expectedResult = 7d;

        // when
        double actualResult = highestPrimeCalc.calculate(op1, op2);

        // then
        then(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void whenResultIsLowerThan1_thenThrowException() {
        // given
        double op1 = -2d;
        double op2 = -20d;

        // when
        WrongDataException thrown = assertThrows(
                WrongDataException.class,
                () -> highestPrimeCalc.calculate(op1, op2),
                "Prime should be natural number > 1."
        );

        // then
        assertTrue(thrown.getMessage().contains("Prime should be natural number > 1."));
    }
}