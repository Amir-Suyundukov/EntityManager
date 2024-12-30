package ru.suyundukov.MyProject.others;

import com.fasterxml.jackson.databind.introspect.Annotated;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public interface ConstraintValidator <A extends Annotation, T> {
    void initialize(A constraintAnnotation);
    boolean isValid(T value, ConstraintValidatorContext context);
}
