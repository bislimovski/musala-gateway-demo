package com.musala.demo.helpers;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class ResponseHelper<T> {

    private HttpStatus status;
    private List<T> data;
    private String message;
    private Boolean error;

    public ResponseHelper(HttpStatus status, String message, Boolean error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public ResponseHelper(HttpStatus status, List<T> data) {
        this.status = status;
        this.data = data;
    }

    public ResponseHelper(HttpStatus status, T data) {
        this.status = status;
        this.data = Collections.singletonList(data);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
