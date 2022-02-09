package by.vironit.scrabets.calculatorbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandlerGlobal(final Exception e) {
        log.error("Exception occurred: {}.", e.getClass().getName());
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({WrongDataException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptionHandlerWrongData(final WrongDataException e) {
        log.error("Exception occurred: {}.", e.getClass().getName());
        return e.getMessage();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException e,
                                                                  final HttpHeaders headers,
                                                                  final HttpStatus status,
                                                                  final WebRequest request) {
        log.info("Validation exception occurred: {}.", e.getClass().getName());
        List<String> errors = new ArrayList<>();
        for (final FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : e.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, e.getLocalizedMessage(), errors);
        return handleExceptionInternal(e, apiError, headers, apiError.getStatus(), request);
    }
}