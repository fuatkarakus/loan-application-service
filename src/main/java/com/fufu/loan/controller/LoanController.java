package com.fufu.loan.controller;

import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.payload.Response;
import com.fufu.loan.service.LoanApplicantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class LoanController {

    private final LoanApplicantService loanApplicantService;

    public LoanController(LoanApplicantService loanApplicantService) {
        this.loanApplicantService = loanApplicantService;
    }

    @PostMapping("/loan")
    public ResponseEntity<Response> applyForLoan(@Valid @RequestBody LoanRequest request) {
        Response response;
        try{
            response = Response.builder()
                    .success(Boolean.TRUE)
                    .data(loanApplicantService.process(request))
                    .build();

        }catch ( Exception e ) {
            log.error("Exception: {}", e.getCause());
            response = Response.builder()
                    .success(Boolean.FALSE)
                    .message(e.getMessage())
                    .build();

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
