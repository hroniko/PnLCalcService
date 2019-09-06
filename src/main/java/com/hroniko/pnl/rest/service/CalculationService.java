package com.hroniko.pnl.rest.service;

import com.hroniko.pnl.core.CalculationQuoteLogic;
import com.hroniko.pnl.entity.results.PnLCalculationResult;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
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
