package com.hroniko.pnl.rest.controller;


import com.hroniko.pnl.entities.results.PnLCalculationNodeResult;
import com.hroniko.pnl.entities.results.PnLCalculationResult;
import com.hroniko.pnl.logic.ParallelCalculationQuoteLogic;
import com.hroniko.pnl.logic.SerialCalculationQuoteLogic;
import com.hroniko.pnl.mongo.services.PersistenceService;
import com.hroniko.pnl.services.CalculationService;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @Autowired
    PersistenceService persistenceService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/calculate/quote", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<PnLCalculationNodeResult> calculateByQuote(@RequestBody Quote quote) {
        Mono<PnLCalculationResult> calculationResult = calculationService
                .setCalculationQuoteLogic(serialCalculationQuoteLogic)
                .calculateByQuote(quote)
                .flatMap(calc -> Mono.defer(() -> persistenceService.save(calc)));

        //calculationResult.subscribe(persistenceService::save);

        return calculationResult.map(PnLCalculationResult::getNodes).flatMapMany(Flux::fromIterable);
//                .flatMap(calc -> Mono.defer(() -> persistenceService.save(calc)));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/calculate/quote/parallel", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<PnLCalculationNodeResult> calculateByQuoteParallel(@RequestBody Quote quote) {
        Mono<PnLCalculationResult> calculationResult = calculationService
                .setCalculationQuoteLogic(parallelCalculationQuoteLogic)
                .calculateByQuote(quote)
                .flatMap(calc -> Mono.defer(() -> persistenceService.save(calc)));

//        calculationResult.subscribe(persistenceService::save);

        return calculationResult.map(PnLCalculationResult::getNodes).flatMapMany(Flux::fromIterable);
//                .flatMap(calc -> Mono.defer(() -> persistenceService.save(calc)));
    }
}
