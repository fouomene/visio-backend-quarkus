package com.fouomene.device.exception;

import org.zalando.problem.Status;

import java.util.Arrays;
import java.util.List;

/**
 * The Class OneLogicTechnicalException.
 */
public class OneLogicBusinessException extends Exception {

    private static final long serialVersionUID = 1L;
    private final Status httpStatus;
    private List<String> messages;


    public OneLogicBusinessException(ErrorInfo errorInfo, String... messages) {
        super(errorInfo.getMessage());
        this.httpStatus = errorInfo.getHttpStatus();
        this.messages = Arrays.asList(messages);
    }

    /**
     * @param msg
     * @param httpStatus
     */
    public OneLogicBusinessException(String msg, Status httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    /**
     * @param cause
     * @param httpStatus
     */
    public OneLogicBusinessException(Throwable cause, Status httpStatus) {
        super(cause);
        this.httpStatus = httpStatus;
    }

    /**
     * @return the httpStatus
     */
    public Status getHttpStatus() {
        return httpStatus;
    }


}
