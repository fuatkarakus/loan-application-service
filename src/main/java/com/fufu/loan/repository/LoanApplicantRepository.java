package com.fufu.loan.repository;

import com.fufu.loan.domain.LoanApplicant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicantRepository extends MongoRepository<LoanApplicant, Long> {

}
