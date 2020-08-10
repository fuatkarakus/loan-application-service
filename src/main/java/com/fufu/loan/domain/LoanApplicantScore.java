package com.fufu.loan.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class LoanApplicantScore {

    @Id
    private String id;

    private Integer score;
}
