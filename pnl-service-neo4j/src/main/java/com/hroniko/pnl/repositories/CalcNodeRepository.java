package com.hroniko.pnl.repositories;

import com.hroniko.pnl.entities.nodes.CalcNode;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

public interface CalcNodeRepository extends OrientObjectRepository<CalcNode> {
    CalcNode findByName(String name);
}
