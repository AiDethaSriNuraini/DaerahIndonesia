package com.example.daerahindonesia;

import java.util.List;

public class SemuaKabupaten {
    private String error;
    private String message;
    private List<Kabupaten> kabupatens;

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

    public List<Kabupaten> getKabupatens() {
        return kabupatens;
    }

    public void setKabupatens(List<Kabupaten> kabupatens) {
        this.kabupatens = kabupatens;
    }
}
