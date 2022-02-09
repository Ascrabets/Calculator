package by.vironit.scrabets.calculatorbackend.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum OperationType {

    ADDITION("+"),
    DIVISION("/"),
    MOD_DIVISION("%"),
    HIGHEST_PRIME("hp"),
    DEFAULT("wrong_type");

    private final String description;

    public static OperationType findBy(final String description) {
        return Arrays.stream(values()).filter(value -> value.getDescription().equals(description)).findFirst().orElse(DEFAULT);
    }
}
