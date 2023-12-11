package ru.itlearnmishunin.MySecondSpringBootAppl.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.itlearnmishunin.MySecondSpringBootAppl.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;

}