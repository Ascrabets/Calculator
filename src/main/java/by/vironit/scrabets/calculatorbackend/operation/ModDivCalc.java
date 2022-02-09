package by.vironit.scrabets.calculatorbackend.operation;

import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;
import by.vironit.scrabets.calculatorbackend.exception.WrongDataException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ModDivCalc implements Calculatable {

    @Override
    public double calculate(double operand1, double operand2) {
        if (operand2 == 0) throw new WrongDataException("Division by zero.");

        BigDecimal bigDecimalOp1 = new BigDecimal(operand1);
        BigDecimal bigDecimalOp2 = new BigDecimal(operand2);
        BigDecimal result = bigDecimalOp1.remainder(bigDecimalOp2);

        return result.doubleValue();
    }

    @Override
    public OperationType operationType() {
        return OperationType.MOD_DIVISION;
    }
}
