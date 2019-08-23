package com.hroniko.pnl.repo;

import com.hroniko.pnl.entity.CalcNode;
import org.springframework.data.repository.CrudRepository;

public interface CalcNodeRepository extends CrudRepository<CalcNode, Long> {

    CalcNode findByName(String name);
}
