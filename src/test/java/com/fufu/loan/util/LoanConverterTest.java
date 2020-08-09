package com.fufu.loan.util;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.payload.LoanRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanConverterTest {

    private LoanRequest loanRequest;

    @BeforeEach
    void init(){
        loanRequest = LoanRequest.builder()
                .id("40402015646")
                .monthlySalary("5000")
                .name("fuat")
                .surname("karakus")
                .phoneNumber("5312486939")
                .build();
    }

    @Test
    void whenValidRequest_thenLoanShouldConvert() {
        LoanApplicant loanApplicant = LoanConverter.convert(loanRequest).build();

        assertEquals("40402015646", loanApplicant.getId());
    }

}
