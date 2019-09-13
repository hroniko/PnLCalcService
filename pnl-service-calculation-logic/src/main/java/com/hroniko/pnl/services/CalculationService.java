package com.hroniko.pnl.services;

import com.hroniko.pnl.entities.results.PnLCalculationResult;
import com.hroniko.pnl.entities.tmf.quote.Quote;
import com.hroniko.pnl.logic.CalculationQuoteLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationService {

    private CalculationQuoteLogic calculationQuoteLogic;

    public CalculationService(CalculationQuoteLogic calculationQuoteLogic) {
        this.calculationQuoteLogic = calculationQuoteLogic;
    }

    public CalculationQuoteLogic getCalculationQuoteLogic() {
        return calculationQuoteLogic;
    }

    public CalculationService setCalculationQuoteLogic(CalculationQuoteLogic calculationQuoteLogic) {
        this.calculationQuoteLogic = calculationQuoteLogic;
        return this;
    }

    public Mono<PnLCalculationResult> calculateByQuote(Quote quote){
        return calculationQuoteLogic.calculate(quote);
    }

}
