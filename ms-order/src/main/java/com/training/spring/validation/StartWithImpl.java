package com.training.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithImpl implements ConstraintValidator<StartWith, String> {

    private StartWith annoStartWith;

    @Override
    public void initialize(final StartWith annoStartWithParam) {
        this.annoStartWith = annoStartWithParam;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.annoStartWith.value());
    }

}
