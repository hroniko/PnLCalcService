package com.hroniko.pnl.mongo.repositories;

import com.hroniko.pnl.entities.results.PnLCalculationResult;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends ReactiveMongoRepository<PnLCalculationResult, String> {
}
