package com.edemarcos.tcc.app.config.security;

public class ErroDTO {
    private int status;
    private String message;

    public ErroDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErroDTO() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
