package com.fufu.loan.repository;

import com.fufu.loan.domain.LoanApplicant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class LoanApplicantRepositoryTest {

    @Autowired
    LoanApplicantRepository repository;

    @BeforeEach
    void dataSetup() {
        LoanApplicant applicant = LoanApplicant.builder()
                .id("12312312312")
                .name("fuat")
                .surname("kara")
                .monthlySalary(BigInteger.valueOf(1000))
                .phoneNumber("5312341234").build();

        repository.save(applicant);
    }

    @Test
    void whenFindAll_shouldFindEntity() {
        List<LoanApplicant> applicants = repository.findAll();

        assertThat(applicants).isNotEmpty();
        assertThat(applicants).extracting("id").allMatch(id -> Objects.equals(id, "12312312312"));

    }

}
