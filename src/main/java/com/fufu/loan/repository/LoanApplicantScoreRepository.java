package com.fufu.loan.repository;

import com.fufu.loan.domain.LoanApplicantScore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicantScoreRepository extends MongoRepository<LoanApplicantScore, Long> {

}
