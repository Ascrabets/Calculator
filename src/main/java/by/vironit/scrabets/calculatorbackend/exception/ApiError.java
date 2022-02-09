package by.vironit.scrabets.calculatorbackend.exception;

import lombok.Value;
import org.springframework.http.HttpStatus;

import java.util.List;

@Value
public class ApiError {

    HttpStatus status;

    String message;

    List<String> errors;
}