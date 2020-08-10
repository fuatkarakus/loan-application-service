package com.fufu.loan.payload;

import com.fufu.loan.validator.TCKN;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class LoanRequest {

    @TCKN
    @NotEmpty(message = "Please provide a id")
    private String id;

    @NotEmpty(message = "Please provide a name")
    private String name;

    @NotEmpty(message = "Please provide a surname")
    private String surname;

    @NotEmpty(message = "Please provide a salary")
    @Pattern( regexp = "[0-9]+([,.][0-9]{1,2})?",
            message = "Please provide a valid salary")
    private String  monthlySalary;

    @Pattern( regexp = "^\\d{10}$",
            message = "Example phone: 5xxxxxxxxx")
    @NotEmpty(message = "Please provide a phone number")
    private String phoneNumber;

}
