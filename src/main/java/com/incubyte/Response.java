package com.incubyte;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {
    private T data;
    private Status status;
    private String message;
    private StackTraceElement error;

    @JsonCreator
    public Response(@JsonProperty("data") T data , @JsonProperty("status") Status status, @JsonProperty("message") String message, @JsonProperty("error") StackTraceElement error) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public StackTraceElement getError() {
        return error;
    }

    enum Status {
        SUCCESS("Success"), FAILED("Failed");

        private final String status;

        Status(String status) {
            this.status = status;
        }

        String getStatus() {
            return status;
        }
    }
}