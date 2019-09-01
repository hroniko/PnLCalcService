package com.hroniko.pnl.rest.controller;

import com.hroniko.pnl.rest.service.PnLCalculationParallelService;
import com.hroniko.pnl.rest.service.PnLCalculationService;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/pnl")
public class PnLCalculationController {

    @Autowired
    PnLCalculationService pnLCalculationService;

    @Autowired
    PnLCalculationParallelService pnLCalculationParallelService;


    @RequestMapping(value = {"/calculate/quote"}, method = RequestMethod.GET)
    public ResponseEntity calculateByQuote(HttpServletRequest request,
                                                  @RequestBody Quote quote){
        return new ResponseEntity<>(pnLCalculationService.calculateByQuote(quote), HttpStatus.OK);
    }

    @RequestMapping(value = {"/calculate/quote/parallel"}, method = RequestMethod.GET)
    public ResponseEntity calculateByQuoteParallel(HttpServletRequest request,
                                           @RequestBody Quote quote){
        return new ResponseEntity<>(pnLCalculationParallelService.calculateByQuote(quote), HttpStatus.OK);
    }
}
