package com.hroniko.pnl.rest.service;

import com.hroniko.pnl.entity.results.PnLCalculationNodeResult;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import reactor.core.publisher.Flux;

public interface CalculationService {
    Flux<PnLCalculationNodeResult> calculateByQuote(Quote quote);
}
