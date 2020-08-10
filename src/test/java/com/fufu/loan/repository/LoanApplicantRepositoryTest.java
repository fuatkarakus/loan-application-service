package com.fufu.loan.repository;

import com.fufu.loan.domain.LoanApplicant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class LoanApplicantRepositoryTest {

    @Autowired
    LoanApplicantRepository repository;

    @Test
    void whenGivenEntity_shouldSaveEntity() {
        LoanApplicant applicant = LoanApplicant.builder()
                .id("12312312312")
                .name("fuat")
                .surname("kara")
                .monthlySalary(BigInteger.valueOf(1000))
                .phoneNumber("5312341234").build();

        assertEquals(applicant, repository.save(applicant));
    }

}
