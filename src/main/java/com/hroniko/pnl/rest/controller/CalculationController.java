package com.hroniko.pnl.rest.controller;

import com.hroniko.pnl.core.ParallelCalculationQuoteLogic;
import com.hroniko.pnl.core.SerialCalculationQuoteLogic;
import com.hroniko.pnl.entity.results.PnLCalculationResult;
import com.hroniko.pnl.rest.service.CalculationService;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pnl")
public class CalculationController {

    @Autowired
    CalculationService calculationService;

    @Autowired
    SerialCalculationQuoteLogic serialCalculationQuoteLogic;

    @Autowired
    ParallelCalculationQuoteLogic parallelCalculationQuoteLogic;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/calculate/quote", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<PnLCalculationResult> calculateByQuote(@RequestBody Quote quote) {
        return calculationService
                .setCalculationQuoteLogic(serialCalculationQuoteLogic)
                .calculateByQuote(quote);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/calculate/quote/parallel", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<PnLCalculationResult> calculateByQuoteParallel(@RequestBody Quote quote) {
        return calculationService
                .setCalculationQuoteLogic(parallelCalculationQuoteLogic)
                .calculateByQuote(quote);
    }
}
