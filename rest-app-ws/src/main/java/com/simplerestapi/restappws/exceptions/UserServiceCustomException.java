package com.simplerestapi.restappws.exceptions;

public class UserServiceCustomException extends RuntimeException{

    private static final long serialVersionUID = -7579598754614658878L;

    public UserServiceCustomException(String message){
        super(message);
    }

}
