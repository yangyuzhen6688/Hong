package org.example.hong.exception;

import org.example.hong.common.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<?> ex(Exception e) {
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> valid(MethodArgumentNotValidException e) {
        return Result.error(400, e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
