package com.least_squares.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LSCalculationResponse {
    public Slope slope;
    public Intercept intercept;
    @JsonProperty("standart_error")
    public String standartError;
    @JsonProperty("r_squared")
    public String rSquared;

    public LSCalculationResponse(
            Slope slope,
            Intercept intercept,
            String standartError,
            String rSquared
    ) {
        this.slope = slope;
        this.intercept = intercept;
        this.standartError = standartError;
        this.rSquared = rSquared;
    }
}
