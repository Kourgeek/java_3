package ru.itlearnmishunin.MySecondSpringBootAppl.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    String uid;
    String operationUid;
    String systemTime;
    String code;
    String errorCode;
    String errorMessage;

}
