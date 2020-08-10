package com.fufu.loan.repository;

import com.fufu.loan.domain.LoanApplicantScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
public class LoanApplicantScoreRepositoryTest {

    @Autowired
    LoanApplicantScoreRepository repository;

    LoanApplicantScore result;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        result = LoanApplicantScore.builder()
                .id("12312312312")
                .score(300)
                .build();
        mongoTemplate.save(result, "LoanApplicantScore");
    }

    @Test
    void shouldFindResult() {
        Optional<LoanApplicantScore> optional = repository.findById("12312312312");
        assertTrue(optional.isPresent());
        assertEquals(optional.get().getScore(), 300);
    }

    @Test
    void whenGivenEntity_shouldSaveEntity() {
        assertEquals(result, repository.save(result));
    }

}
