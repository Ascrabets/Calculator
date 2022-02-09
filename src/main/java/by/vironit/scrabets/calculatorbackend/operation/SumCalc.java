package by.vironit.scrabets.calculatorbackend.operation;

import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SumCalc implements Calculatable {

    @Override
    public double calculate(final double operand1, final double operand2) {
        BigDecimal bigDecimalOp1 = new BigDecimal(operand1);
        BigDecimal bigDecimalOp2 = new BigDecimal(operand2);
        BigDecimal result = bigDecimalOp1.add(bigDecimalOp2);
        return result.doubleValue();
    }

    @Override
    public OperationType operationType() {
        return OperationType.ADDITION;
    }
}
