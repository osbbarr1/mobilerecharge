/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oabmobile.bussines.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author oabaquero
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {

    private T data;
    private String message;
    private Integer code;

    /**
     * Contructor 1 : message and data response
     *
     * @param data    Information or main object
     * @param message Message for alerts and toast
     */
    public GenericResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public GenericResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    
    
}
