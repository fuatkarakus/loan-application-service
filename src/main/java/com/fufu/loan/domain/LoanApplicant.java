package com.fufu.loan.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document
public class LoanApplicant {

    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private String surname;

    private BigInteger monthlySalary;

    private String phoneNumber;

}
