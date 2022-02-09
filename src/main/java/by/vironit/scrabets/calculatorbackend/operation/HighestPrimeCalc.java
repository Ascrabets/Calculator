package by.vironit.scrabets.calculatorbackend.operation;

import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;
import by.vironit.scrabets.calculatorbackend.exception.WrongDataException;
import org.springframework.stereotype.Component;

@Component
public class HighestPrimeCalc implements Calculatable {

    @Override
    public double calculate(double operand1, double operand2) {
        int intOp1 = (int) operand1;
        int intOp2 = (int) operand2;
        int result = calculateHighestPrime(Math.max(intOp1, intOp2), Math.min(intOp1, intOp2));
        if (result <= 1) throw new WrongDataException("Prime should be natural number > 1.");
        return result;
    }

    private int calculateHighestPrime(int high, int low) {
        int prime = 1;
        for (int i = high; i >= low; i -= 1) {
            if (isPrime(i)) {
                prime = i;
                break;
            }
        }
        return prime;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i += 1) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public OperationType operationType() {
        return OperationType.HIGHEST_PRIME;
    }
}
