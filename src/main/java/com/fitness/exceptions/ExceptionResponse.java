package com.fitness.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {

    //    private int errorCode; // No need of this as it will already be present in http response code
    private String message;
    private UUID uuid;
    private String uri;
    private Date timeStamp;

    public ExceptionResponse(String message, UUID uuid, String uri) {
        this.message = message;
        this.uuid = uuid;
        this.uri = uri;
        this.timeStamp = new Date();
    }


}
