package com.neptune.itcenter.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException
public class IllegalDataException extends RuntimeException {
    public IllegalDataException(String message) {
        super(message);
    }
}
