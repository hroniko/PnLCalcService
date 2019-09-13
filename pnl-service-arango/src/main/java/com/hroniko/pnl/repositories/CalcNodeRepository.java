package com.hroniko.pnl.repositories;

import com.arangodb.springframework.repository.ArangoRepository;
import com.hroniko.pnl.entities.nodes.CalcNode;

public interface CalcNodeRepository extends ArangoRepository<CalcNode, String> {
    CalcNode findByName(String name);
}
