package com.least_squares.main.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = XYSameLengthValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface XYSameLengthConstraint {
    String message() default "X and Y arrays have different length";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
