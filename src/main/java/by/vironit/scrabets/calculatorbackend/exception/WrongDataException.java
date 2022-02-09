package by.vironit.scrabets.calculatorbackend.exception;

public class WrongDataException extends RuntimeException {

    public WrongDataException() {
        super();
    }

    public WrongDataException(String message) {
        super(message);
    }

    public WrongDataException(String message, Exception thrownException) {
        super(message, thrownException);
    }
}