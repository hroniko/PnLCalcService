package com.hroniko.pnl.repositories;

import com.arangodb.springframework.repository.ArangoRepository;
import com.hroniko.pnl.entities.nodes.ChildOf;

public interface ChildOfRepository extends ArangoRepository<ChildOf, String> {
}
