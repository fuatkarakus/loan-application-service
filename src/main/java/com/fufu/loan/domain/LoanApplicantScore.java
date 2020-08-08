package com.fufu.loan.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class LoanApplicantScore {

    @Id
    private String id;

    private Long score;
}
