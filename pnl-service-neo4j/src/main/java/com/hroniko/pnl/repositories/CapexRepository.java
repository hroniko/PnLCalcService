package com.hroniko.pnl.repositories;

import com.hroniko.pnl.entities.catalog.Capex;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CapexRepository extends Neo4jRepository<Capex, Long> {

    Capex findByName(String name);
}
