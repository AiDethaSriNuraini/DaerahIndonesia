package com.example.daerahindonesia;

import java.util.List;

public class SemuaDesa {
    private String error;
    private String message;
    private List<Desa>desas;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Desa> getDesas() {
        return desas;
    }

    public void setDesas(List<Desa> desas) {
        this.desas = desas;
    }
}
