package by.vironit.scrabets.calculatorbackend.operation;

import by.vironit.scrabets.calculatorbackend.exception.WrongDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DivCalcTest {

    private DivCalc divCalc;

    @BeforeEach
    public void setUp() {
        divCalc = new DivCalc();
    }

    @Test
    void whenCalculateWithCorrectOperands_thenResultIsOk() {
        // given
        double op1 = 20d;
        double op2 = 10d;
        double expectedResult = 2d;

        // when
        double actualResult = divCalc.calculate(op1, op2);

        // then
        then(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void whenDivisionByZero_thenThrowException() {
        // given
        double op1 = 20d;
        double op2 = 0;

        // when
        WrongDataException thrown = assertThrows(
                WrongDataException.class,
                () -> divCalc.calculate(op1, op2),
                "Division by zero."
        );

        // then
        assertTrue(thrown.getMessage().contains("Division by zero."));
    }
}