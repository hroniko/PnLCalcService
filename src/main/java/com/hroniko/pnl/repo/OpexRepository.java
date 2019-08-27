package com.hroniko.pnl.repo;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import org.springframework.data.repository.CrudRepository;

public interface OpexRepository extends CrudRepository<Opex, Long> {

    Capex findByName(String name);
}
