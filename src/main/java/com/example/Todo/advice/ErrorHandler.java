package com.example.Todo.advice;

import com.example.Todo.exceptions.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ErrorHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TodoNotFoundException.class)
    public HashMap<String,Object> handleError(TodoNotFoundException todoNotFoundException)
    {
        String message=todoNotFoundException.getMessage();
        HashMap<String,Object>res=new HashMap<>();
        res.put("message",message);
        return res;
    }
}
