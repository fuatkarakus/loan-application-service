package com.fufu.loan.controller;

import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.payload.Response;
import com.fufu.loan.service.UserService;
import lombok.extern.slf4j.Slf4j;
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

    private UserService userService;

    public LoanController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/loan")
    public ResponseEntity<Response> applyForLoan(@Valid @RequestBody LoanRequest requestDto) {
        log.info("");
        return null;
    }

}
