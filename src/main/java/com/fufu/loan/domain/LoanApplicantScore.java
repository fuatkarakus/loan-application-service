package com.fufu.loan.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class LoanApplicantScore {

    @Id
    private String id;

    private Integer score;
}
