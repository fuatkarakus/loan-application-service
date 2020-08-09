package com.fufu.loan.util;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.payload.LoanResponse;

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

    public static LoanResponse.LoanResponseBuilder convert(LoanApplicantResult loan) {
        return Optional.ofNullable(loan).map(d -> LoanResponse.builder()
                .amount(loan.getAmount())
                .status(loan.getStatus()))
                .orElseGet(LoanResponse::builder);
    }

}
