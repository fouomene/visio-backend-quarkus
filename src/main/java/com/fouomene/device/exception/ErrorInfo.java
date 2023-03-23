package com.fouomene.device.exception;

import lombok.Getter;
import org.zalando.problem.Status;

@Getter
public enum ErrorInfo {

    CODE_DEVICE_REQUIRED("#CODE_DEVICE_REQUIRED", Status.BAD_REQUEST),
    IP_DEVICE_REQUIRED("#IP_DEVICE_REQUIRED", Status.BAD_REQUEST),
    DEVICE_NOT_FOUND("#DEVICE_NOT_FOUND", Status.NOT_FOUND),
    IP_DEVICE_ALREADY_USED("#IP_DEVICE_ALREADY_USED", Status.BAD_REQUEST),
    NAME_DEVICE_REQUIRED("#NAME_DEVICE_REQUIRED", Status.BAD_REQUEST),
    NAME_DEVICE_ALREADY_USED("#NAME_DEVICE_ALREADY_USED", Status.BAD_REQUEST),
    NAME_ADDRESS_DEVICE_ALREADY_USED("#NAME_ADDRESS_DEVICE_ALREADY_USED", Status.BAD_REQUEST);


    private final String message;
    private final Status httpStatus;

    ErrorInfo(String message, Status httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
