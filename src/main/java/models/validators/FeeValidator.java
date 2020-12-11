package models.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FeeValidator implements ConstraintValidator<Fee, Integer> {
    @Override
    public void initialize(Fee constraintAnnotation) { }

    @Override
    public boolean isValid(Integer data, ConstraintValidatorContext constraintValidatorContext) {
        return data > 10;
    }
}
