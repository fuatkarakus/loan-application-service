package com.fufu.loan.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TCKNValidator implements ConstraintValidator<TCKN, String> {

    private int length;

    @Override
    public void initialize(TCKN constraintAnnotation) {
        this.length = constraintAnnotation.length();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext context) {

        return id.length() == length;
    }
}
