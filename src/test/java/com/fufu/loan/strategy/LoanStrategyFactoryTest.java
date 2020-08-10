package com.fufu.loan.strategy;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoanStrategyFactoryTest {

    @Test
    void givenLowScore_shouldReturnLowStrategy() {
        LoanStrategy strategy = LoanStrategyFactory.getStrategy(100, null);
        assertThat(strategy, Matchers.instanceOf(LowScoreStrategy.class));
    }

    @Test
    void givenMediumScoreAndSalary_shouldReturnMediumStrategy() {
        LoanStrategy strategy = LoanStrategyFactory.getStrategy(500, BigInteger.valueOf(4_000));
        assertThat(strategy, Matchers.instanceOf(MediumScoreStrategy.class));
    }

    @Test
    void givenHighScore_shouldReturnHighStrategy() {
        LoanStrategy strategy = LoanStrategyFactory.getStrategy(1001, BigInteger.valueOf(4_000));
        assertThat(strategy, Matchers.instanceOf(HighScoreStrategy.class));
    }

    @Test
    void whenSalaryUnderBarrier_thenReturnTrue() {
       boolean isUnderBarrier =  ReflectionTestUtils
               .invokeMethod(LoanStrategyFactory.class, "isSalaryUnderBarrier", BigInteger.valueOf(4_000));

        assertTrue(isUnderBarrier);

    }

    @Test
    void whenSalaryNotUnderBarrier_thenReturnFalse() {
        boolean isNotUnderBarrier =  ReflectionTestUtils
                .invokeMethod(LoanStrategyFactory.class, "isSalaryUnderBarrier", BigInteger.valueOf(6_000));

        assertFalse(isNotUnderBarrier);

    }
}
