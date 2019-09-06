package com.hroniko.pnl.core;

import com.hroniko.pnl.entity.results.PnLCalculationResult;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import reactor.core.publisher.Mono;

public interface CalculationQuoteLogic {
    Mono<PnLCalculationResult> calculate(Quote quote);
}
