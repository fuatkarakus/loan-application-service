package com.fufu.loan.util;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.constant.LoanStatus;
import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.payload.LoanResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoanConverterTest {

    private LoanRequest loanRequest;
    private LoanApplicantResult result;

    @BeforeEach
    void init(){
        loanRequest = LoanRequest.builder()
                .id("40402015646")
                .monthlySalary("5000")
                .name("fuat")
                .surname("karakus")
                .phoneNumber("5312486939")
                .build();

        result = LoanApplicantResult.builder()
                .id("40402015646")
                .status(LoanStatus.APPROVED)
                .amount(BigInteger.valueOf(10_000))
                .build();
    }

    @Test
    void whenValidRequest_thenLoanShouldConvert() {
        LoanApplicant loanApplicant = LoanConverter.convertRequest(loanRequest).build();

        assertEquals("40402015646", loanApplicant.getId());
        assertEquals(BigInteger.valueOf(5000), loanApplicant.getMonthlySalary());
    }

    @Test
    void whenValidResult_thenLoanShouldConvert() {
        LoanResponse response = LoanConverter.convertResult(result).build();

        assertEquals(BigInteger.valueOf(10_000), response.getAmount());
        assertEquals(LoanStatus.APPROVED, response.getStatus());
    }

    @Test
    void whenConvertLoanRequestNull_ShouldNotThrowNPE() throws Exception {
        LoanApplicant actual = LoanConverter.convertRequest(null).build();
        assertNotNull(actual);
    }

    @Test
    void whenConvertLoanResultNull_ShouldNotThrowNPE() throws Exception {
        LoanResponse actual = LoanConverter.convertResult(null).build();
        assertNotNull(actual);
    }

    @Test
    void shouldGetInitialScore() {
        List<LoanApplicantScore> scoreData = Utils.getInitialScoreData();

        LoanApplicantScore score = LoanApplicantScore.builder().id("40402015646").score(600).build();

        assertEquals(score, scoreData.get(0));
    }

}
