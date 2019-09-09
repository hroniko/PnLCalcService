package com.hroniko.pnl.repositories;

import com.hroniko.pnl.entities.nodes.CalcNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CalcNodeRepository extends Neo4jRepository<CalcNode, Long> {
    CalcNode findByName(String name);
}
