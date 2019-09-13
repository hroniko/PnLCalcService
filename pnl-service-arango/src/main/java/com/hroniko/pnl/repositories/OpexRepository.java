package com.hroniko.pnl.repositories;

import com.arangodb.springframework.repository.ArangoRepository;
import com.hroniko.pnl.entities.catalog.Opex;

public interface OpexRepository extends ArangoRepository<Opex, String> {

    Opex findByName(String name);
}
