package com.hroniko.pnl.repositories;

import com.hroniko.pnl.entities.catalog.Opex;
import org.springframework.data.neo4j.repository.Neo4jRepository;
public interface OpexRepository extends Neo4jRepository<Opex, Long> {

    Opex findByName(String name);
}
