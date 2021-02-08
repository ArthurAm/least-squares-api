package com.least_squares.main.model.validator;

import com.least_squares.main.model.LSCalculationRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class XYSameLengthValidator implements
        ConstraintValidator<XYSameLengthConstraint, LSCalculationRequest> {
    @Override
    public void initialize(XYSameLengthConstraint xySameLengthConstraint) {
    }

    @Override
    public boolean isValid(LSCalculationRequest lsCalculationRequest,
                           ConstraintValidatorContext cxt) {
        return lsCalculationRequest.x.length == lsCalculationRequest.y.length;
    }
}
