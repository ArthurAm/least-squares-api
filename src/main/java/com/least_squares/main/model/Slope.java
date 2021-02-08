package com.least_squares.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Slope {
    public String coefficient;
    @JsonProperty("standart_error")
    public String standartError;

    @JsonProperty("t_value")
    public String tValue;

    public Slope(String coefficient, String standartError, String tValue) {
        this.coefficient = coefficient;
        this.standartError = standartError;
        this.tValue = tValue;
    }
}
