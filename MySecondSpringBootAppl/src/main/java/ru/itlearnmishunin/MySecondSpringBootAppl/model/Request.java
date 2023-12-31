package ru.itlearnmishunin.MySecondSpringBootAppl.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
        @NotBlank
        String uid;
        @NotBlank
        String operationUid;
        String systemName;
        @NotBlank
        String systemTime;
        String source;
        Integer communicationId;
        Integer templateId;
        Integer productCode;
        Integer smsCode;
}
