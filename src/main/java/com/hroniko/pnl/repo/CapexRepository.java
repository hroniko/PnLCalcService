package com.hroniko.pnl.repo;

import com.hroniko.pnl.entity.catalog.Capex;
import org.springframework.data.repository.CrudRepository;

public interface CapexRepository extends CrudRepository<Capex, Long> {

    Capex findByName(String name);
}
