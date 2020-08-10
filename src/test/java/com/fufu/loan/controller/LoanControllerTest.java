package com.fufu.loan.controller;

import com.fufu.loan.advice.LoanExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class LoanControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private LoanController loanController;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(loanController)
                .setControllerAdvice(new LoanExceptionHandler())
                .build();
    }
}
