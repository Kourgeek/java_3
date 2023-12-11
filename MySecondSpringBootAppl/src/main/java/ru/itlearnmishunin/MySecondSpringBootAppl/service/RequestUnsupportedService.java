package ru.itlearnmishunin.MySecondSpringBootAppl.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.itlearnmishunin.MySecondSpringBootAppl.exception.UnsupportedCodeException;


@Service
public class RequestUnsupportedService  implements UnsupportedService{
    @Override
    public void isCode123(BindingResult bindingResult) throws UnsupportedCodeException {
        if (bindingResult.hasErrors()){
            throw new UnsupportedCodeException(bindingResult.getFieldError().toString());
        }
    }
}
