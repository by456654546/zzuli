package com.zzuli.exception;

public class ZzuliException extends RuntimeException{
    private String errMessage;

    public ZzuliException() {
        super();
    }

    public ZzuliException(String message) {
        super(message);
        this.errMessage = message;
    }

    public String getErrMessage(){
        return errMessage;
    }

    public static void cast(String errMessage){
        throw new ZzuliException(errMessage);
    }
}
