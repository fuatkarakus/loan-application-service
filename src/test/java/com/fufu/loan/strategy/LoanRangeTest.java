package com.fufu.loan.strategy;

import com.fufu.loan.constant.LoanRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoanRangeTest {

    @Test
    void givenLowScore_shouldContainLowRange() {
        assertTrue(LoanRange.LOW.contains(499));
    }

    @Test
    void givenMediumScore_shouldContainMediumRange() {
        assertTrue(LoanRange.MEDIUM.contains(500));
    }

    @Test
    void givenHighScore_shouldContainHighRange() {
        assertTrue(LoanRange.HIGH.contains(1000));
    }
}
