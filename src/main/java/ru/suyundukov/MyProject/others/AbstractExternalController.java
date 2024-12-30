package ru.suyundukov.MyProject.others;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public abstract class AbstractExternalController {
    protected void checkErrorsAndThrow(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorsMessage = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .reduce((message1, message2) -> message1 + "\n" + message2)
                    .orElse("Unknown validation error");
            throw new IllegalArgumentException(errorsMessage);
        }
    }
}
