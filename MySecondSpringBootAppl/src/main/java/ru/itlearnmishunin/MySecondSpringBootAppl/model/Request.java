package ru.itlearnmishunin.MySecondSpringBootAppl.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
        String uid;
        String operationUid;
        String systemName;
        String systemTime;
        String source;
        Integer communicationId;
        Integer templateId;
        Integer productCode;
        Integer smsCode;
}
