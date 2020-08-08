package com.fufu.loan.payload;

import com.fufu.loan.enums.LoanStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanResponse {

    private LoanStatus status;

    private Long amount;
}
