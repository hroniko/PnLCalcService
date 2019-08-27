package com.hroniko.pnl.rest.controller;

import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.rest.service.PnLCalculationService;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/pnl")
public class PnLCalculationController {

    @Autowired
    PnLCalculationService pnLCalculationService;

    @RequestMapping(value = {"/hop"}, method = RequestMethod.GET)
    public ResponseEntity<Object> updateCustomerFields(HttpServletRequest request) {
        List<CalcNode> finalCalcNodes = pnLCalculationService.getFinalCalcNodes();
        return new ResponseEntity(finalCalcNodes, HttpStatus.OK);

    }

    @RequestMapping(value = {"/calculate/quote"}, method = RequestMethod.GET)
    public ResponseEntity calculateByQuote(HttpServletRequest request,
                                                  @RequestBody Quote quote){
        return new ResponseEntity<>(pnLCalculationService.calculateByQuote(quote), HttpStatus.OK);
    }
}
