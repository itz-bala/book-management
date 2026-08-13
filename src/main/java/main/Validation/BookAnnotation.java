package main.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy=BookValidation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface BookAnnotation {
    String message() default "{invalid book details}";
    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};
}
