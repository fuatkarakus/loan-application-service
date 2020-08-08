package com.fufu.loan.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { TCKNValidator.class })
public @interface TCKN {
    String message() default "Incorrect id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int length() default 11;
}
