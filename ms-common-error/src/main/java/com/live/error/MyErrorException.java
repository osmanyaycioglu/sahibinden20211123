package com.live.error;

public class MyErrorException extends Exception {

    private static final long serialVersionUID = -316259388111307521L;

    private ErrorObj          errorObj;


    public MyErrorException() {
    }

    public MyErrorException(final ErrorObj errorObjParam) {
        super();
        this.errorObj = errorObjParam;
    }

    public ErrorObj getErrorObj() {
        return this.errorObj;
    }

    public void setErrorObj(final ErrorObj errorObjParam) {
        this.errorObj = errorObjParam;
    }


}
