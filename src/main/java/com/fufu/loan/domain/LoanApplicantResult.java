package com.fufu.loan.domain;

import com.fufu.loan.constant.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class LoanApplicantResult {
    private String id;

    private LoanStatus status;

    private BigInteger amount;
}
