package com.example.daerahindonesia;

import java.util.List;

public class SemuaKecamatan {

    private String error;
    private String message;
    private List<Kecamatan>kecamatans;

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

    public List<Kecamatan> getKecamatans() {
        return kecamatans;
    }

    public void setKecamatans(List<Kecamatan> kecamatans) {
        this.kecamatans = kecamatans;
    }
}
