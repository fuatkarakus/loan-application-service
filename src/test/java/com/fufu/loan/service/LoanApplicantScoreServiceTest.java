package com.fufu.loan.service;

import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.repository.LoanApplicantScoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LoanApplicantScoreServiceTest {
    private static final String ID = "12345678901";

    @InjectMocks
    private LoanApplicantScoreService scoreService;

    @Mock
    private LoanApplicantScoreRepository scoreRepository;

    @BeforeEach
    public void setup() {
        LoanApplicantScore score = new LoanApplicantScore(ID, 100);
        Mockito.when(scoreRepository.findById(ID))
                .thenReturn(Optional.of(score));
    }
    @Test
    void whenValidId_thenScoreShouldBeFound() {
        String id = "12345678901";

        LoanApplicantScore found = scoreService.findApplicantScoreById(id);

        assertEquals(id, found.getId());
    }

}
