package com.fufu.loan.util;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.payload.LoanRequest;

import java.math.BigInteger;
import java.util.Optional;

public class LoanConverter {

    private LoanConverter() { }

    public static LoanApplicant.LoanApplicantBuilder convert(LoanRequest loan) {
        return Optional.ofNullable(loan).map(d -> LoanApplicant.builder()
                .id(loan.getId())
                .name(loan.getName())
                .surname(loan.getSurname())
                .monthlySalary(new BigInteger(loan.getMonthlySalary()))
                .phoneNumber(loan.getPhoneNumber()))
                .orElseGet(LoanApplicant::builder);
    }

}