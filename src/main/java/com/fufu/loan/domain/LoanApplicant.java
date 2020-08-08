package com.fufu.loan.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class LoanApplicant {

    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private String surname;

    private Long monthlySalary;

    private String phoneNumber;

}
