package ru.suyundukov.MyProject.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    private String startField;
    private String endField;

    @Override
    public void initialize(DateRange constraintAnnotation) {
        this.startField = constraintAnnotation.start();
        this.endField = constraintAnnotation.end();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            var startFieldValue = value.getClass().getDeclaredField(startField);
            var endFieldValue = value.getClass().getDeclaredField(endField);

            startFieldValue.setAccessible(true);
            endFieldValue.setAccessible(true);

            Object startValue = startFieldValue.get(value);
            Object endValue = endFieldValue.get(value);

            if (startValue == null || endValue == null) {
                return true;
            }

            if (startValue instanceof Comparable && endValue instanceof Comparable) {
                @SuppressWarnings("unchecked")
                Comparable<Object> startComparable = (Comparable<Object>) startValue;
                return startComparable.compareTo(endValue) <= 0; // Проверка диапазона
            }

            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
