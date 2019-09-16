package com.hroniko.pnl.repositories;

import com.hroniko.pnl.entities.catalog.Opex;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

public interface OpexRepository extends OrientObjectRepository<Opex> {

    Opex findByName(String name);
}
