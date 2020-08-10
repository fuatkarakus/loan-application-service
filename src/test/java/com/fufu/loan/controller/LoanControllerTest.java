package com.fufu.loan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fufu.loan.advice.LoanExceptionHandler;
import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.service.LoanApplicantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class LoanControllerTest {

    private static final String API = "/api/loan";

    MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    LoanController loanController;

    @MockBean
    LoanApplicantService loanApplicantService;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(loanController)
                .setControllerAdvice(new LoanExceptionHandler())
                .build();
    }

    @Test
    void whenRequestLoan_thenReturn200() throws Exception {
        LoanRequest request = LoanRequest.builder()
                .id("12312312312")
                .name("fuat")
                .surname("kara")
                .monthlySalary("1000")
                .phoneNumber("5312341234").build();

        performRequest(request, status().isOk());
    }

    @Test
    void whenInvalidRequestLoan_thenReturn400() throws Exception {
        LoanRequest request = LoanRequest.builder()
                .id("123123123123")
                .name("fuat")
                .surname("kara")
                .monthlySalary("1000")
                .phoneNumber("5312341234").build();

        performRequest(request, status().isBadRequest());
    }

    @Test
    void whenNullRequestLoan_thenReturn400() throws Exception {
        mockMvc.perform(post(API))
                .andExpect(status().isBadRequest());
    }

    private ResultActions performRequest(Object request, ResultMatcher matcher) throws Exception {
        return performRequest(request, post(API), matcher);
    }

    private ResultActions performRequest(Object request, MockHttpServletRequestBuilder builder, ResultMatcher matcher) throws Exception {
        return mockMvc.perform(
                builder
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(matcher);
    }
}
