package ru.itlearnmishunin.MySecondSpringBootAppl.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.itlearnmishunin.MySecondSpringBootAppl.exception.UnsupportedCodeException;


@Service
public interface UnsupportedService {
    void isCode123(BindingResult bindingResult) throws UnsupportedCodeException;

}
