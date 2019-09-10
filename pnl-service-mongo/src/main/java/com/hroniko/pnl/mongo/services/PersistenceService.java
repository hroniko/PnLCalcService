package com.hroniko.pnl.mongo.services;

import com.hroniko.pnl.entities.results.PnLCalculationResult;
import com.hroniko.pnl.mongo.entities.PnLCalculationPersistence;
import com.hroniko.pnl.mongo.repositories.CalculationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersistenceService {

    private final CalculationRepository calculationRepository;

    PersistenceService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    /**
     * To create/update calculationPersistence
     * @param calculationPersistence
     * @return saved/updated calculationPersistence
     */
    public Mono<PnLCalculationPersistence> save(PnLCalculationResult calculationPersistence) {
        if (calculationPersistence == null) return Mono.empty();
        if (calculationPersistence instanceof PnLCalculationPersistence){
            return calculationRepository.save((PnLCalculationPersistence)calculationPersistence);
        }
        return calculationRepository.save(new PnLCalculationPersistence(calculationPersistence));

    }

    /**
     * Find a single calculationPersistence by id
     * @param id
     * @return
     */
    public Mono<PnLCalculationPersistence> findOne(String id) {
        return calculationRepository.findById(id);
    }

    /**
     * Find all saved calculationPersistence so fare
     * @return
     */
    public Flux<PnLCalculationPersistence> findAll() {
        return calculationRepository.findAll();
    }

    /**
     * Delete a single calculationPersistence by id
     * @param id
     */
    public Mono<Void> delete(String id) {
        return calculationRepository.deleteById(id);
    }
}
