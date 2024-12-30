package ru.suyundukov.MyProject.dto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Валидация start не позже, чем end
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
@Repeatable(DateRange.List.class)
@Documented
public @interface DateRange {
    String message() default "{start} is after {end}";

    Class<? extends Payload>[] payload() default {};

    String start();
    String end();

    @Target(TYPE)
    @Retention(RUNTIME)
    @Documented
    @interface List{
        DateRange[] value();
    }
}