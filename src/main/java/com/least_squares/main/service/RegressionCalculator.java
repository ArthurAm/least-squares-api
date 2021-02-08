package com.least_squares.main.service;

public interface RegressionCalculator {
    Double calculateScope();
    Double calculateIntercept();
    Double calculateSlopeStandartError();
    Double calculateSlopeTValue();
    Double calculateStandartError();
    Double calculateRSquared();
}
