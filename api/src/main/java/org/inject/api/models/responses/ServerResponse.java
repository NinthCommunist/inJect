package org.inject.api.models.responses;

import lombok.Data;

@Data
public class ServerResponse {

    private int code;
    private String type;
    private String message;

}
