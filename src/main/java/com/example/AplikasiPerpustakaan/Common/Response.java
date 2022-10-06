package com.example.AplikasiPerpustakaan.Common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class Response {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer row;

    private HttpStatus status;

    public Response(Object data, String message, Integer row, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.row = row;
        this.status = status;
    }

    public Response(Object data, String message, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Response(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
