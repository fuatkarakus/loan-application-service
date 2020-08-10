package com.fufu.loan.repository;

import com.fufu.loan.domain.LoanApplicantResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicantResultRepository extends MongoRepository<LoanApplicantResult, String> {

}
