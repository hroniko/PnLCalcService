package com.hroniko.pnl.logic;

import com.hroniko.pnl.entities.results.PnLCalculationResult;
import com.hroniko.pnl.entities.tmf.quote.Quote;
import reactor.core.publisher.Mono;

public interface CalculationQuoteLogic {
    Mono<PnLCalculationResult> calculate(Quote quote);
}
