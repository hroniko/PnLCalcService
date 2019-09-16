package com.hroniko.pnl.repositories;

import com.hroniko.pnl.entities.catalog.Capex;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

public interface CapexRepository extends OrientObjectRepository<Capex> {

    Capex findByName(String name);
}
