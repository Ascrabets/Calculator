package by.vironit.scrabets.calculatorbackend.dto;

import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@Validated
public class CalcRequestDto {

    @NotNull
    double operand1;

    @NotNull
    double operand2;

    @NotBlank
    String operation;
}
