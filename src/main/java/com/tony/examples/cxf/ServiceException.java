package com.tony.examples.cxf;

/**
 * Service Exception
 */
public class ServiceException extends RuntimeException {

    private String code;
    private String locator;
    private String message;

    public ServiceException(String code, String locator, String message) {
        super(message);
        this.code = code;
        this.locator = locator;
        this.message = message;
    }

    public ServiceException(String code, String locator, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.locator = locator;
        this.message = message;
    }

    public ServiceException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

    public ServiceException(ERROR error) {
        super(error.value());
        this.code = error.code();
        this.message = error.value();
    }

    public ServiceException(ERROR error, Throwable cause) {
        super(error.value(), cause);
        this.code = error.code();
        this.message = error.value();
    }

    public String getCode() {
        return code;
    }

    public String getLocator() {
        return locator;
    }

    public String getMessage() {
        return message;
    }
}