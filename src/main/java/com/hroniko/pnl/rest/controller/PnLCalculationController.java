package com.hroniko.pnl.rest.controller;

import com.hroniko.pnl.entity.results.PnLCalculationNodeResult;
import com.hroniko.pnl.rest.service.CalculationService;
import com.hroniko.pnl.rest.service.PnLCalculationParallelService;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pnl")
public class PnLCalculationController {

    @Autowired
    CalculationService calculationService;

    @Autowired
    PnLCalculationParallelService pnLCalculationParallelService;


//    @RequestMapping(value = {"/calculate/quote"}, method = RequestMethod.GET)
//    public ResponseEntity calculateByQuote(HttpServletRequest request,
//                                                  @RequestBody Quote quote){
//        return new ResponseEntity<>(pnLCalculationService.calculateByQuote(quote), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = {"/calculate/quote/parallel"}, method = RequestMethod.GET)
//    public ResponseEntity calculateByQuoteParallel(HttpServletRequest request,
//                                           @RequestBody Quote quote){
//        return new ResponseEntity<>(pnLCalculationParallelService.calculateByQuote(quote), HttpStatus.OK);
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/calculate/quote/parallel", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<PnLCalculationNodeResult> calculateByQuoteParallel(@RequestBody Quote quote) {
        return calculationService.calculateByQuote(quote);
        return regularService.loadRegular(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .build())
                .log();
    }
}
