package by.vironit.scrabets.calculatorbackend.controller;

import by.vironit.scrabets.calculatorbackend.dto.CalcRequestDto;
import by.vironit.scrabets.calculatorbackend.enumeration.OperationType;
import by.vironit.scrabets.calculatorbackend.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CalculationController {

    private final CalculationService calcService;

    @PostMapping("/calculate")
    public Double calculate(@RequestBody @Valid CalcRequestDto dto) {
        OperationType operationType = OperationType.findBy(dto.getOperation());
        return calcService.calculate(dto.getOperand1(), dto.getOperand2(), operationType);
    }
}