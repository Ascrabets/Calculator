package by.vironit.scrabets.calculatorbackend.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class SumCalcTest {

    private SumCalc sumCalc;

    @BeforeEach
    public void setUp() {
        sumCalc = new SumCalc();
    }

    @Test
    void whenCalculateWithCorrectOperands_thenResultIsOk() {
        // given
        double op1 = 5d;
        double op2 = 10d;
        double expectedResult = 15d;

        // when
        double actualResult = sumCalc.calculate(op1, op2);

        // then
        then(actualResult).isEqualTo(expectedResult);
    }
}