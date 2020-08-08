package com.fufu.loan.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private String message;
    private Boolean success;
    private LoanResponse data;

}
