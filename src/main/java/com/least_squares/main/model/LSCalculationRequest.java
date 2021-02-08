package com.least_squares.main.model;

import com.least_squares.main.model.validator.XYSameLengthConstraint;
import javax.validation.constraints.NotNull;

@XYSameLengthConstraint
public class LSCalculationRequest {
    @NotNull
    public String[] x;
    @NotNull
    public String[] y;
}
