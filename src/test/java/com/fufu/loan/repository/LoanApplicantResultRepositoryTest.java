package com.fufu.loan.repository;

import com.fufu.loan.constant.LoanConstant;
import com.fufu.loan.constant.LoanStatus;
import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class LoanApplicantResultRepositoryTest {

    @Autowired
    LoanApplicantResultRepository repository;

    @Test
    void whenGivenEntity_shouldSaveEntity() {
        LoanApplicantResult result = LoanApplicantResult.builder()
        .id("12312312312")
        .status(LoanStatus.APPROVED)
        .amount(LoanConstant.MIN_LOAN_AMOUNT)
        .build();

        assertEquals(result, repository.save(result));
    }


}
