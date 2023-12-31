package ru.itlearnmishunin.MySecondSpringBootAppl.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itlearnmishunin.MySecondSpringBootAppl.exception.UnsupportedCodeException;
import ru.itlearnmishunin.MySecondSpringBootAppl.exception.ValidationFailedException;
import ru.itlearnmishunin.MySecondSpringBootAppl.model.Request;
import ru.itlearnmishunin.MySecondSpringBootAppl.model.Response;
import ru.itlearnmishunin.MySecondSpringBootAppl.service.UnsupportedService;
import ru.itlearnmishunin.MySecondSpringBootAppl.service.ValidationService;

import java.text.SimpleDateFormat;

@RestController
public class MyController {
    private final ValidationService validationService;
    private final UnsupportedService unsupportedService;

    @Autowired
    public MyController(ValidationService validationService, UnsupportedService unsupportedService){
        this.validationService = validationService;
        this.unsupportedService = unsupportedService;
    }
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback (@Valid @RequestBody Request request, BindingResult bindingResult) throws ValidationFailedException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy--MM--dd'T'HH:mm:ss.SSS'Z'");
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        try {
            validationService.isValid(bindingResult);
            unsupportedService.isCode123(bindingResult);
            System.out.print(request.getUid());
            if ("123".equals(request.getUid())){
                throw new UnsupportedCodeException("Ooops.. Code '123' is reserved");
            }

        } catch (UnsupportedCodeException e){
            response.setCode("failed");
            response.setErrorCode("UnsupportedCodeException");
            response.setErrorMessage("Ошибка кодирования" + e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        catch (ValidationFailedException e){
            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("Ошибка Валидации");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode("failed");
            response.setErrorCode("Uncknown Exception");
            response.setErrorMessage("Неизвестная ошибка");
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }



        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
