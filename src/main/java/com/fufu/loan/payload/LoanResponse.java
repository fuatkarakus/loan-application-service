package com.fufu.loan.payload;

import com.fufu.loan.enums.LoanStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class LoanResponse {

    private LoanStatus status;

    private BigInteger amount;
}
