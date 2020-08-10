package com.fufu.loan.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Payload;
import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TCKNValidatorTest {

    private TCKNValidator validator;

    @BeforeEach
    void setUp() {
        validator = new TCKNValidator();
        validator.initialize(createAnnotation(11));
    }

    @Test
    void isValid_shouldReturnTrue_whenTcExactLength() {
        assertTrue(isValid("11111111111"));
    }

    @Test
    void isValid_shouldReturnFalse_whenInvalidTc() {
        assertFalse(isValid("123456789012"));
        assertFalse(isValid("123456789012 "));
        assertFalse(isValid("123234foo"));
        assertFalse(isValid("foo"));
    }

    private boolean isValid(String value) {
        return validator.isValid(value, null);
    }

    private TCKN createAnnotation(int length) {
        return new TCKN() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String message() {
                return "Please provide a valid id";
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }

            @Override
            public int length() {
                return length;
            }
        };
    }
}
