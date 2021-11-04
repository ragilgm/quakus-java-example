package validator.constraint;

import validator.NameAreadyExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {NameAreadyExistValidator.class})
@Retention(RUNTIME)
public @interface NameAreadyExist {
    String message() default "User aready exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
