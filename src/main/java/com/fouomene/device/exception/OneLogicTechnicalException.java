package com.fouomene.device.exception;


import org.zalando.problem.spring.common.HttpStatusAdapter;

/**
 * The Class OneLogicTechnicalException.
 */
public class OneLogicTechnicalException extends RuntimeException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private final String message;

    private final HttpStatusAdapter httpStatus;


    /**
     * @param message
     * @param httpStatus
     */
    public OneLogicTechnicalException( String message, HttpStatusAdapter httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * @return the httpStatus
     */
    public HttpStatusAdapter getHttpStatus() {
        return httpStatus;
    }


    @Override
    public String getMessage() {
        return message;
    }


}
