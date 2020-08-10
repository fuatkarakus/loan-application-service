package com.fufu.loan.repository;

import com.fufu.loan.domain.LoanApplicantScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class LoanApplicantScoreRepositoryTest {

    @Autowired
    LoanApplicantScoreRepository repository;

    LoanApplicantScore result;

    @BeforeEach
    void setUp() {
        result = LoanApplicantScore.builder()
                .id("12312312312")
                .score(300)
                .build();

    }

    @Test
    void whenGivenEntity_shouldSaveEntity() {
        assertEquals(result, repository.save(result));
    }

}
