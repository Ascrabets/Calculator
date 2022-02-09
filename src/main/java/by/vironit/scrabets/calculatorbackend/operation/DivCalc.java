package by.vironit.scrabets.calculatorbackend.operation;

import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;
import by.vironit.scrabets.calculatorbackend.exception.WrongDataException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class DivCalc implements Calculatable {

    @Override
    public double calculate(double operand1, double operand2) {
        if (operand2 == 0) throw new WrongDataException("Division by zero.");

        BigDecimal bigDecimalOp1 = new BigDecimal(operand1);
        BigDecimal bigDecimalOp2 = new BigDecimal(operand2);
        BigDecimal result = bigDecimalOp1.divide(bigDecimalOp2, 8, RoundingMode.HALF_UP);

        return result.doubleValue();
    }

    @Override
    public OperationType operationType() {
        return OperationType.DIVISION;
    }
}
