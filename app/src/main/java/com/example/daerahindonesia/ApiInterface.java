package com.example.daerahindonesia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("daerahindonesia/provinsi")
    Call<SemuaProvinsi>getdaerah();

    @GET("daerahindonesia/provinsi/{id}/kabupaten")
    Call<SemuaKabupaten>getkabupaten(@Path("id")String id);

    @GET("daerahindonesia/provinsi/kabupaten/{idkabupaten}/kecamatan")
    Call<SemuaKecamatan>getkecamatan(@Path("idkabupaten")String idKecamatan);

    @GET("daerahindonesia/provinsi/kabupaten/kecamatan/{idkecamatannya}/desa")
    Call<SemuaDesa>getDesa(@Path("idkecamatannya")String idDesa);

}
