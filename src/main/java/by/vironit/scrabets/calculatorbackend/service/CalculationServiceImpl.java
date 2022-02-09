package by.vironit.scrabets.calculatorbackend.service;

import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;
import by.vironit.scrabets.calculatorbackend.exception.WrongDataException;
import by.vironit.scrabets.calculatorbackend.operation.Calculatable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculationServiceImpl implements CalculationService {

    // Spring injects all the @Component beans in this list.
    private final List<Calculatable> calculators;

    @Override
    public Double calculate(final Double op1, final Double op2, final OperationType opType) {
        return calculators.stream()
                .filter(c -> opType == c.operationType())
                .mapToDouble(c -> c.calculate(op1, op2))
                .findFirst()
                .orElseThrow(() -> new WrongDataException("Incorrect input data - " + op1 + " " + opType.getDescription() + " " + op2));
    }

}