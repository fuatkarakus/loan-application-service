package com.fufu.loan.utils;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.payload.LoanRequest;

import java.util.Optional;

public class LoanConverter {

    private LoanConverter() { }

    public static LoanApplicant.LoanApplicantBuilder convert(LoanRequest loan) {
        return Optional.ofNullable(loan).map(d -> LoanApplicant.builder()
                .id(loan.getId())
                .name(loan.getName())
                .surname(loan.getSurname())
                .monthlySalary(Long.parseLong(loan.getMonthlySalary()))
                .phoneNumber(loan.getPhoneNumber()))
                .orElseGet(LoanApplicant::builder);
    }

}
