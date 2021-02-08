package com.least_squares.main.controller;

import com.least_squares.main.model.Intercept;
import com.least_squares.main.model.LSCalculationRequest;
import com.least_squares.main.model.LSCalculationResponse;
import com.least_squares.main.model.Slope;
import com.least_squares.main.service.LSCalculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class LSCalculatorController {
    private final LSCalculator lsCalculatorService;

    public LSCalculatorController(LSCalculator lsCalculatorService) {
        this.lsCalculatorService = lsCalculatorService;
    }

    @PostMapping(value = "/calculate_ls", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public LSCalculationResponse getLSData(@Valid @RequestBody LSCalculationRequest lsCalculationRequest) {
        lsCalculatorService.clear();
        for (int i = 0; i < lsCalculationRequest.x.length; i++) {
            lsCalculatorService.addData(
                    Double.parseDouble(lsCalculationRequest.x[i]),
                    Double.parseDouble(lsCalculationRequest.y[i])
            );
        }

        return new LSCalculationResponse(
                new Slope(lsCalculatorService.calculateScope().toString(),
                        lsCalculatorService.calculateSlopeStandartError().toString(),
                        lsCalculatorService.calculateSlopeTValue().toString()
                ),
                new Intercept(lsCalculatorService.calculateIntercept().toString()),
                lsCalculatorService.calculateStandartError().toString(),
                lsCalculatorService.calculateRSquared().toString()
        );
    }
}
