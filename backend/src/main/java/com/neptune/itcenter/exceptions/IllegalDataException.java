package com.neptune.itcenter.exceptions;

import javax.ejb.ApplicationException;

/**
 * Created by vunguyenhung on 7/14/17.
 */
@ApplicationException
public class IllegalDataException extends RuntimeException {
    public IllegalDataException(String message) {
        super(message);
    }
}
