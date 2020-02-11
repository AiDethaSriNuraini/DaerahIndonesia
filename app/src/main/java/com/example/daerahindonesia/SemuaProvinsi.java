package com.example.daerahindonesia;

import java.util.List;

public class SemuaProvinsi {
    private String error;
    private String message;
    private List<Daerah> semuaprovinsi;

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

    public List<Daerah> getSemuaprovinsi() {
        return semuaprovinsi;
    }

    public void setSemuaprovinsi(List<Daerah> semuaprovinsi) {
        this.semuaprovinsi = semuaprovinsi;
    }
}
