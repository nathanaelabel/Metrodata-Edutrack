package com.metrodata.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseData<T> {

    private T data;
    private String message;
}