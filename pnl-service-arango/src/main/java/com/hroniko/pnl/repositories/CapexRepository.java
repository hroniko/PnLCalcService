package com.hroniko.pnl.repositories;

import com.arangodb.springframework.repository.ArangoRepository;
import com.hroniko.pnl.entities.catalog.Capex;

public interface CapexRepository extends ArangoRepository<Capex, String> {

    Capex findByName(String name);
}
