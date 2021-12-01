package com.live.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerAdvice {

    @Value("${app.domain}")
    private String domain;
    @Value("${app.microservice}")
    private String ms;
    @Value("${app.bounded-context}")
    private String bc;

    @ExceptionHandler(MyErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_GATEWAY)
    public ErrorObj handleError(final MyErrorException exceptionParam) {
        return this.generateError()
                   .setMessage("error while calling another ms")
                   .setCause(3800)
                   .add(exceptionParam.getErrorObj());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final IllegalArgumentException exceptionParam) {
        return this.generateError()
                   .setMessage(exceptionParam.getMessage())
                   .setCause(3000);
    }

    private ErrorObj generateError() {
        return new ErrorObj().setDomain(this.domain)
                             .setMicroservice(this.ms)
                             .setBoundedContext(this.bc);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final MethodArgumentNotValidException exceptionParam) {
        ErrorObj root = this.generateError()
                            .setMessage("Validation patladı")
                            .setCause(4000);
        List<ObjectError> allErrorsLoc = exceptionParam.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            root.add(this.generateError()
                         .setMessage(objectErrorLoc.toString())
                         .setCause(3000));
        }
        return root;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final ConstraintViolationException exceptionParam) {
        ErrorObj root = this.generateError()
                            .setMessage("Validation patladı")
                            .setCause(4000);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exceptionParam.getConstraintViolations();
        for (ConstraintViolation<?> objectErrorLoc : constraintViolationsLoc) {
            root.add(this.generateError()
                         .setMessage(objectErrorLoc.toString())
                         .setCause(3000));
        }
        return root;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleError(final Exception exceptionParam) {
        return this.generateError()
                   .setMessage(exceptionParam.getMessage())
                   .setCause(3000);
    }

}
