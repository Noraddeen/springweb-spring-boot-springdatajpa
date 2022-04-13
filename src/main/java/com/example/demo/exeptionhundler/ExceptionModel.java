package com.example.demo.exeptionhundler;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


public class ExceptionModel {

    String messege;
    HttpStatus httpStatus;
    ZonedDateTime date;

    public ExceptionModel(String messege, HttpStatus httpStatus, ZonedDateTime date) {
        this.messege = messege;
        this.httpStatus = httpStatus;
        this.date = date;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }
}
