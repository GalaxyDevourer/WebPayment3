package models.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FeeValidator.class)
public @interface Fee {
    String message() default "Please select your fee";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
