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

//        char[] chars = id.toCharArray();
//        int[] a = new int[length];
//
//        for(int i=0; i<length; i++) {
//            a[i] = chars[i] - '0';
//        }
//
//        if(a[0] == 0) return false;
//        if(a[10] % 2 == 1) return false;
//
//        if(((a[0] + a[2] + a[4] + a[6] + a[8]) * 7 - (a[1] + a[3] + a[5] + a[7])) % 10 != a[9]) return false;
//
//        if((a[0] + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] + a[7] + a[8] + a[9]) % 10 != a[10]) return false;

    }
}
